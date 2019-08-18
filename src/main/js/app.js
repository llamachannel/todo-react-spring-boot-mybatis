'use strict';

const React = require('react');
const ReactDOM = require('react-dom');

class App extends React.Component {

  constructor(props) {
    super(props);
    this.handleNewItemTextChange = this.handleNewItemTextChange.bind(this);
    this.handleAddClick = this.handleAddClick.bind(this);
    this.handleToggleItem = this.handleToggleItem.bind(this);

    this.state = {
      error: null,
      isLoaded: false,
      // newItemText makes NewItemForm a "controlled component"
      newItemText: '',
      itemsMap: { },
      itemsList: [],
    };
  }

  componentDidMount() {
    fetch("/api/todo")
      .then(res => res.json())
      .then(
        (itemList) => {
          let itemMap = {};
          itemList.forEach(function(item) {
            itemMap[item.id] = item;
          });
          console.log("itemMap = ");
          console.log(itemMap);
          this.setState({
            isLoaded: true,
            itemsMap: itemMap,
            itemsList: itemList
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

    fetch('/api/todo', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(newItem),
    })
    .then(res => res.text())
    .then(
      (newId) => {
        newItem.id = parseInt(newId);
        //console.log("init newItem = ");
        //console.log(newItem);
        let addedBinding = {};
        addedBinding[newId] = newItem;
        this.setState(state => ({
          newItemText: '',
          // TODO: itemsMap with object assign?
          itemsMap: Object.assign({}, this.state.itemsMap, addedBinding),
          itemsList: this.state.itemsList.concat(newItem)
        }));
      });
  }


  handleToggleItem(id) {
    const itemIsCompleted = this.state.itemsMap[id].isCompleted;
    const subPath = itemIsCompleted ? 'complete' : 'uncomplete';

    console.log("hTI, itemsMap = ");
    console.log(this.state.itemsMap);

    fetch('/api/todo/'+id+'/'+subPath, {
      method: 'POST',
      body: '',
    })
    .then(res => res.text())
    .then(
      (newToggleState) => {
        console.log("handleToggleItem, newToggleState = ");
        console.log(newToggleState);
    });

  }

  render() {
    return (
      <div id="app">
        <h1>todoooo</h1>
        <NewItemForm
          handleAddClick={this.handleAddClick}
          newItemText={this.state.newItemText}
          handleNewItemTextChange={this.handleNewItemTextChange}/>
        <TodoList items={this.state.itemsList}/>
      </div>
    )
  }
}

class NewItemForm extends React.Component {
  render() {
    return (
      <div id="newItemForm">
        <input type="text" value={this.props.newItemText} onChange={this.props.handleNewItemTextChange}/>
        <button onClick={() => this.props.handleAddClick()}>add item</button>
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
      <div id="todoList">
        <ul>
          {items}
        </ul>
      </div>
    )
  }
}

class TodoItem extends React.Component {
  render() {
    return (
      <li>
        <input type="checkbox"/>
        <label>{this.props.item.id} -- {this.props.item.text} -- {this.props.item.isCompleted ? "is completed!" : "not completed"}</label>
      </li>
    )
  }
}

ReactDOM.render(
  <App />,
  document.getElementById('react')
)
