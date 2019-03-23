import React, {Component} from 'react';
import {Table} from 'uxcore';
import {Button} from 'uxcore';
import {Form} from 'uxcore';
import {Dialog} from 'uxcore';
import $ from 'jquery';
import '../page/product.css'

import Product from '../data/model/product.js'

import client from '../data/client.js'

/*
 * 从 Form 中取出 Form 的零件用以配置生成一个完整的 Form。
 * Form 的使用文档见：http://uxco.re/components/form/
 */

const {
  FormRow,
  InputFormField,
  OtherFormField,
  Validators,
  ButtonGroupFormField,
  TableFormField
} = Form;

class TableShower extends Component {
  constructor(props) {
    super(props);
    //get data
    var datas = {
      data: []
    };
    this.state = {
      fetchParams: {},
      editShow: false,
      newShow: false,
      editValues: null,
      data: datas
    };
    const me = this;
    function getData(link, name2) {
      var name = "";
      client({method: 'GET', path: link}).done(response => {
        console.log(response);
        name = response.entity._embedded[name2];
        me.state.data.data = name;
      });
      return name;
    }
    getData(new Product().link);
  }

  //todo
  handleSearch() {
    const me = this;
    const data = me
      .refs
      .searchForm
      .getValues();
    me.setState({
      fetchParams: data.values
    }, () => {
      me
        .refs
        .table
        .fetchData();
    });
  }

  toggleShow(key) {
    const me = this;
    const obj = {};
    obj[key] = !me.state[key];
    me.setState(obj);
  }

  handleEditOk() {
    const me = this;
    const data = me
      .refs
      .editForm
      .getValues();
    if (data.pass) {
      $.ajax({
        url: 'http://eternalsky.me:8122/file/writeGrid.jsonp',
        dataType: 'jsonp',
        data: {
          data: data.values
        },
        success(result) {
          if (result.success) {
            me.toggleShow('editShow');
            me
              .refs
              .table
              .fetchData();
          }
        }
      });
    }
  }

  handleEditCancel() {
    const me = this;
    me
      .refs
      .editForm
      .resetValues();
    me.toggleShow('editShow');
  }

  handleNewOk() {
    const me = this;
    const data = me
      .refs
      .editForm
      .getValues();
    if (data.pass) {
      $.ajax({
        url: 'http://eternalsky.me:8122/file/addNewData.jsonp',
        dataType: 'jsonp',
        data: {
          data: {
            dicts: {
              datas: [data.values]
            }
          }
        },
        success(result) {
          if (result.success) {
            me.toggleShow('newShow');
            me
              .refs
              .table
              .fetchData();
            me
              .refs
              .editForm
              .resetValues();
          }
        }
      });
    }
  }

  handleNewCancel() {
    const me = this;
    me.toggleShow('newShow');
    me
      .refs
      .editForm
      .resetValues();
  }

  showEditDialog(rowData) {
    this.setState({editShow: true, editValues: rowData});
  }

  showNewDialog() {
    this.setState({newShow: true, editValues: {}});
  }

  render() {
    const me = this;

    var columns = new Product().columns;
    console.log(columns)
    columns.concat([
      {
        dataKey: 'action1',
        title: '操作',
        width: 100,
        type: 'action',
        actions: {
          编辑(rowData, actions) {
            me.showEditDialog(rowData);
          }
        }
      }
    ]);

    const tableProps = {
      width: 1000,
      // fetchUrl: new Product().link, //todo processData:function(data){
      // console.log(data);   return data; },
      jsxdata: this.state.data,
      jsxcolumns: columns,
      fetchParams: me.state.fetchParams,
      actionBar: {
        新增() {
          me.showNewDialog();
        },
        删除() {
          console.log(me.selected);
        }
      },
      rowSelection: {
        onSelect(record, selected, selectedRows) {
          me.selected = selectedRows;
        },
        onSelectAll(selected, selectedRows) {
          me.selected = selectedRows;
        }
      }
    };

    const form = (
      <Form className="demoForm" jsxvalues={me.state.editValues} ref="editForm">
        <FormRow>
          <InputFormField
            jsxlabel="国家"
            jsxname="country"
            jsxrules={{
            validator: Validators.isNotEmpty,
            errMsg: '非空'
          }}/>
          <InputFormField jsxname="id" jsxshow={false}/>
        </FormRow>
        <FormRow>
          <InputFormField
            jsxlabel="城市"
            jsxname="city"
            jsxrules={{
            validator: Validators.isNotEmpty,
            errMsg: '非空'
          }}/>
          <InputFormField
            jsxlabel="email"
            jsxname="email"
            jsxrules={[
            {
              validator: Validators.isNotEmpty,
              errMsg: '非空'
            }, {
              validator: Validators.isEmail,
              errMsg: '请输入正确的 email 地址'
            }
          ]}/>
        </FormRow>
        <FormRow>
          <InputFormField
            jsxlabel="FirstName"
            jsxname="firstName"
            jsxrules={{
            validator: Validators.isNotEmpty,
            errMsg: '非空'
          }}/>
          <InputFormField
            jsxlabel="LastName"
            jsxname="lastName"
            jsxrules={{
            validator: Validators.isNotEmpty,
            errMsg: '非空'
          }}/>
        </FormRow>
      </Form>
    );

    return (
      <div className="page-demo3">
        <h2>增删改查</h2>
        <Form ref="searchForm" className="searchForm">
          <FormRow>
            <InputFormField
              jsxname="searchTxt"
              jsxshowLabel={false}
              jsxplaceholder="输入关键字进行查询"/>
            <OtherFormField className="searchButton">
              <Button onClick={me
                .handleSearch
                .bind(me)}>查询</Button>
            </OtherFormField>
          </FormRow>
        </Form>
        <Table {...tableProps} ref="table"/>
        <Dialog
          ref="editDialog"
          width={800}
          visible={me.state.editShow}
          title="数据编辑"
          onOk={me
          .handleEditOk
          .bind(me)}
          onCancel={me
          .handleEditCancel
          .bind(me)}>
          {form}
        </Dialog>
        <Dialog
          ref="newDialog"
          width={1000}
          visible={me.state.newShow}
          title="数据编辑"
          onOk={me
          .handleNewOk
          .bind(me)}
          onCancel={me
          .handleNewCancel
          .bind(me)}>
          {form}
        </Dialog>
      </div>
    );
  }

}
export default TableShower;