import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';
import { Button } from 'uxcore';
import 'uxcore/assets/iconfont.css';
import 'uxcore/assets/orange.css';
import Demo from './page/product.js'
import Index from './page/mater.js'

class App extends Component {
  render() {
    return (
      <div className="App">
        <Demo/>
          <Button> test Button</Button>
          <Index/>
      </div>
    );
  }
}

export default App;
