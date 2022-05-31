"use strict";

// local, custom modules imported via relative path
const mathUtils = require('./mathUtils'); 
// npm packages are imported by the package name
const si = require('systeminformation');

// In the early days of JS, there were no components
// everything was on the global 
// in recent years, dedicated component system have been built

// 1. create a js file for your component, add all necessary attributes and behaviors, then export with module.exports
// 2. import the component into the desired file using the 'require' keyword

console.log(mathUtils.product(3, 10, 2, 4));
console.log(mathUtils.sum(10, 5, 3, 2));

si.baseboard().then((data)=> {
    console.log(data);
});