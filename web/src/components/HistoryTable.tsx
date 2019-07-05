
import * as React from "react";
import MaterialTable from "material-table";

import Typography from '@material-ui/core/Typography';
import Modal from '@material-ui/core/Modal';
import Button from '@material-ui/core/Button';
import {Theme} from "@material-ui/core";
import createStyles from "@material-ui/core/es/styles/createStyles";
import makeStyles from "@material-ui/styles/makeStyles";
import {bool, number} from "prop-types";
import { Message } from 'uxcore';


function getModalStyle() {
    const top = 50 ;
    const left = 50;

    return {
        top: `${top}%`,
        left: `${left}%`,
        transform: `translate(-${top}%, -${left}%)`,
    };
}

const useStyles = makeStyles((theme: Theme) =>
    createStyles({
        paper: {
            position: 'absolute',
            width: 800,
            backgroundColor: "#eeeeee",
            outline: 'none',
            padding:'18px'
        },
    }),
);

interface item {
    name:String,
    size:String,
    count:number;
    pricing:number,
    productId:number,//商品的id，隐藏
}
function transData(source:any) :item[]{
    const items:any[]=source.items;
    let res : item[] = [];

    items.forEach((v)=>{
        res.push({
            name : v.product.name,
            size : v.product.size,
            count: v.count,
            pricing:v.pricing,
            productId:v.id
        })
    });
    return res;
}


interface ReturnGoodsInfo {
    orderId:number,
    itemsIds:number[]
}
function EditModal(props) {
    const [modalStyle] = React.useState(getModalStyle);
    const classes = useStyles();
    let rs:item[];
    const click=()=>{
        let res:ReturnGoodsInfo;
        res={
            orderId:props.selectId,
            itemsIds:[]
        };
        rs.forEach((r)=>{
            res.itemsIds.push(r.items_id);
        });

        fetch('/api/order/return', {
            method: 'POST',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(res)
        }).then(()=>{
            // eslint-disable-next-line no-undef
            window.location.reload();
        });
        Message['success']({
            content: '提交成功',
            className: 'kuma-message-small',
        });
        props.close();
    };
    return (
        <div>
           <Modal
                aria-labelledby="simple-modal-title"
                aria-describedby="simple-modal-description"
                open={props.open}
                onClose={props.close}
            >
                <div style={modalStyle} className={classes.paper}>
                    <Typography variant="h6" id="modal-title">
                        订单详情
                    </Typography>
                    <MaterialTable
                        columns={[
                            {
                                title: "商品名称",
                                field: "name"
                            },
                            {
                                title: "商品规格",
                                field: "size"
                            },
                            {
                                title: "商品数量",
                                field: "count"
                            },
                            {
                                title: "商品价格",
                                field: "pricing"
                            },
                            {
                                title : "商品id",
                                field :"productId"
                            }
                        ]}
                        localization={{
                            toolbar: {
                                nRowsSelected:'有{0}个商品将被退货'
                            }
                        }}
                        options={{
                            selection: true
                        }}
                        onSelectionChange={(rows) => {
                            console.log(rows);
                            rs=rows
                        }}
                        data={query =>
                            new Promise((resolve, reject) => {
                                let url = "/api/order/getOne/"+props.selectId;
                                try {
                                    fetch(url)
                                        .then(response => response.json())
                                        .then((result:any[]) => {
                                            resolve({
                                                data: result,
                                                page: 0,
                                                totalCount: result.length
                                            });
                                        });
                                } catch {}
                            })
                        }
                        title="商品"
                    />

                    <div>
                        <Button size="small"
                                variant="contained"
                                color="primary" onClick={click}>退货</Button>
                    </div>

                </div>
            </Modal>
        </div>
    );
}

/**
 * 显示历史订单的表格
 */
class HistoryTable extends React.Component {
    state={
        open:bool,
        selectId:number
    };
    handleOpen = () => {
        this.setState({open : true});
    };

    handleClose = () => {
        this.setState({open:false})
    };


    constructor(props){
        super(props);
        this.setState({open:false});
    }
    componentDidMount(): void {
        this.setState({open:false});
    }

    render() {

        return (
            <div>
                <EditModal open = {this.state.open}  close={this.handleClose} selectId = {this.state.selectId} />
                <MaterialTable
                    columns={[
                        {
                            title: "订单id",
                            field: "id"
                        },
                        {
                            title: "商品总数",
                            field: "count"
                        },
                        {
                            title: "商品总价",
                            field: "totalPrice"
                        },
                        {
                            title: "创建时间",
                            field: "createTime"
                        }
                    ]}
                    actions={[
                        {
                            icon: 'save',
                            tooltip: '退货',
                            onClick: (event, rowData) => {
                                this.setState({selectId:rowData.id});
                                this.handleOpen();
                            }
                        }
                    ]}
                    data={query =>
                        new Promise((resolve, reject) => {
                            let url = "/api/order/getall";
                            try {
                                fetch(url)
                                    .then(response => response.json())
                                    .then(result => {
                                        resolve({
                                            data: result.data,
                                            page: 1,
                                            totalCount: 1
                                        });
                                    });
                            } catch {}
                        })
                    }
                    title="所有订单历史信息"
                />
            </div>

        );
    }
}
export default HistoryTable;