import React, { Component } from "react";
import "uxcore/assets/iconfont.css";
import "uxcore/assets/orange.css";
import MiniDrawer from "../components/framework/MiniDrawer.tsx";
import "../style/icon.css";
import InboxIcon from "@material-ui/icons/MoveToInbox";
import MailIcon from "@material-ui/icons/Mail";
import {Route} from "react-router";
import ImportTable from "../components/ImportTable.tsx";
import HistoryImportTable from "../components/HistoryImportTable.tsx";
import VendorTable from "../components/VendorTable.tsx";
import PushTable from "../components/PushTable.tsx";

/**
 * 销售页面组件
 */
function Sole(){
    return (
        <div className="App">
            <MiniDrawer
                lists={[
                    ["进货单", <InboxIcon />, "/sold/import"],
                    ["查看历史进货信息", <MailIcon />, "/sold/historyImport"],
                    ["查看供应商", <MailIcon />, "/sold/vendor"],//todo
                    ["上货", <MailIcon />, "/sold/pushGoods" ]
                ]}
                title="进货端">

                <Route exact path="/sold/" component={ImportTable} />
                <Route exact path="/sold/import" component={ImportTable} />
                <Route exact path="/sold/historyImport" component={HistoryImportTable} />
                <Route exact path="/sold/vendor" component={VendorTable} />
                <Route exact path="/sold/pushGoods" component={PushTable} />
            </MiniDrawer>
        </div>
    );
}

export default Sole;
