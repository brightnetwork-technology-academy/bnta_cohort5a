import { useState, useEffect } from 'react';
// custom hooks should begin with 'use':
const usePersistedState = (key, initialValue) => {
    // initialize useState, return getters and setter. DONE
    // retain pointers to same getters and setter HERE. DONE
    // use useEffect to update localStorage whenever the state changes. WORKING
    // refactor the localStorage.getItem check into this hood. TESTING
    // localStorage.getItem('todos') ? JSON.parse(localStorage.getItem('todos')) : []. 
    // resolve weird errors in devtools. 
    const lsItem = localStorage.getItem(key);
    const [value, setValue] = useState(lsItem !== null ? JSON.parse(lsItem) : initialValue);

    useEffect(() => {
        localStorage.setItem(key, JSON.stringify(value));
    }, [value]);

    return [value, setValue];
}

export default usePersistedState;