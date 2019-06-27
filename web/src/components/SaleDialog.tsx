/* eslint-disable react/react-in-jsx-scope */

import * as React from "react";
import "uxcore/assets/iconfont.css";
import "uxcore/assets/blue.css";
import { Button } from "uxcore";
import { Table } from "uxcore";
import { Icon } from "uxcore";
import getStoreId from "../data/store"
import { Message } from 'uxcore';
const { Constants } = Table;

const mockData = {
  data: []
};

const rowdatamap={};

export interface SaleDialogProps {
  
}

class SaleDialog extends React.Component {
  private allGan: any;
  private storeid: number;
  private jsxid: number;
  private table: any;
  state = {
    data: mockData,
    showOtherColumn: false,
    total:0.0
  };
  constructor(props) {
    super(props);

    this.allGan = null;
    this.storeid=0;
    this.jsxid=0;
  }

  componentWillMount(): void {
    getStoreId(this);
    this.setState({title:"销售窗口"})
  }
  getTableValues() {
    var data = this.table.getData();
    console.log(data);
    fetch('/api/order/post', {
      method: 'POST',
      headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(data)
    });
    Message['success']({
      content: '提交成功',
      className: 'kuma-message-small',
    });
    this.table.fetchData(); //清除所有数据咯

  }
  handleTableChange(data, dataKey, pass) {
    console.log(data.data);
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
              if(rowdatamap[Gan]==undefined){
                let rowData={
                  "EAN":result.product.gan,
                  "productname":result.product.name,
                  "pricing":result.pricing,
                  "count":1,
                  "size":result.product.size,
                  "total":result.pricing,
                  "__treeId__":""+this.jsxid
                }
                this.jsxid++;
                rowdatamap[Gan]=rowData;
                this.table.addRow(rowData);

              }else{
                let row=rowdatamap[Gan];
                this.table.delRow(rowdatamap[Gan])
                row.count+=1;
                row.total+=result.pricing;
                rowdatamap[Gan]=row;
                /**修改一行**/
                //todo:uxcore的api太难用了,下面是猥琐的方法:
                this.table.fetchData(); //清除所有数据咯
                for(var rowkey in rowdatamap){
                  this.table.addRow(rowdatamap[rowkey]);
                }
              }
              this.table.saveAllRow();
              this.setState({total:this.state.total+result.pricing});

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
        dataKey: "pricing",
        editKey: "pricing",
        title: "单价",
        width: 100,
        type: "text"
      },
      {
        dataKey: "count",
        title: "数量",
        width: 100,
        type: "text"
      },
      {
        dataKey: "total",
        title: "总价",
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
              this.setState({total:this.state.total-rowData.total});
              rowdatamap[rowData.gan]=undefined;
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
      jsxdata: me.state.data,
      className: "kuma-uxtable-split-line",
      actionBar: {
        模拟扫码: () => {
          if (this.allGan === null) {
            new Promise((resolve, reject) => {
              try {
                fetch("/api/getallgan")
                  .then(response => response.json())
                  .then(result => {
                    this.allGan = result.data;
                    console.log(this.allGan);
                    var a = Math.round(Math.random() * (this.allGan.length-1));
                    this.addProduct(this.allGan[a]);
                  });
              } catch {}
            });
          } else {
            var a = Math.round(Math.random() * (this.allGan.length-1));
            this.addProduct(this.allGan[a]);
          }
        },
        新增行: () => {
          me.table.addEmptyRow();
        }
      },
      jsxcolumns: columns,
      processData: data => data,
      onChange: me.handleTableChange,
      footer: ({ data, column, from, rowGroupData = {} }) => {
        if (column.dataKey === "count") {
          return (
              
            <div>
              <Icon usei name="biaoge1" /> 总计
            </div>
          );
        } else if (column.dataKey === "total") return <div>{this.state.total}</div>;
        return null;
      }
    };
    return (
      <div>
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
export default SaleDialog;
