import React, { Component } from "react";

import "uxcore/assets/iconfont.css";
import "uxcore/assets/orange.css";
import MiniDrawer from "../components/MiniDrawer.js";
import client from "../data/client.js";
import MaterialTable from "material-table";
import "../icon.css";
import InboxIcon from "@material-ui/icons/MoveToInbox";
import MailIcon from "@material-ui/icons/Mail";
import { BrowserRouter as Router, Route, Link } from "react-router-dom";

/**
 * 销售页面组件
 */

import SaleDialog from "../components/SaleDialog";
class Employee extends React.Component {
  render() {
    return (
      <tr>
        <td>{this.props.employee.name}</td>
        <td>{this.props.employee.size}</td>
        <td>{this.props.employee.description}</td>
      </tr>
    );
  }
}

class EmployeeList extends React.Component {
  render() {
    const employees = this.props.employees.map(employee => (
      <Employee key={employee._links.self.href} employee={employee} />
    ));
    return (
      <table>
        <tbody>
          <tr>
            <th>商品名</th>
            <th>规格</th>
            <th>Description</th>
          </tr>
          {employees}
        </tbody>
      </table>
    );
  }
}

class B extends Component {
  constructor(props) {
    super(props);
    this.state = {
      employees: []
    };
    this.storeid=0;
  }

  componentDidMount() {

    //TODO
    client({ method: "GET", path: "/data/products" }).done(response => {
      this.setState({ employees: response.entity._embedded.products });
    });
  }

  render() {
    return <EmployeeList employees={this.state.employees} />;
  }
}

class AllTable extends Component {
  render() {
    return (
      <MaterialTable
        columns={[
          {
            title: "商品名",
            field: "name"
          },
          {
            title: "规格",
            field: "size"
          }
        ]}
        data={query =>
          new Promise((resolve, reject) => {
            let url = "/data/products?";
            url += "size=" + query.pageSize;
            url += "&page=" + query.page;
            try {
              fetch(url)
                .then(response => response.json())
                .then(result => {
                  resolve({
                    data: result._embedded.products,
                    page: result.page.number,
                    totalCount: result.page.totalElements
                  });
                });
            } catch {}
          })
        }
        title="所有商品"
      />
    );
  }
}

class Sale extends Component {
  render() {
    return (
      <div className="App">
        <MiniDrawer
          lists={[
              ["售货窗口", <InboxIcon />, "/sale/oder"],
              ["历史订单", <MailIcon />, "/sale/all"],
              ["统计信息", <MailIcon />, "/sale/todo"],//todo
          ]}
          title="售货端"
        >
          <Route exact path="/sale/" component={AllTable} />
          <Route path="/sale/oder" component={SaleDialog} />
        </MiniDrawer>
      </div>
    );
  }
}

export default Sale;
