// 卡片
import Card from "@material-ui/core/Card";
import CardContent from "@material-ui/core/CardContent";
import Typography from "@material-ui/core/Typography";
import Person from "@material-ui/core/SvgIcon/SvgIcon";
import CardActions from "@material-ui/core/CardActions";
import Button from "@material-ui/core/Button";
import * as PropTypes from "prop-types";
import {withStyles} from "@material-ui/core";
import * as React from "react";

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
    const {classes} = props;
    return (
        <Card className={classes.card}>
            <CardContent>
                <Typography variant="h5" component="h2">
                    <Person/> {props.name}
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
export default withStyles(cardstyles)(SimpleCard);
