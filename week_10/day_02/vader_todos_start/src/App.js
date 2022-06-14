import './App.css';
import TodoList from './TodoList';
import {useState, useRef} from 'react';

function App() {
  // {name, id}
  const [todos, setTodos] = useState([]);
  const inputValueRef = useRef();

  const handleAddTodo = ()=> {
    // 1. read the data from the input field
    // 2. add it to our state
    const name = inputValueRef.current.value;
    setTodos(prevTodos => [...prevTodos, {name: name, id: name }]);
  }

  return (
    <div className="App">
      <h1>Darth Vader's Todo List ▼皿▼</h1>
      <p>I really must remember to...</p>
      <hr />
      <TodoList todos={todos}/>
      <hr />
      <input ref={inputValueRef} type="text"></input><button 
      onClick={handleAddTodo}>Add Todo</button>
    </div>
  );
}

export default App;
