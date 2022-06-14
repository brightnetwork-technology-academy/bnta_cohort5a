
const exponentiate = (val, exp) => {
    for(let i = 1; i <= exp; i++) val *= 10;
    return val;
}

const val = '5';
const exp = 3;
console.log(Number(val + `e+${exp}`));
console.log(exponentiate(val, exp));

console.log(Number.MAX_SAFE_INTEGER);
console.log(2^20000);