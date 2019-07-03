import React from "react";
import ReactDOM from "react-dom";
import "./style/index.css";
import App from "./page/App";
import Sale from "./page/sale";
import * as serviceWorker from "./serviceWorker";
import { BrowserRouter as Router, Route, Link } from "react-router-dom";
import Sole from "./page/sole";
import Check from "./page/check";

/**
 * 项目入口点
 * typescript
 */

ReactDOM.render( //todo:另外两个页面
  <Router>
    <div>
        {/*根据url的内容路由组件*/}
      <Route path="/" exact component={App} />
      <Route path="/sale/" component={Sale} />
      <Route path="/sold/" component={Sole} />
      <Route path="/check/" component={Check} />
    </div>
  </Router>,
  document.getElementById("root")
);
// If you want your app to work offline and load faster, you can change
// unregister() to register() below. Note this comes with some pitfalls. Learn
// more about service workers: https://bit.ly/CRA-PWA
serviceWorker.unregister();
