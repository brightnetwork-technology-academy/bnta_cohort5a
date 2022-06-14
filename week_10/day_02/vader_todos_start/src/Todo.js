const Todo = ({name, id})=> {
    return (
        <li key={id}>{name}</li>
    );
}

export default Todo;