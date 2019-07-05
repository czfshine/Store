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
import {any, bool, number} from "prop-types";
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
        props.add();
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
                        请输入识别到的商品标示码：
                    </Typography>
                    <TextField
                        onChange={handleChange()}
                        margin="normal"
                    />
                    <br/>
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
    private jsxid:number;

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
        this.table.fetchData();
    }

    constructor(props) {
        super(props);
        this.storeid = 1;
        this.jsxid=0;
    }

    setInputGan(gan:number){
        this.inputGan=gan;
    }

    addProduct() {
        let url='/api/Product/gan/'+this.inputGan;
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
                        console.log(result);
                        let rowData = {
                            "EAN": result.gan,
                            "productname": result.name,
                            "pricing": result.pricing,
                            "count": 1,
                            "size": result.size,
                            "total": result.pricing,
                            "__treeId__": "" + this.jsxid
                        }
                        this.jsxid++;
                        this.table.addRow(rowData);
                        this.table.saveAllRow();
                    });
            } catch {}
        });
    }
    getTableValues(){
        var data = this.table.getData();
        console.log(data);
        fetch('/api/storage/check', {
            method: 'POST',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(data)
        }).then(respone =>respone.json()).then((res:any[])=>{
            if(res.length==0){

                Message['success']({
                    duration:10.0,
                    content: '提交成功,数据没有错误',
                    className: 'kuma-message-small',
                });
            }else{
                let str="";
                res.forEach((v)=>{
                    str+="商品："+v.name+"的实际数量为:"+v.recount;
                })

                Message['error']({
                    duration:30.0,
                    content: str,
                    className: 'kuma-message-small',
                });
            }

        });

        this.table.fetchData(); //清除所有数据咯
    }

    render() {
        const me = this;
        const columns = [
            { dataKey: "EAN", title: "商品编号", width: 200 },
            {
                dataKey: "productname",
                editKey: "productname",
                title: "商品名",
                width: 200,
            },
            {
                dataKey: "size",
                editKey: "size",
                title: "规格",
                width: 100,
            },
            {
                dataKey: "count",
                title: "数量",
                width: 100,
                type: "text"
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
            jsxdata:{
                data: []
            },
            className: "kuma-uxtable-split-line",
            actionBar: {
                模拟扫码: () => {
                    this.handleOpen();
                },
                新增行: () => {
                    me.table.addEmptyRow();
                }
            },
            jsxcolumns: columns
        };
        return (
            <div>
                <InputModal open = {this.state.open}  close={this.handleClose}
                            setGan={this.setInputGan.bind(this)}
                            selectId = {this.state.selectId}
                add = {this.addProduct.bind(this)}/>
                <Table
                    {...renderProps}
                    ref={c => {
                        this.table = c;
                    }}
                />
                <Button
                    onClick={me.getTableValues.bind(me)}
                    style={{ marginTop: "12px" }}
                >
                    提交
                </Button>
            </div>
        );
    }
}

export default CheckTable;