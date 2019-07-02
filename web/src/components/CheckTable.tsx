import * as React from "react"
import "uxcore/assets/iconfont.css";
import "uxcore/assets/blue.css";
import { Button } from "uxcore";
import { Table } from "uxcore";
import { Message } from 'uxcore';
import Modal from "@material-ui/core/Modal";
import Typography from "@material-ui/core/Typography";
import {Theme} from "@material-ui/core";
import createStyles from "@material-ui/core/es/styles/createStyles";
import makeStyles from "@material-ui/styles/makeStyles";
import {bool, number} from "prop-types";
import TextField from "@material-ui/core/es/TextField";
const { Constants } = Table;

/**
 **/

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

function InputModal(props) {
    const [modalStyle] = React.useState(getModalStyle);
    const classes = useStyles();
    const click=()=>{
        props.close();
    };
    const handleChange = () => (event: React.ChangeEvent<HTMLInputElement>) => {
        props.setGan(event.target.value);
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
                        退货窗口
                    </Typography>
                    <TextField
                        onChange={handleChange()}
                        margin="normal"
                    />
                    <Button size="small"
                                variant="contained"
                                color="primary" onClick={click}>确认</Button>

                </div>
            </Modal>
        </div>
    );
}


class CheckTable extends React.Component{
    private table: any;
    private storeid: number;

    private inputGan:number;

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
    componentDidMount(): void {
        this.setState({open:false});
    }
    constructor(props) {
        super(props);
        this.storeid = 1;
    }

    setInputGan(gan:number){
        this.inputGan=gan;
    }
    addProduct(Gan) {
        let url='/api/sale?';
        url+="productid="+Gan;
        url+="&storeid="+this.storeid;
        new Promise((resolve, reject) => {
            try {
                fetch(url)
                    .then(response => response.json())
                    .then(result => {
                        /*
                        {"id":102,"pricing":1.00,"product":{"proid":25,"name":"无糖薯片","size":"500g","gan":1315520554,
                        "inst":{..},
                        "store":{..}//todo
                         */
                        this.table.saveAllRow();
                        //this.setState({total:this.state.total+result.pricing});

                    });
                Message['success']({
                    content: `扫描到`+Gan,
                    className: 'kuma-message-small',
                });
            } catch {}
        });
    }

    render() {
        const me = this;
        const columns = [
            { dataKey: "EAN", title: "商品编号", width: 200, type: "text" },
            {
                dataKey: "productname",
                editKey: "productname",
                title: "商品名",
                width: 200,
                type: "text"
            },
            {
                dataKey: "size",
                editKey: "size",
                title: "规格",
                width: 100,
                type: "text"
            },
            {
                dataKey: "count",
                title: "数量",
                width: 100,
                type: "number"
            },
            {
                dataKey: "action1",
                title: "操作",
                width: 200,
                type: "action",
                actions: [
                    {
                        title: "编辑",
                        callback: rowData => {
                            me.table.editRow(rowData);
                        },
                        mode: Constants.MODE.VIEW
                    },
                    {
                        title: "保存",
                        callback: rowData => {
                            console.log(rowData)
                            me.table.saveRow(rowData);
                        },
                        mode: Constants.MODE.EDIT
                    },
                    {
                        title: "删除",
                        callback: rowData => {
                           // this.setState({total:this.state.total-rowData.total});
                            //rowdatamap[rowData.gan]=undefined;
                            me.table.delRow(rowData);
                        },
                        mode: Constants.MODE.VIEW
                    },
                    {
                        title: "重置",
                        callback: rowData => {
                            me.table.resetRow(rowData);
                        },
                        mode: Constants.MODE.EDIT
                    }
                ]
            }
        ];
        const renderProps = {
            showPager: false,
            fetchParams: {},
            //jsxdata: me.state.data,
            className: "kuma-uxtable-split-line",
            actionBar: {
                模拟扫码: () => {
                    this.handleOpen();
                },
                新增行: () => {
                    me.table.addEmptyRow();
                }
            },
            jsxcolumns: columns,
            processData: data => data,
        };
        return (
            <div>
                <InputModal open = {this.state.open}  close={this.handleClose}  setGan={this.setInputGan} selectId = {this.state.selectId} />
                <Table
                    {...renderProps}
                    ref={c => {
                        this.table = c;
                    }}
                />
                {/*<Button*/}
                {/*    onClick={me.getTableValues.bind(me)}*/}
                {/*    style={{ marginTop: "12px" }}*/}
                {/*>*/}
                {/*    提交*/}
                {/*</Button>*/}
            </div>
        );
    }
}

export default CheckTable;