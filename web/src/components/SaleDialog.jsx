import React, { Component } from "react";
import "uxcore/assets/iconfont.css";
import "uxcore/assets/blue.css";
import { Button } from "uxcore";
import { Table } from "uxcore";
import { Icon } from "uxcore";
const { Constants } = Table;
const mockData = {
  data: []
};

class Demo extends Component {
  constructor(props) {
    super(props);
    this.state = {
      data: mockData,
      showOtherColumn: false
    };
    this.allGan = null;
  }
  getTableValues() {
    console.log(this.table.getData());
  }
  handleTableChange(data, dataKey, pass) {
    console.log(data.data);
  }
  addProduct(Gan) {}
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
        dataKey: "pricing",
        editKey: "pricing",
        title: "单价",

        width: 200,
        type: "text"
      },
      {
        dataKey: "count",
        title: "数量",
        width: 200,
        type: "text"
      },
      {
        dataKey: "total",
        title: "总价",
        width: 200,
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
              me.table.saveRow(rowData);
            },
            mode: Constants.MODE.EDIT
          },
          {
            title: "删除",
            callback: rowData => {
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
                    var a = Math.round(Math.random() * this.allGan.length);
                    this.addProduct(this.allGan[a]);
                  });
              } catch {}
            });
          } else {
            var a = Math.round(Math.random() * this.allGan.length);
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
        } else if (column.dataKey === "total") return "10";
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
export default Demo;
