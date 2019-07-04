import React, {Component} from "react";
import client from "../data/client";

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