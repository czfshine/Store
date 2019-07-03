import * as React from "react"
import {Validator} from 'uxcore';
import {Button} from 'uxcore';
import {Select} from 'uxcore';
import {RadioGroup} from 'uxcore';
import {Table} from 'uxcore';
import {Typography} from "@material-ui/core";

import * as jQuery from "jquery"

const RadioItem = RadioGroup.Item;
const {Option} = Select;
const {Constants} = Table;
const mockData = {
    data: [],
};


class ImportTable extends React.Component {

    private table: any;
    state: {
        data: any,
        showOtherColumn: any
    };
    private list: any;

    constructor(props) {
        super(props);
        this.state = {
            data: mockData,
            showOtherColumn: false,
        };

    }

    getTableValues() {
        console.log(this.table.getData());
    }

    handleTableChange(data, dataKey, pass) {
        console.log(data.data);
    }

    render() {
        let url = "/api/a";
        // eslint-disable-next-line no-undef
        jQuery.ajax(url, {
            async: false,
            success: (re) => {
                console.log(re)
                let i = 0;
                let a: any[] = [];
                let res: any[] = [];
                a.forEach((v) => {
                    res.push({
                        id: i,
                        name: v,
                    })
                });


            }
        });
        this.list = [{
            id: "a",
            name: "b",
        }];
        fetch("url").then();
        const me = this;
        const columns = [

            {
                dataKey: 'vendorName',
                editKey: 'vendorName',
                title: '供应商',
                width: 200,
                type: 'select',
                renderChildren: () => this.list.map(item => <Option key={item.id}>{item.name}</Option>),
                config: {
                    filterOption: false,
                    // combobox:true
                }
            },
            {
                dataKey: 'productName',
                title: '商品名',
                width: 200,
                type: 'text',
                required: true,
            },
            {
                dataKey: 'productSize',
                title: '商品规格',
                width: 200,
                type: 'text',
                required: true,
            },
            {
                dataKey: 'count',
                title: '进货量',
                width: 200,
                type: 'number',
                required: true,
            },

            {
                dataKey: 'pricing',
                title: '进货价',
                width: 200,
                type: 'text',
                required: true,
            },
            {
                dataKey: 'action1',
                title: '操作',
                width: 200,
                type: 'action',
                actions: [
                    {
                        title: '编辑',
                        callback: (rowData) => {
                            me.table.editRow(rowData);
                        },
                        mode: Constants.MODE.VIEW,
                    },
                    {
                        title: '保存',
                        callback: (rowData) => {
                            me.table.saveRow(rowData);
                        },
                        mode: Constants.MODE.EDIT,
                    },
                    {
                        title: '删除',
                        callback: (rowData) => {
                            me.table.delRow(rowData);
                        },
                        mode: Constants.MODE.VIEW,
                    },
                    {
                        title: '重置',
                        callback: (rowData) => {
                            me.table.resetRow(rowData);
                        },
                        mode: Constants.MODE.EDIT,
                    },
                ],
            },
        ];
        const renderProps = {
            showPager: false,
            fetchParams: {},
            jsxdata: me.state.data,
            className: 'kuma-uxtable-split-line',
            actionBar: {
                新增行: () => {
                    me.table.addEmptyRow();
                },
            },
            jsxcolumns: columns,
            processData: data => data,
            onChange: me.handleTableChange,
        };

        return (
            <div>
                <Typography variant="h5" component="h3">
                    进货单
                </Typography>
                <Table {...renderProps} ref={(c) => {
                    this.table = c;
                }}/>
                <Button onClick={me.getTableValues.bind(me)} style={{marginTop: '12px'}}>提交</Button>
            </div>
        );
    }
}

export default ImportTable;