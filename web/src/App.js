import React, { Component } from 'react';
import './App.css';
import 'uxcore/assets/iconfont.css';
import 'uxcore/assets/orange.css';
import Demo from './page/product.js'
import MiniDrawer from './components/MiniDrawer.js'

import client from './data/client.js'

import TableShower from './components/TableShower.js'
class Employee extends React.Component{
	render() {
		return (
			<tr>
				<td>{this.props.employee.name}</td>
				<td>{this.props.employee.size}</td>
				<td>{this.props.employee.description}</td>
			</tr>
		)
	}
}
class EmployeeList extends React.Component{
	render() {
		const employees = this.props.employees.map(employee =>
			<Employee key={employee._links.self.href} employee={employee}/>
		);
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
		)
	}
}
class B extends Component {

	constructor(props) {
		super(props);
		this.state = {employees: []};
	}

	componentDidMount() {
    //TODO
		client({method: 'GET', path: '/data/products'}).done(response => {
			this.setState({employees: response.entity._embedded.products});
		});
	}

	render() {
		return (
			<EmployeeList employees={this.state.employees}/>
		)
	}
}
class App extends Component {
  render() {
    return (
      <div className="App">
          <MiniDrawer>
            <TableShower/>
        
          </MiniDrawer>
      </div>

    );
  }
}

export default App;
