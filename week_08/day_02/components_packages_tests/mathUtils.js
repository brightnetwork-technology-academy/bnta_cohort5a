"use strict";

// ... is called a 'rest parameter' when used in the definition
// of function signature

const sum = (...args) =>  {
    let total = 0;
    for(let num of args) {
        total += num;
    }

    return total;
} 

const product = (...args) => {
    let total = 1;
    for(let num of args) {
        total *= num;
    }
    return total;
}

module.exports = {sum, product};