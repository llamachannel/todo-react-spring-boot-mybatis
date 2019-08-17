'use strict';

const React = require('react');
const ReactDOM = require('react-dom');

class App extends React.Component {

  constructor(props) {
    super(props);
    this.handleNewItemTextChange = this.handleNewItemTextChange.bind(this);
    this.handleAddClick = this.handleAddClick.bind(this);

    this.state = {
      error: null,
      isLoaded: false,
      // newItemText makes NewItemForm a "controlled component"
      newItemText: '',
      items: [
        { id: 1, text: "a", isCompleted: false},
        { id: 2, text: "bee", isCompleted: false},
        { id: 3, text: "sea", isCompleted: false}
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

  handleNewItemTextChange(ev) {
    this.setState({newItemText: ev.target.value});
  }

  handleAddClick() {
    let newItem = {
      text: this.state.newItemText,
      isCompleted: false
    };
    // TODO: POST new item to rest API, get new id back?
    console.log("init newItem = ");
    console.log(newItem);
    fetch('/api/todo', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(newItem),
    })
    .then(function(res) {
      console.log(res);
      console.log("trying to PRINT JSON!!!!!!!!!!!!!!!");
      return res.text();
    })
    .then(function(newId) {
      console.log("then2, newItem = ");
      console.log(newId);
      newItem.id = newId;
      this.setState(state => ({
        newItemText: '',
        items: this.state.items.concat(newItem)
      }));
    });
  }

  render() {
    return (
      <div>
        <h1>todo</h1>
        <NewItemForm
          handleAddClick={this.handleAddClick}
          newItemText={this.state.newItemText}
          handleNewItemTextChange={this.handleNewItemTextChange}/>
        <TodoList items={this.state.items}/>
      </div>
    )
  }
}

class NewItemForm extends React.Component {
  render() {
    return (
      <div id="newItemForm">
        <input type="text" value={this.props.newItemText} onChange={this.props.handleNewItemTextChange}/>
        <button onClick={() => this.props.handleAddClick()}>add</button>
      </div>
    );
  }
}

class TodoList extends React.Component {
  render() {
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
