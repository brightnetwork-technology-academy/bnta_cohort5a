const heading = document.querySelector('#main-heading');
//console.log(heading);

heading.innerText = "Cool Stuff I've Learned About the DOM";

const paragraphs = document.querySelectorAll(".paragraph");
//console.log(paragraphs);
paragraphs[0].innerText = "The DOM is a hierarchical, object oriented representation of the HTML elements in your document.";
paragraphs[1].innerText = "It provides us with an API which allows us to traverse our HTML document, read data from it, and/or make changes to it.";

document.querySelector('h2').innerHTML = "Important Methods & Properties:";

const list = document.querySelector('.list');

// if you want remove all children of an element, set innerHTML to ""
list.innerHTML = "";

// creates an empty element in memory - no content yet, and not added to page
const item1 = document.createElement('li');
console.log(item1);
// use innerText to assign content
item1.innerText = "querySelector() - select the first element that matches a CSS query";

const item2 = document.createElement("li");
item2.innerText = "querySelectorAll() - select all elements that match a query";

const item3 = document.createElement("li");
item3.innerText = "innerText - retrieve or set the text content of an element";

const item4 = document.createElement("li");
item4.innerText = "innerHTML - retrieve or set the inner html of an element, such as it's child elements (or nodes)";

const item5 = document.createElement("li");
item5.innerText = "convertToSpaceMonkey() - use your space monkey ray-gun to convert all elements to space-monkeys";


// now that we've created or new li elements, we must add them as children to the ul element using appendChild()
list.appendChild(item1); list.appendChild(item2); list.appendChild(item3); list.appendChild(item4); list.appendChild(item5);

// to surgically remove an element, use the removeChild method
list.removeChild(list.lastChild);

// innerHTML vs innerText
const box = document.getElementById('box');

// appears as valid html on the page - can be vulnerable to attack
box.innerHTML = "<ul><li>Hello</li><li>World</li></ul>";
// doesn't recognise html tags, treats it as plain text - safer
//box.innerText = "<ul><li>Hello</li><li>World</li></ul>";
