import React, { Component } from 'react';
import './App.css';
import 'uxcore/assets/iconfont.css';
import 'uxcore/assets/orange.css';
import Demo from './page/product.js'
import MiniDrawer from './components/MiniDrawer.js'
import client from './data/client.js'
import TableShower from './components/TableShower.js'
import MaterialTable from 'material-table'
import './icon.css';
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
					<MaterialTable
  columns={[
    {
      title: 'Avatar',
      field: 'avatar',
      render: rowData => (
        <img
          style={{ height: 36, borderRadius: '50%' }}
          src={rowData.avatar}
        />
      ),
    },
    { title: 'Id', field: 'id' },
    { title: 'First Name', field: 'first_name' },
    { title: 'Last Name', field: 'last_name' },
  ]}
  data={query =>
    new Promise((resolve, reject) => {
      let url = 'https://reqres.in/api/users?'
      url += 'per_page=' + query.pageSize
      url += '&page=' + (query.page + 1)
      fetch(url)
        .then(response => response.json())
        .then(result => {
          resolve({
            data: result.data,
            page: result.page - 1,
            totalCount: result.total,
          })
        })
    })
  }
  title="Remote Data Example"
/>
          </MiniDrawer>
      </div>

    );
  }
}

export default App;
