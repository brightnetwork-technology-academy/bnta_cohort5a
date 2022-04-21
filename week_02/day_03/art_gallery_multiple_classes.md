# Art Gallery

You have been approached by a digital art gallery to build a piece of software to help them manage their artwork and sell pieces to customers. 

The aim of this lab is to plan and create an object-oriented model of an art gallery, with artwork, artists and customers.

Make sure you create a separate file for each class and a separate test file for each class.

## MVP
 - A `Gallery` should have a `name`, a `till` and a collection of `Artwork`.
 - A piece of `Artwork` should have a `title`, an `artist`, a `price` and an `nft`.
 - An `Artist` should have a `name` and a collection of `artwork` (i.e a list of artwork they have personally made).
 - A `Customer` should have a `name` and a `wallet`.
 - A `Customer` should be able to buy an `Artwork` from the `Gallery`, reducing the money in their `wallet` and increasing the money in the `Gallery` till. 

 ## Extensions
 - When an `Artwork` is purchased, it should transfer from the `Gallery` collection to the `Customer` collection.
 - When creating an `nft` for a piece of `Artwork`, ensure that token has not been used for any other item (you may need to call a method in your constructor!).
 - Give the `Gallery` the ability to calculate the value of its collection with a `stock_take()` method.

 
Please remember to git commit and push to GitHub regularly.
