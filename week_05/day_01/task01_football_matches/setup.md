# Task - Football Matches

In this task you will practice writing SQL queries to extract information from a database. In this example we have provided an SQL file which will add details of some football matches played in various countries over the past few years, plus the divisions they were played in. There are two tables:

- **Divisions** lists the reference code for each division, its name and the country it is played in.
- **Matches** lists the division code, home and away team names, home and away goals, result (**H**ome or **A**way win, or **D**raw) and the season in which the match was played.

## Setup

While we could get some practice with `INSERT` queries by adding all the matches individually, it just won't be practical - there are over 120000 of them! Instead we'll use the PostgreSQL command line tools to set up the database.

Open a terminal and make sure you have them installed. If the following command throws an error get in touch with a trainer who can talk you through installing them.

```sh
which psql

# will print path/to/your/installation
```

With the CLI installed we can carry out some common functions without opening any database inspection tools. For example, we have a shortcut to create a database:

```sh
createdb football
```

We can then use the CLI to run an SQL file and target a specific database with it. Navigate to the folder with the `football_data.sql` file in it and run the command:

```sh
psql -d football -f football_data.sql
```

This will execute the code in `football_data.sql` with any tables being created in the `football` database. If everything has worked you should now be able to query the database and see all the data there.

> The general form of the command is `psql -d yourdbname -f path/to/file.sql`