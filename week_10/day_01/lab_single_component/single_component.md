# Lab - Single Component

### Lab Objectives
- to practise using `create-react-app`
- to gain familiarity with using the JSX syntax
- prepare for tomorrow

In this exercise we will practise using `create-react-app` to make our own single component application. There is also some further reading to do to prepare for tomorrow.

## Task:

### Part 1: Rendering Recipes
We would like you to create a React app to display a recipe list.

- Use `create-react-app` generate a React app
- create a compononent called `RecipeList.js`, rendered by `App.js`
- Using your own, or the sample data below, render the list recipes to your app


```json

cakes = [
    {
        cakeName: "Lemon Drizzle",
        ingredients: ["eggs", "butter", "lemon  zest", "sugar", "self-raising flour"],
        rating: 5
    },
    {
        cakeName: "Tea Loaf",
        ingredients: ["eggs", "oil", "dried fruit", "sugar", "self-raising flour", "strong tea"],
        rating: 3
    },
    {
        cakeName: "Brownie",
        ingredients: ["chocolate", "eggs", "flour", "butter", "walnuts"],
        rating: 4
    },
    {
        cakeName: "Carrot Cake",
        ingredients: ["carrots", "walnuts", "oil", "cream cheese", "flour", "sugar"],
        rating: 5
    }
]

```

### Part 2: Further reading
Tomorrow we will be looking more closely at how to break down our app into smaller parts (our components). In preparation for this, please read [Thinking in React](https://reactjs.org/docs/thinking-in-react.html) from the React docs. 

A few things to note:

- The example here uses class based components, however it is likely that we will use functional components going forward
- The tutorial references 'State'. We will be going deeper into this tomorrow also, so don't worry if it is confusing at the moment.

There is no need to code anything, we just want introduce you to some new concepts in advance of the lessons tomorrow.
