import React, { Component } from 'react';
import './App.css';
import 'uxcore/assets/iconfont.css';
import 'uxcore/assets/orange.css';
import Demo from './page/product.js'
import MiniDrawer from './components/MiniDrawer.js'
class App extends Component {
  render() {
    return (
      <div className="App">
          <MiniDrawer>
            <Demo/>
          </MiniDrawer>
      </div>

    );
  }
}

export default App;
