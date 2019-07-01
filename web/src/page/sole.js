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

/**
 * 销售页面组件
 */
function Sole(){
    return (
        <div className="App">
            <MiniDrawer
                lists={[
                    ["进货窗口", <InboxIcon />, "/sold/oder"],
                    ["历史记录", <MailIcon />, "/sold/all"],
                    ["统计信息-商品", <MailIcon />, "/sold/stats/product"],//todo
                    ["统计信息-销售", <MailIcon />, "/sold/stats/sale"],//todo
                    ["统计信息-库存", <MailIcon />, "/sold/stats/sold"],//todo
                    ["统计信息-类型", <MailIcon />, "/sold/stats/type"],//todo
                ]}
                title="进货端">

                <Route exact path="/sold/" component={AllTable} />
            </MiniDrawer>
        </div>
    );
}

export default Sole;
