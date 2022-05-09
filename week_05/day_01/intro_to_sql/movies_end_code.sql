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
