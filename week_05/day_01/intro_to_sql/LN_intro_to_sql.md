# Intro to SQL
Databases are a vital part of any application. Without them there is no way to store any information relevant to the app or any records of users, orders, or bookings. That might sound great from a personal perspective (no more targeted ads because you looked at something online that one time) but it would also mean we couldn't browse Netflix or sell stuff on eBay.

Databases come in two different types: relational and non-relational. The fundamentals are the same, but there is a key difference in terms of structure. Everything we enter into a relational database must follow a clearly-defined format and we can be sure when we read from it that the results will contain the data we need. 

Non-relational databases are much more flexible and give the user a greater degree of freedom in terms of how they are utilised.

The two types are often referred to as SQL and NoSQL databases. SQL stands for Structured Query Language but it in fact covers many different varieties - examples include MySQL, PostgreSQL, H2 and many more. Each has slight differences, but the fundamentals are the same. Often these fundamentals are taken care of for us by a tool known as an Object-Relational Mapper or ORM, but knowing how to manually check what the tools are doing for us is still a vitally important skill.

SQL, which can be pronounced as 'es-q-el' or 'sequel', is the language we will be using to talk to our database.

PostgreSQL (PSQL) is the database system we will be using to run our database. 

## Codealong: Setting up a Database

Let's start by checking that psql has installed on our machines.

```
-- Terminal

psql

```

Should return the prompt:

```
psql (14.2)
Type "help" for help.

username=# 
```
> If you do not see this, you will need to install Postgres.

We can now create our database.

```
-- psql

CREATE DATABASE cinema;

```
> If you get the response `ERROR:  database "cinema" already exists`, type in `DROP DATABASE cinema;` and try again.

We should now have a database called `cinema` that we can work with. We can see a list of all of our databases using the command `\l`.

SQL files are not supported in Intellij (Community Edition) without the additon of plugins, so we will be using VSCode as our editor.

Let's create a file to store our database commands. Keep our PSQL window open and use `cmd + t` to open a new Terminal window. Navigate to where you want to store your file.

```
-- Terminal

touch cinema.sql

```

Use `code .` to open your file in VSCode.

>If you do not have the command line launcher installed on your machine, you can do do by opening VSCode, typing `cmd + shft + P` to open the Command Palette. Type `shell command` to find `Shell Command: Install 'code' command in PATH command`.

## Tables
The data we enter into our database will be stored in tables. Tables consist of columns, which denote the values being stored, and rows, which represent the entries made. In order to set up a table in our database we need to specify the name we want to refer to it by, which should be plural. In this example we're going to keep track of actors and the movies the appear in, so we'll start by creating a movies table.

We also need to define the columns, including the type of data stored in each. These types are similar to those we've seen already, but have slightly different names (see link at the bottom of this document for a full list). By specifying a type for each column we help prevent data being entered inaccurately.


```
-- cinema.sql

CREATE TABLE movies(
    title VARCHAR(255),
    duration INT,
    rating VARCHAR(255)
);
```

Once we store our data we'll need to refer back to it at some point, but that can be quite a challenge. If we have two movies with the same title, how can we tell them apart? To address this we'll add a column called id which will store a unique identifier for each row. This will have a special type called SERIAL, which looks like any other number but has special significance to the database management tool. Serials are assigned automatically when a row is added and won't be reused when a row is deleted, removing a potential source of user error.

```
-- cinema.sql

CREATE TABLE movies(
    id SERIAL,      /* ADDED
    title VARCHAR(255),
    duration INT,
    rating VARCHAR(255)
);
```

Let's run this code to ensure it's all working.

```
-- Terminal (choose a window that isn't operating psql)

psql -d cinema -f cinema.sql
```
You should see `CREATE TABLE` to show the command worked.

We can check that this has happened in PSQL. Click on your PSQL window, type `ctrl + D` to exit.

We now want to view the cinema database. We can do this by typing `psql -d cinema` to specify that we wish to view the `cinema` database. `\dt` will give you a list of all tables in the database. `movies` should now appear.

## Basic Operations - CRUD

We have a database called `cinema` which contains a table called `movies`. We can now think about what sorts of manipulations we might like to make to the data in the database. 

The basic operations we want to ensure all our databases can do are known as the CRUD operations.

- C: Create (we need to be able to put data in)
- R: Read (once the data is stored we need to be able to get it out again)
- U: Update (we need to be able to make any changes we want to)
- D: Delete (we need to be able to remove data from our database)


### Create
There's no point in having a database if we don't store any information in it. The keyword we use adding new information is INSERT and the query follows this format:

```
INSERT INTO table_name (column1, column2, column3) VALUES (value1, value2, value3);
```
We'll add some movies to our table:

```
-- cinema.sql

INSERT INTO movies (title, duration, rating) VALUES ('Alien', 117, '18');
INSERT INTO movies (title, duration, rating) VALUES ('The Imitation Game', 114, '12A');
INSERT INTO movies (title, duration, rating) VALUES ('Iron Man', 126, '12A');
INSERT INTO movies (title, duration, rating) VALUES ('The Martian', 144, '12A');
```

> Note that we don't need to include the id column here. Because we gave it the type SERIAL the database manager will take care of that for us and auto-assign a value to each new entry.

What happens if we miss out some of the information?

```
INSERT INTO movies (title, rating) VALUES ('Braveheart', 'PG');
```
Because we're using a relational database there needs to be something in the duration column, but we haven't provided anything. The database manager ensures there's a value there by inserting NULL instead. 

We can force the user to provide a value by adding NOT NULL after the column's data type when we set up our table.

You can check the data in your table with `SELECT * FROM movies;` in your PSQL terminal.

> We can see that by running our sql file several times, we are adding duplicate data to the table. We can fix this by adding the command `DROP TABLE movies` to the top of our file, so that the movies table is created anew each time.

### Read
Just like there's no point in having an empty database, there's no point putting things in if we're never going to look at them again. We can read information from the database using the SELECT keyword. The simplest thing we could do is read everything from our table, which we have just done with this query:

`SELECT * FROM movies;`

Obviously that's not always going to be practical. We can limit the reults in two ways: by column and by row. Replacing the * with one or more column names will only give us certain pieces of information back:

```
-- movies.sql

-- ADDED
SELECT title FROM movies;
```

We get the requested information for each row in the table. If we want to limit the number of rows we can do so using the WHERE keyword:

```
-- movies.sql

-- ADDED
SELECT * FROM movies WHERE rating = 'PG';
```
We aren't limited to checking equality, we can compare values (>, <) and check negatives using NOT. We can combine the two as well:

```
-- movies.sql

-- ADDED
SELECT title FROM movies WHERE duration > 120;
```

### Update
Once something has been added to our database we may want to change it at a later point. The UPDATE keyword lets us do this and the syntax is similar (although not exactly the same) as adding a new item. 

We need to be more careful here though, since we don't want to accidentally modify more than we need to. Just like we do when we SELECT, we can use the WHERE keyword to limit the rows we are updating. Usually we will use the id property to ensure we only update a specific row, but there may be occasions where we want to use something else to update multiple rows at once.

```
-- movies.sql

-- ADDED
UPDATE movies SET rating = '12A' WHERE id = 5;
```

The syntax is slightly different if we want to update multiple columns, where we need to add brackets around the column names and values:

```
-- movies.sql

-- ADDED
UPDATE movies SET (duration, rating) = (178, '15') WHERE id = 5;
```

### Delete
The final core action will enable us to remove entries from our database. Again we need to be careful and use WHERE to make sure we only remove what we want to.

```
-- movies.sql

-- ADDED
DELETE FROM movies WHERE id = 5;
```
If we leave out the WHERE clause we'll end up deleting everything in the table!


DELETE FROM movies;