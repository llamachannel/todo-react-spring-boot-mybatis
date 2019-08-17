'use strict';

const React = require('react');
const ReactDOM = require('react-dom');

class App extends React.Component {

  constructor(props) {
    super(props);
    this.state = {
      error: null,
      isLoaded: false,
      items: [
        { "id": 1, "text": "a", isCompleted: false},
        { "id": 2, "text": "bee", isCompleted: false},
        { "id": 3, "text": "sea", isCompleted: false}
      ]
    };
  }

  componentDidMount() {
    fetch("/api/todo")
      .then(res => res.json())
      .then(
        (result) => {
          console.log("cDM, result = ");
          console.log(result);
          this.setState({
            isLoaded: true,
            items: result,
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
        <h1>todo</h1>
        <input type="text"/>
        <TodoList items={this.state.items}/>
      </div>
    )
  }
}

class TodoList extends React.Component {
  render() {
    console.log("TodoList, this.props = ");
    console.log(this.props);
    const items = this.props.items.map(item =>
      <TodoItem key={item.id} item={item}/>
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
      <li>{this.props.item.id} -- {this.props.item.text} -- {this.props.item.isCompleted ? "is completed!" : "not completed"}</li>
    )
  }
}

ReactDOM.render(
  <App />,
  document.getElementById('react')
)
