import React from "react";
import ReactDOM from "react-dom";
import "./index.css";
import App from "./App";
import Sale from "./page/sale";
import * as serviceWorker from "./serviceWorker";
import { BrowserRouter as Router, Route, Link } from "react-router-dom";
console.log("code running...");
ReactDOM.render(
  <Router>
    <div>
      <Route path="/" exact component={App} />
      <Route path="/sale/" component={Sale} />
      <Route path="/sole/" component={App} />
      <Route path="/check/" component={App} />
    </div>
  </Router>,
  document.getElementById("root")
);
// If you want your app to work offline and load faster, you can change
// unregister() to register() below. Note this comes with some pitfalls. Learn
// more about service workers: https://bit.ly/CRA-PWA
serviceWorker.unregister();
