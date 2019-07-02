import * as React from "react"
import MaterialTable from "material-table";

class HistoryImportTable extends  React.Component{
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
                    },
                    {
                        title: "数量",
                        field: "count"
                    },
                    {
                        title: "供应商",
                        field: "vendorName"
                    },
                    {
                        title: "进货价",
                        field: "pricing"
                    }
                ]}
                data={query =>
                    new Promise((resolve, reject) => {
                        // let url = "/data/products?";
                        // url += "size=" + query.pageSize;
                        // url += "&page=" + query.page;
                        // query.search
                        // try {
                        //     fetch(url)
                        //         .then(response => response.json())
                        //         .then(result => {
                        //             resolve({
                        //                 data: result._embedded.products,
                        //                 page: result.page.number,
                        //                 totalCount: result.page.totalElements
                        //             });
                        //         });
                        // } catch {}
                    })
                }
                title="历史进货信息"

            />
        );
    }
}

export default HistoryImportTable;