import React from 'react';


const Todo = ({name, id, removeTodo})=> {
    return (
        // to use an invoked function as callback, wrap it in an arrow function:
        <li key={id}>{name} <button onClick={()=>{removeTodo(id)}}> Remove </button></li>
    );
}


/* class Todo extends React.Component {
    constructor({ name, id, removeTodo }) { // using the destructuring syntax allows you see what your props are at a glance
        super({ name, id, removeTodo });
        // state is handled by state property as object literal
        this.state = {
            foo: 'bar'
        }
        // this.setState()
    }

    render() {
        return (
            <li key={this.props.id}>{this.props.name} <button onClick={() => { this.props.removeTodo(this.props.id) }}>Remove</button></li>
        );
    }
} */

export default Todo;