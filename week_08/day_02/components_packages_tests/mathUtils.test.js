const mathUtils = require('./mathUtils');

// describe("sum() test suite")
// test("name", ()=>{
//    expect(actual).toBe(expect);
//})

describe("sum test cases", () => {
    test("check that it sums 4 numbers correctly", () => {
        const actual = mathUtils.sum(4, 2, 8, 6); // 20
           const expected = 20;
        expect(actual).toBe(expected);
    });
    test("check that it sums 6 numbers correctly", () => {
        const actual = mathUtils.sum(10, 20, 4, 2, 8, 6); // 50
           const expected = 50;
        expect(actual).toBe(expected);
    });
});

describe("product test cases", () => {
    test("check that it gives product of 4 numbers", () => {
        const actual = mathUtils.product(4, 2, 8, 6); // 384
           const expected = 384;
        expect(actual).toBe(expected);
    });
    test("check that it gives product of 5 numbers", () => {
        const actual = mathUtils.product(10, 4, 2, 8, 6); // 3840
           const expected = 3840;
        expect(actual).toBe(expected);
    });
})