'use strict';

const React = require('react');
const ReactDOM = require('react-dom');

class App extends React.Component {

  constructor(props) {
    super(props);
    this.state = {
      error: null,
      isLoaded: false,
      items: []
    };
  }

  componentDidMount() {
    fetch("/api/todo")
      .then(res => res.json())
      .then(
        (result) => {
          this.setState({
            isLoaded: true,
            items: result.items
          });
        },
        // Note: it's important to handle errors here
        // instead of a catch() block so that we don't swallow
        // exceptions from actual bugs in components.
        (error) => {
          this.setState({
            isLoaded: true,
            error
          });
        }
      )
  }

  render() {
    return (
      <div>
        <input type="text"/>
        <TodoList items={this.state.items}/>
      </div>
    )
  }
}

class TodoList extends React.Component {
  render() {
    const items = this.props.items.map((item, i) =>
      <TodoItem key={item.item.id} item={item.item}/>
    );
    return (
      <div>
        <ul id="item-list">
          {items}
        </ul>
      </div>
    )
  }
}

class TodoItem extends React.Component {
  render() {
    return (
      <li>{this.props.text}</li>
    )
  }
}

ReactDOM.render(
  <App />,
  document.getElementById('react')
)
