// 顶栏
import AppBar from "@material-ui/core/AppBar";
import Toolbar from "@material-ui/core/Toolbar";
import Typography from "@material-ui/core/Typography";
import * as React from "react";

function SimpleAppBar(props) {
    return (
        <div >
            <AppBar position="static" color="primary">
                <Toolbar>
                    <Typography variant="h6" color="inherit">
                        我的进销存系统
                    </Typography>
                </Toolbar>
            </AppBar>
        </div>
    );
}



export  default  (SimpleAppBar);
