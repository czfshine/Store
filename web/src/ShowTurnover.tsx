import * as React from "react";
import {Typography} from "@material-ui/core";


class ShowTurnover extends React.Component{

    state:{
        title:string;
    };
    constructor(props) {
        super(props);
        this.state= {
            title:"载入中..."
        };
        //todo jiekou
        fetch("/api/store/turnover").then(res =>{

            let re=res.json();
            re.then(((v)=> {
                console.log(v);

                this.setState({title: v})
            }));
        })
    }


    render(){

        return <Typography variant="h3" component="h2" gutterBottom>
            总的销售额为：
            {this.state.title}
        </Typography>;
    }
}

export default ShowTurnover;