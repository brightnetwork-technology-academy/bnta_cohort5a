import Todo from './Todo';

const TodoList = ({todos})=> {
    return (
        <ul>
            {todos.map(todo => <Todo name={todo.name} id={todo.id}  />)}
        </ul>
    );
}

export default TodoList;