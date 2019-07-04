import * as React from "react"
import MaterialTable from "material-table";

class HistoryImportTable extends  React.Component{
    render() {
        return (
            <MaterialTable
                columns={[
                    {
                        title: "商品名",
                        field: "proname"
                    },
                    {
                        title: "规格",
                        field: "size"
                    },
                    {
                        title: "供应商名字",
                        field: "vendorname"
                    },
                    {
                        title: "进货量",
                        field: "count"
                    },
                    {
                        title: "进货价",
                        field: "pricing"
                    },
                ]}
                data={query =>
                    new Promise((resolve, reject) => {
                        let url = "/api/sold/list?";
                        url += "size=" + query.pageSize;
                        url += "&page=" + query.page;
                        if(query.search.length != 0 ){
                            url += "&searchStr=" + query.search;
                        }

                        try {
                            fetch(url)
                                .then(response => response.json())
                                .then((result:any[]) => {
                                    console.log(result);
                                    resolve({
                                        data: result.slice(query.page*query.pageSize),
                                        page: query.page,
                                        totalCount: result.length
                                    });
                                });
                        } catch {}
                    })
                }
                title="进货历史"

            />
        );
    }
}

export default HistoryImportTable;