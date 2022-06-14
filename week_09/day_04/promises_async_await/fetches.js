// fetch api not implemented in node natively - this library fixes that
import fetch from 'node-fetch';

//const highwood = fetch('http://www.highwoodeducation.com');

const fetchData = async (url) => {
    try{
        const response = await fetch(url);
     //  const json = await response.body.;
        
    } catch (err) {
        console.log(err);
    }
}

fetchData('http://www.highwoodeducation.com');


