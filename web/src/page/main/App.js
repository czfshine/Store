import React, {Component} from 'react';
import './App.css';
import 'uxcore/assets/iconfont.css';
import 'uxcore/assets/orange.css';
import MiniDrawer from '../../components/MiniDrawer.js'
import client from '../../data/client.js'
import MaterialTable from 'material-table'
import '../../icon.css';
class Employee extends React.Component {
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
class EmployeeList extends React.Component {
		render() {
				const employees = this
						.props
						.employees
						.map(employee => <Employee key={employee._links.self.href} employee={employee}/>);
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
				this.state = {
						employees: []
				};
		}

		componentDidMount() {
				//TODO
				client({method: 'GET', path: '/data/products'}).done(response => {
						this.setState({employees: response.entity._embedded.products});
				});
		}

		render() {
				return (<EmployeeList employees={this.state.employees}/>)
		}
}
/**
 * url += 'per_page=' + query.pageSize
			url += '&page=' + (query.page + 1)
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
 */

class App extends Component {
		render() {
				return (
						<div className="App">
								<MiniDrawer>
										<MaterialTable
												columns={[
												{
														title: '商品名',
														field: 'name'
												}, {
														title: '规格',
														field: 'size'
												}
										]}
												data={query => new Promise((resolve, reject) => {
												let url = '/data/products?' url += 'size=' + query.pageSize url += '&page=' + (query.page)fetch(url)
														.then(response => response.json())
														.then(result => {
																resolve({data: result._embedded.products, page: result.page.number, totalCount: result.page.totalElements})
														})
										})}
												title="Remote Data Example"/>
								</MiniDrawer>
						</div>

				);
		}
}

export default App;
