import * as React from "react"
import MaterialTable from "material-table";

class VendorTable extends  React.Component{
    render() {
        return (
            <MaterialTable
                columns={[
                    {
                        title: "供应商姓名",
                        field: "name"
                    },
                    {
                        title: "位置",
                        field: "location"
                    }
                ]}
                data={query =>
                    new Promise((resolve, reject) => {
                        let url = "/api/vendor/list?";
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
                title="历史进货信息"

            />
        );
    }
}

export default VendorTable;