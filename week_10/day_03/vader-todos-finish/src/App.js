import './App.css';
import TodoList from './TodoList';
import {useRef, useEffect } from 'react';
import usePersistedState from './usePersistedState';

function App() {
  // {name, id}
  // const [todos, setTodos] = useState(localStorage.getItem('todos') ? JSON.parse(localStorage.getItem('todos')) : []);
  const [todos, setTodos] = usePersistedState('todos', []);

  // bad example: hardcode, brute-force approach. localStorage key: value based. localStorage only accepts strings JSON.stringify etc...
  const [todoId, setTodoId] = usePersistedState('todoId', 0);
  const inputValueRef = useRef();
  /*
    this approach creates infinite loop
    if(localStorage.getItem('todos')){
      console.log('called');
      setTodos((prev)=> JSON.parse(localStorage.getItem('todos')));
    }
    else {
      localStorage.setItem('todos', JSON.stringify(todos));
    }
    */

  // useEffect(() => {
  //   localStorage.setItem('todos', JSON.stringify(todos));
  // }, [todos]);

/*   useEffect(() => {
    localStorage.setItem('todoId', JSON.stringify(todoId));
  }, [todoId]);
 */
  const handleAddTodo = () => {
    // 1. read the data from the input field
    // 2. add it to our state
    const name = inputValueRef.current.value;
    if (name === '') return;
    // don't do it like this:
    // setTodos(()=> {return [...todos, {name: name, id: name}]})
    // do it like this instead:
    setTodos(prevTodos => [...prevTodos, { name: name, id: todoId }]);
    // don't attempt side-effects in this way. use useEffect instead
    //document.title = `${todos.length} todos`;
    setTodoId(id => id += 1);
    inputValueRef.current.value = '';
  }

  useEffect(() => {
    document.title = `${todos.length} todos left`;
  }, [todos]);

  useEffect(() => {
    console.log(`todoId: `, todoId);
    console.log(`todos: `, todos);
  }, [todos, todoId]);

  const handleClearAll = (e) => {
    setTodos((prev) => []);
  }

  const removeTodo = (id) => {
    setTodos(prev => prev.filter(todo => todo.id !== id));
  }

  return (
    <div className="App">
      <h1>Darth Vader's Todo List ▼皿▼</h1>
      <p>I really must remember to...</p>
      <hr />
      <TodoList todos={todos} removeTodo={removeTodo} />
      <hr />
      <input ref={inputValueRef} type="text" ></input><button
        onClick={handleAddTodo}>Add Todo</button><button onClick={handleClearAll}>Clear All</button>
    </div>
  );
}

export default App;
