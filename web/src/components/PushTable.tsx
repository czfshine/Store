import * as React from "react"
import { Validator } from 'uxcore';
import { Button } from 'uxcore';
import { Select } from 'uxcore';
import { RadioGroup } from 'uxcore';
import { Table } from 'uxcore';
const RadioItem = RadioGroup.Item;
const { Option } = Select;
const { Constants } = Table;
const mockData = {
    data: [
        {
            email: 'xw@abc.com',
            nameId: 'xiaowang',
            name: '小王',
            cityId: 'bj',
            city: '北京',
        },
        {
            email: 'xl@abc.com',
            nameId: 'xiaoli',
            name: '小李',
            cityId: 'hz',
            city: '杭州',
        },
    ],
};

class PushTable extends  React.Component{

    private table:any;
    state:{
        data:any,
        showOtherColumn:any
    };
    constructor(props) {
        super(props);
        this.state = {
            data: mockData,
            showOtherColumn: false,
        };
        // new Promise((resolve, reject) => {
        //     let url = "/api/storage/list?";
        //     try {
        //         fetch(url)
        //             .then(response => response.json())
        //             .then((result:any[]) => {
        //                 this.setState({data:result})
        //             });
        //     } catch {}
        // })
    }


    getTableValues() {
        console.log(this.table.getData());
        var data = this.table.getData();
        fetch('/api/sale/post', {
            method: 'POST',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(data)
        }).then(()=>{
            this.table.fetchData(); //清除所有数据咯
        });

    }

    handleTableChange(data, dataKey, pass) {
        console.log(data.data);
    }

    render() {
        const me = this;
        const columns = [
            {
                title: "商品名",
                dataKey: "name"
            },
            {
                title: "规格",
                dataKey: "size"
            },
            {
                title: "数量",
                dataKey: "count"
            },
            {
                title: "进货价",
                dataKey: "pricing"
            },
            {
                dataKey: 'outPricing',
                title: '销售价',
                width: 200,
                type: 'text',
                required: true,
            },
            { dataKey: 'action1',
                title: '操作1',
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
            fetchUrl: '/api/sold/nosale',
            className: 'kuma-uxtable-split-line',
            jsxcolumns: columns,
            processData: data => data,
            onChange: me.handleTableChange,
        };

        return (
            <div>
                <Table {...renderProps} ref={(c) => { this.table = c; }} />
                <Button onClick={me.getTableValues.bind(me)} style={{ marginTop: '12px' }}>提交</Button>
            </div>
        );
    }
}

export default PushTable;