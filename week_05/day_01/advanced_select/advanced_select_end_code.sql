DROP TABLE movies;


CREATE TABLE movies(
    id SERIAL,      
    title VARCHAR(255),
    duration INT,
    rating VARCHAR(255)
);

INSERT INTO movies (title, duration, rating) VALUES ('Alien', 117, '18');
INSERT INTO movies (title, duration, rating) VALUES ('The Imitation Game', 114, '12A');
INSERT INTO movies (title, duration, rating) VALUES ('Iron Man', 126, '12A');
INSERT INTO movies (title, duration, rating) VALUES ('The Martian', 144, '12A');
INSERT INTO movies (title, duration, rating) VALUES ('Guardians of the Galaxy', 121, '12A');
INSERT INTO movies (title, duration, rating) VALUES ('You Only Live Twice', 117, 'PG');
INSERT INTO movies (title, duration, rating) VALUES ('I Know What You Did Last Summer', 101, '18');

-- missing values
INSERT INTO movies (title, rating) VALUES ('Braveheart', 'PG');

SELECT * FROM movies;

SELECT title FROM movies;

SELECT * FROM movies WHERE rating = 'PG';

UPDATE movies SET rating = '12A' WHERE id = 5;

UPDATE movies SET (duration, rating) = (178, '15') WHERE id = 5;

DELETE FROM movies WHERE id = 5;

-- DELETE FROM movies;

SELECT * FROM movies;

SELECT * FROM movies WHERE title = 'Alien';

SELECT * FROM movies WHERE title LIKE 'Alien';

SELECT * FROM movies WHERE title ILIKE '%you%';

SELECT * FROM movies WHERE LOWER(title) LIKE LOWER('%You%');

SELECT * FROM movies ORDER BY duration;

SELECT * FROM movies ORDER BY duration DESC;

SELECT title FROM movies WHERE rating = '12A' ORDER BY duration DESC;

SELECT COUNT(*) FROM movies;

SELECT DISTINCT rating FROM movies;

SELECT COUNT (DISTINCT rating) FROM movies;

-- What if we want to know how many movies we have with each rating?

-- SELECT rating, COUNT (rating) FROM movies; 
-- ^^ Could try this, but throws an error

SELECT DISTINCT rating FROM movies;

SELECT rating FROM movies GROUP BY rating;

SELECT rating, COUNT(*) FROM movies GROUP BY rating;

-- What is the average duration of a PG movie, a 12A movie an 18 movie?
SELECT rating, AVG(duration) 
FROM movies 
GROUP BY rating;




