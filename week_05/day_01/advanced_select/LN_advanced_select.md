# More Advanced SELECT Queries
The SELECT query is a very powerful tool once we start building on it. By combining it with others we can not only filter our results as we have already seen but rearrange and summarise them too. Before we move on let's add some more movies to our database to help with the demonstrations.

> Code continued from `Intro to SQL` lesson.

```
-- movies.sql

-- ADDED

INSERT INTO movies (title, duration, rating) VALUES ('Guardians of the Galaxy', 121, '12A');
INSERT INTO movies (title, duration, rating) VALUES ('You Only Live Twice', 117, 'PG');
INSERT INTO movies (title, duration, rating) VALUES ('I Know What You Did Last Summer', 101, '18');
```

## Fuzzy Matching
When we query a database we may not have the information we need either in exactly the right format or in its entirety. 

For example, we might present a user with a form to enter a movie title they want to search for and we are relying on them entering it correctly. If they get it right then we don't have a problem, but if they can only remember part of the title then we won't be able to pull the details.

In such a scenario we want to be able to find a row based on what the user was able to enter, a process known as *fuzzy matching*. Here we will look at matching a partial result, but fuzzy matching can go much further and has much wider applications beyond SQL.

We start by replacing the = symbol in our queries with the keyword LIKE. 

> You may wish to comment out some of your other SELECTs to reduce visual clutter.

If we have an exact match it won't make any difference.

```
-- cinema.sql

-- ADDED
SELECT * FROM movies WHERE title = 'Alien';

SELECT * FROM movies WHERE title LIKE 'Alien';
```

What happens when we try to *partially* match something, though?

```
-- cinema.sql

-- ADDED
SELECT * FROM movies WHERE title LIKE 'You';
```
We don't get anything back, but we just aded two new movies which have the word "you" in the title. 

We need to include some indicator in our query of where the partial string should sit in a movie's title, which we do by adding a % symbol to our string.

```
SELECT * FROM movies WHERE title LIKE 'You%';
```

Matches any movie where "You" is at the start of the title.

```
SELECT * FROM movies WHERE title LIKE '%You%';
```
Matches any movie with "You" anywhere in the title.

This hasn't quite solved our problem though. If we try a different partial match we see that our query is case-sensitive.

```
SELECT * FROM movies WHERE title LIKE '%The%';
```

Only matches 2 out of 3 movies with "the" in the title.

If we want to ensure case sensitive matching we could solve it using the LOWER() function in SQL. However, it would be better from a design perspective to do any data validation earlier in the process so that issues can be fed back to the user more effectively.

```
SELECT * FROM movies WHERE LOWER(title) LIKE LOWER('%The%');
```

We can also cover our bases by using the `ILIKE` command. `ILIKE` allows you to use case-insenstive pattern matching.

```
SELECT * FROM movies WHERE title ILIKE '_the%';
```


Using LIKE we can go further and include regular expressions for more complex matching, or look for negation (ie. finding rows which don't include a given value).

## Ordering Results
Simply extracting data from a table isn't always enough for us, what if we want to find the oldest, highest, longest? This is a common task for users accessing databases, so common that functionality to help is built in to most database managers.

We add the keywords ORDER BY to the end of our query to re-order the data according to the values contained in the given column(s).

```
SELECT * FROM movies ORDER BY duration;
```
The default is run from lowest to highest numerically ("ascending", or ASC) however we can overrule this by adding the DESC (for "descending") flag.

```
SELECT * FROM movies ORDER BY duration DESC;
```

We can filter the results just like before.

```
SELECT title FROM movies WHERE rating = '12A' ORDER BY duration DESC;
```

## Summarising Results
Often a user will want to perform some sort of further analysis on their data. Once we have connected a Spring application to the database we'll be able to manipulate our results using Java but we can have the database do some of the work for us. 

Typically it will be more efficient to make one database query to get exactly the information we need rather than making multiple queries then having another part of the application piece everything together.

### COUNT
Possibly the simplest tool we have for summarising our data is COUNT. It does what the name suggests: counts how many rows were found by our query.

```
SELECT COUNT(*) FROM movies;
```

It can be combined with other keywords to let us answer more specific questions, eg. how many movies there are rated 12A.

### DISTINCT
In a database where there is a lot of repeated data it can be useful to see a summary of the different values in a column. The DISTINCT keyword can be used here.

```
SELECT DISTINCT rating FROM movies;
```

The two (DISTINCT and COUNT) can be combined to tell us how many distinct values there are in a given column.

```
SELECT COUNT (DISTINCT rating) FROM movies;
```

This isn't quite the solution we made it out to be though, since if we want all of this information at once we need to write multiple queries. 

What if we want to know how many movies we have with each rating? We might try and query something like this:

```
SELECT rating, COUNT (rating) FROM movies;
```

This throws an error though, with a message talking about aggregate functions and GROUP BY clauses. We'll use both in solving this problem.

### GROUP BY
The GROUP BY keyword performs a similar function to DISTINCT in that they gather together rows which share a value in the specified column. Where it differs is in what happens to the original data. 

DISTINCT gives us the distinct values but nothing else, whereas GROUP BY leaves the rows available for us to manipulate further. If we run the two queries side-by-side we see no difference.

```
SELECT DISTINCT rating FROM movies;

SELECT rating FROM movies GROUP BY rating;
```

Note that we can only select columns which are included in the GROUP BY clause, however. If we try to select a different column (eg. title) we will get an error. We can, however make use of an aggregate function to derive further values from our data.

### Aggregate Functions
Aggregate functions perform operations across all rows and return a single value. We've already seen one in the form of COUNT() but they can also be used to find extreme values (MAX(), MIN()) or perform mathematical operations (SUM(), AVG()). When we use them in conjunction with a GROUP BY query the function is applied to all the rows in each group in turn, rather than across the entire table.

```
SELECT rating, COUNT(*) FROM movies GROUP BY rating;
```

All the original columns are still represented within these groups, which means that while we may not be able to view them in the result we can manipulate them along the way, even if they are not explicitly included in the grouping.

Imagine we wish to know: What is the average duration of a PG movie, a 12A movie, an 18 movie?

```
SELECT rating, AVG(duration) FROM movies GROUP BY rating;
```

Even now we have only covered a small fraction of what is possible using SELECT queries. A full example of what can be included is shown in the official documentation. The queries can grow to be very complex and an understanding of the order of operations for the keywords will be useful.

