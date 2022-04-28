# Lab - Parentheses Checker

Data structures are all over the place in programming and can be used for much more than just listing objects. In this lab we'll explore another use for them by checking that the parentheses in a block of text are correctly matched.

## MVP

We've provided some tests which cover different combinations of parentheses `()` in a String. Create a class with a method that verifies all parentheses are paired correctly. Your method should return `true` if all parentheses are matched and `false` if not. For example:

```java
checkParentheses("this should (hopefully) work"); // returns true

checkParentheses("this definitely (won't"); // returns false

```

*Hint*: The tests will show what the name of the class and method need to be

*Hint*: You could solve this with many different data structures, but a `Stack`  could be a good starting point


## Extension

Remove the `@Disabled` annotations from the second block of tests and modify your method to check for brackets `[]`, braces `{}` and angle brackets `<>`.


*Hint*: There's no single correct way of doing this. In fact, you will probably need to use a couple of different data structures in your solution.