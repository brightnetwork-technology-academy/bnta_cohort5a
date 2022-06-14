// use memoization to efficiently calculate the factorials of a series of numbers. return the factorial + the number of calculations
// it took to return it

var cache = {};
var calculationsPerformed = 0;

function factorial(value) {
    if (value <= 1) return value;

    const cached = cache[value];
    if (cached != null) {
        return cached;
    }

    const result = value * factorial(value - 1);
    cache[value] = result;
    calculationsPerformed++;
    return result;
};

const solution = (numbersToCalculate) => {
    var results = [];
    for (value of numbersToCalculate) {
        calculationsPerformed = 0;
        const result = factorial(value);
        results.push([result, calculationsPerformed]);
        calculationsPerformed = 0;
        //cache[value] = result;
    }

    // reset cache after each call to solution
    cache = {};
    return results;
}

console.log(solution([40, 29]));
