import React from "react";
import "uxcore/assets/iconfont.css";
import "uxcore/assets/orange.css";
import MiniDrawer from "../components/framework/MiniDrawer.tsx";
import "../style/icon.css";
import InboxIcon from "@material-ui/icons/MoveToInbox";
import MailIcon from "@material-ui/icons/Mail";
import { Route} from "react-router-dom";
import SaleDialog from "../components/SaleDialog.tsx";
import HistoryTable from "../components/HistoryTable.tsx"
import ShowTurnover from "../ShowTurnover.tsx";
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
                    //["退货",<MailIcon />, "/sale/return"],
                    ["查看总销售额",<MailIcon />, "/sale/showTurnover"],
                    ]}
                title="售货端">

                <Route exact path="/sale/" component={SaleDialog} />
                <Route path="/sale/oder" component={SaleDialog} />
                <Route path="/sale/all" component={HistoryTable} />
                {/*<Route path="/sale/return" component={ReturnDialog} />*/}
                <Route path="/sale/showTurnover" component={ShowTurnover} />
            </MiniDrawer>
        </div>
    );
}
export default Sale;