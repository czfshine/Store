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
                        title: "数量",
                        field: "count"
                    },
                    {
                        title: "条形码",
                        field: "gan"
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
                title="所有商品库存"
            />
        );
    }
}
export default AllTable;