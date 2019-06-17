// 顶栏
import AppBar from "@material-ui/core/AppBar";
import Toolbar from "@material-ui/core/Toolbar";
import Typography from "@material-ui/core/Typography";
import  * as PropTypes from "prop-types";
import {withStyles} from "@material-ui/core";
import * as React from "react";

function SimpleAppBar(props) {
    const { classes } = props;

    return (
        <div className={classes.root}>
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
