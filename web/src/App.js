import React, { Component } from 'react';
import './App.css';
import 'uxcore/assets/iconfont.css';
import 'uxcore/assets/orange.css';
import Demo from './page/product.js'
import MiniDrawer from './components/MiniDrawer.js'

import client from './client.js'
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
						<th>First Name</th>
						<th>Last Name</th>
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
		client({method: 'GET', path: 'http://localhost:8080/data/products'}).done(response => {
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
            <B></B>
            
          </MiniDrawer>
      </div>

    );
  }
}

export default App;
