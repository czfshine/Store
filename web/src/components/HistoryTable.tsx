// @ts-ignore
import React, {Component} from "react";
import MaterialTable from "material-table";

/**
 * 显示历史订单的表格
 */
class HistoryTable extends Component {
    render() {
        return (
            <MaterialTable
                columns={[
                    {
                        title: "创建时间",
                        field: "ordertime"
                    }
                ]}
                data={query =>
                    new Promise((resolve, reject) => {
                        let url = "/data/orderses?";
                        url += "size=" + query.pageSize;
                        url += "&page=" + query.page;
                        try {
                            fetch(url)
                                .then(response => response.json())
                                .then(result => {
                                    resolve({
                                        data: result._embedded.orderses,
                                        page: result.page.number,
                                        totalCount: result.page.totalElements
                                    });
                                });
                        } catch {}
                    })
                }
                title="所有订单信息"
            />
        );
    }
}
export default HistoryTable;