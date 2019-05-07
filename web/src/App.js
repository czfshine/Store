import React, { Component } from "react";
import "./App.css";
import "./icon.css";
import PropTypes from "prop-types";
import { withStyles } from "@material-ui/core/styles";
import Card from "@material-ui/core/Card";
import CardActions from "@material-ui/core/CardActions";
import CardContent from "@material-ui/core/CardContent";
import Button from "@material-ui/core/Button";
import Typography from "@material-ui/core/Typography";
import Grid from "@material-ui/core/Grid";
import Paper from "@material-ui/core/Paper";
import AppBar from "@material-ui/core/AppBar";
import Toolbar from "@material-ui/core/Toolbar";
import Person from "@material-ui/icons/Person";
import { Link } from "react-router-dom";

/**
 *首页，登录界面等
 *
 */

// 卡片

const cardstyles = {
  card: {
    minWidth: 275,
    maxWidth: 300
  },
  bullet: {
    display: "inline-block",
    margin: "0 2px",
    transform: "scale(0.8)"
  },
  title: {
    fontSize: 14
  },
  pos: {
    marginBottom: 12
  }
};

//卡片组件
function SimpleCard(props) {
  const { classes } = props;

  return (
    <Card className={classes.card}>
      <CardContent>
        <Typography variant="h5" component="h2">
          <Person /> {props.name}
        </Typography>
        <Typography className={classes.pos} color="textSecondary">
          免登录
        </Typography>
        <Typography component="p">{props.datas}</Typography>
      </CardContent>
      <CardActions>
        <Button
          href={props.to}
          size="small"
          variant="contained"
          color="primary"
        >
          登录
        </Button>
      </CardActions>
    </Card>
  );
}
SimpleCard.propTypes = {
  classes: PropTypes.object.isRequired
};
SimpleCard = withStyles(cardstyles)(SimpleCard);

// 表格布局

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

GuttersGrid = withStyles(styles)(GuttersGrid);

// 顶栏
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

SimpleAppBar.propTypes = {
  classes: PropTypes.object.isRequired
};

SimpleAppBar = withStyles(styles)(SimpleAppBar);

//页面组件
class App extends Component {
  render() {
    return (
      <div className="App">
        <SimpleAppBar />
        <Typography
          style={{
            margin: 30
          }}
          color="primary"
          component="h4"
          variant="h4"
        >
          选择你要登录的角色:
        </Typography>
        <GuttersGrid />
      </div>
    );
  }
}

export default App;
