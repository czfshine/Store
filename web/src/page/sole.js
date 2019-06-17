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
                    ["售货窗口", <InboxIcon />, "/sale/oder"],
                    ["历史订单", <MailIcon />, "/sale/all"],
                    ["统计信息", <MailIcon />, "/sale/todo"],//todo
                ]}
                title="进货端">

                <Route exact path="/sale/" component={AllTable} />
                <Route path="/sale/oder" component={SaleDialog} />
            </MiniDrawer>
        </div>
    );
}

export default Sole;