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
import CheckTable from "../components/CheckTable.tsx";

/**
 * 销售页面组件
 */
function Check() {
    return (
        <div className="App">
            <MiniDrawer
                lists={[
                    ["清点", <MailIcon />, "/check/do"],
                    ["所有库存", <InboxIcon />, "/check/all"]
                ]}
                title="清点端">
                <Route exact path="/check/" component={CheckTable} />
                <Route exact path="/check/do" component={CheckTable} />
                <Route exact path="/check/all" component={AllTable} />
            </MiniDrawer>
        </div>
    );
}
export default Check;
