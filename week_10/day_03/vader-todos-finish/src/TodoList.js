import Todo from './Todo';

const TodoList = ({todos, removeTodo})=> {
    return (
        <ul>
            {todos.map(todo => <Todo key = {todo.id} name={todo.name} id={todo.id} 
            removeTodo={removeTodo} />)}
        </ul>
    );
}

export default TodoList;