import React, { Component } from "react";
import "uxcore/assets/iconfont.css";
import "uxcore/assets/orange.css";
import MiniDrawer from "../components/framework/MiniDrawer.tsx";
import "../style/icon.css";
import InboxIcon from "@material-ui/icons/MoveToInbox";
import MailIcon from "@material-ui/icons/Mail";
import { Route} from "react-router-dom";
import SaleDialog from "../components/SaleDialog.tsx";
import AllTable from "../components/AllTable.tsx"
import HistoryTable from "../components/HistoryTable.tsx"
/**
 * 销售页面组件
 */
function Sale (){
    return (
        <div className="App">
            <MiniDrawer
                lists={[
                    ["售货窗口", <InboxIcon />, "/sale/oder"],
                    ["历史订单", <MailIcon />, "/sale/all"],
                    ["统计信息-商品", <MailIcon />, "/sale/stats/product"],//todo
                    ["统计信息-销售", <MailIcon />, "/sale/stats/sale"],//todo
                    ["统计信息-库存", <MailIcon />, "/sale/stats/sold"],//todo
                    ["统计信息-类型", <MailIcon />, "/sale/stats/type"],//todo
                ]}
                title="售货端">

                <Route exact path="/sale/" component={AllTable} />
                <Route path="/sale/oder" component={SaleDialog} />
                <Route path="/sale/all" component={HistoryTable} />
                <Route path="/sale/stats/product" component={AllTable} />
                <Route path="/sale/stats/sale" component={HistoryTable} />
                <Route path="/sale/stats/sold" component={HistoryTable} />
                <Route path="/sale/stats/type" component={HistoryTable} />

            </MiniDrawer>
        </div>
    );
}

export default Sale;
