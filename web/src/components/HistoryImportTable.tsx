import * as React from "react"
import MaterialTable from "material-table";

class HistoryImportTable extends  React.Component{
    render() {
        return (
            <MaterialTable
                columns={[
                    {
                        title: "供应商名字",
                        field: "name"
                    },
                    {
                        title: "供应商位置",
                        field: "location"
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
                title="供应商列表"

            />
        );
    }
}

export default HistoryImportTable;