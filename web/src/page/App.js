import React from "react";
import "../style/App.css";
import "../style/icon.css";
import Typography from "@material-ui/core/Typography";
import SimpleAppBar from  "../components/SimpleAppBar.tsx"
import GuttersGrid from "../components/GuttersGrid.jsx"
/**
 *首页，登录界面等
 *
 */


//页面组件
function App(){
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
        <GuttersGrid  />
      </div>
  );
}
export default App;
