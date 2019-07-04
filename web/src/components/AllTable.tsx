// @ts-ignore
import React, {Component} from "react";
import MaterialTable from "material-table";

/**
 * 显示所有商品的表格
 */
class AllTable extends Component {
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
                        title: "识别码",
                        field: "gan"
                    },
                    {
                        title: "库存",
                        field: "count"
                    },
                ]}
                data={query =>
                    new Promise((resolve, reject) => {
                        let url = "/api/storage/list?";
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
                title="所有商品"
            />
        );
    }
}
export default AllTable;