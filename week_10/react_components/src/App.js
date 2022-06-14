import Greeting from './Greeting.js';
import ClickCounter from './ClickCounter.js';
import './App.css';

function App() {
  return (
    <>
    <div>Hello horse</div>
    <Greeting name='Stevo' />
    <ClickCounter stepSize = {5} />
    </>
  );
}

export default App;
