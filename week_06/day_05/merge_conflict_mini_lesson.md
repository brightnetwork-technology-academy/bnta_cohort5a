### Person One

1. Double check you have all the latest changes on develop - git pull origin develop.
2. Make your own fix branch (ensure you branch off develop):
- Person 1: fix/implicit_return,
3. Complete the fix as below:
- Person 1: Refactor the function to use the arrow function’s implicit return
```js
const helloWorld = (name = “World”) => `Hello ${name}!`;
```
4. Add and push the change to the fix branch.
5. Return to GitHub and [create a pull request](#Creating-a-pull-request) for this branch. Remember that your base branch is develop.
6. Merge the change into your develop branch on GitHub. Delete the branch when prompted (note: this only deletes the branch on GitHub).

### Person Two

1. For the purposes of this exercise, Person Two will not**
pull these changes as would be normal good practice.
2. Make your own fix branch (ensure you branch off develop)
- Person 2: ‘fix/rename_function’.
3. Complete the fix as below:
- Person 2: Rename the function from helloWorld to greet.
```js
const greet = (name = “World”) => {
return `Hello ${name}!`;
}
```
4. Add and push the change to the fix branch.
5. Return to GitHub and [create a pull request](#Creating-a-pull-request) for this branch. Again, remember that your base branch is develop.
6. You will see that GitHub advises that X can't automatically merge, but that you can still create the pull request anyway.
7. Once created, you will see that Person Two’s pull request notes that This branch has conflicts that must be resolved

Resolving Conflicts
It is often possible to resolve any issues via GitHub. There is a somewhat more complicated workflow which allows you to resolve conflicts in your editor (VS Code), however, for this lab, we will resolve conflicts via GitHub.

1. Click on the PR you wish to work on. You will see a note that says This branch has conflicts that must be resolved.
2. Click on the Resolve Conflicts button, which will take you to an online editor.
3. Decide if you want to keep only your branch’s changes, keep only the other branch’s changes, or make a brand new change. Delete the conflict markers <<<<<<<, =======, >>>>>>> and make the changes you want in the final merge.
4. Once you’ve resolved all the conflicts in the file, click Mark as resolved.
5. If you have more than one file with a conflict, select the next file you want to edit on the left side of the page under conflicting files and repeat the steps above.

You have now resolved your merge conflicts and can merge your branch into develop!


Conclusion

You have now followed a work-flow that enabled you to simultaneously have multiple people working on the same project using branches, ensuring that you always have two stable versions of the code (on the master and develop) branch. This means that at any point in time during development you always have a working application.
