// 表格布局

import React from "react";
import Grid from "@material-ui/core/Grid";
import Paper from "@material-ui/core/Paper";
import SimpleCard from "./SimpleCard.tsx";
import PropTypes from "prop-types";
import {withStyles} from "@material-ui/core";

const styles = {
    root: {
        flexGrow: 1
    },
    paper: {
        margin: 10
    },
    control: {
        padding: 10
    }
};


class GuttersGrid extends React.Component {
    state = {
        spacing: "16"
    };

    handleChange = key => (event, value) => {
        this.setState({ [key]: value });
    };

    render() {
        const { classes } = this.props;
        return (
            <Grid container className={classes.root} spacing={14}>
                <Grid item xs={12}>
                    <Grid
                        container
                        className={classes.demo}
                        justify="center"
                        spacing={20}
                    >
                        <Grid key="1" item>
                            <Paper className={classes.paper}>
                                <SimpleCard to="sale" name="售货员" datas="我是一个售货员" />
                            </Paper>
                        </Grid>
                        <Grid key="2" item>
                            <Paper className={classes.paper}>
                                <SimpleCard to="sole" name="进货员" datas="我是一个进货员" />
                            </Paper>
                        </Grid>
                        <Grid key="2" item>
                            <Paper className={classes.paper}>
                                <SimpleCard to="check" name="清点员" datas="我是一个清点员" />
                            </Paper>
                        </Grid>
                    </Grid>
                </Grid>
            </Grid>
        );
    }
}

GuttersGrid.propTypes = {
    classes: PropTypes.object.isRequired
};

export  default withStyles(styles)(GuttersGrid);
