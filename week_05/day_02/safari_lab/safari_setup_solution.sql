DROP TABLE assignments;
DROP TABLE animals;
DROP TABLE enclosures;
DROP TABLE employees;

CREATE TABLE employees (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255),
    employee_number INT
);

CREATE TABLE enclosures (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255),
    capacity INT,
    closed_for_maintenance BOOLEAN
);

CREATE TABLE animals (
    id SERIAL,
    name VARCHAR(255),
    type VARCHAR(255),
    age INT,
    enclosure_id INT REFERENCES enclosures(id)
);

CREATE TABLE assignments (
    id SERIAL,
    employee_id INT REFERENCES employees(id),
    enclosure_id INT REFERENCES enclosures(id),
    day VARCHAR(255)
);

INSERT INTO employees (name, employee_number) VALUES ('Colin', 12873);
INSERT INTO employees (name, employee_number) VALUES ('Valeria', 78663);
INSERT INTO employees (name, employee_number) VALUES ('Ben', 98723);
INSERT INTO employees (name, employee_number) VALUES ('Kenny', 67752);
INSERT INTO employees (name, employee_number) VALUES ('Raheela', 77762);
INSERT INTO employees (name, employee_number) VALUES ('Iain', 37845);

INSERT INTO enclosures (name, capacity, closed_for_maintenance) VALUES ('Big Cat Field', 20, FALSE);
INSERT INTO enclosures (name, capacity, closed_for_maintenance) VALUES ('Reptile House', 30, FALSE);
INSERT INTO enclosures (name, capacity, closed_for_maintenance) VALUES ('Petting Zoo', 10, TRUE);
INSERT INTO enclosures (name, capacity, closed_for_maintenance) VALUES ('Bird Cage', 50, FALSE);

INSERT INTO animals (name, type, age, enclosure_id) VALUES ('Leo', 'Lion', 12, 1);
INSERT INTO animals (name, type, age, enclosure_id) VALUES ('Polly', 'Parrot', 21, 4);
INSERT INTO animals (name, type, age, enclosure_id) VALUES ('Sid', 'Snake', 3, 2);
INSERT INTO animals (name, type, age, enclosure_id) VALUES ('Rachel', 'Rabbit', 5, 3);
INSERT INTO animals (name, type, age, enclosure_id) VALUES ('Charlotte', 'Cheetah', 8, 1);
INSERT INTO animals (name, type, age, enclosure_id) VALUES ('Tanya', 'Turtle', 5, 2);
INSERT INTO animals (name, type, age, enclosure_id) VALUES ('Michael', 'Maccaw', 19, 4);
INSERT INTO animals (name, type, age, enclosure_id) VALUES ('Leah', 'Lion', 10, 1);
INSERT INTO animals (name, type, age, enclosure_id) VALUES ('Luke', 'Lion', 6, 1);
INSERT INTO animals (name, type, age, enclosure_id) VALUES ('Phil', 'Penguin', 2, 4);
INSERT INTO animals (name, type, age, enclosure_id) VALUES ('Graham', 'Guinea Pig', 1, 3);
INSERT INTO animals (name, type, age, enclosure_id) VALUES ('Nigel', 'Newt', 3, 2);
INSERT INTO animals (name, type, age, enclosure_id) VALUES ('Naomi', 'Newt', 3, 2);
INSERT INTO animals (name, type, age, enclosure_id) VALUES ('Harry', 'Hamster', 1, 3);
INSERT INTO animals (name, type, age, enclosure_id) VALUES ('Terry', 'Tiger', 17, 1);

INSERT INTO assignments (employee_id, enclosure_id, day) VALUES (1, 2, 'Monday');
INSERT INTO assignments (employee_id, enclosure_id, day) VALUES (5, 3, 'Wednesday');
INSERT INTO assignments (employee_id, enclosure_id, day) VALUES (1, 3, 'Thursday');
INSERT INTO assignments (employee_id, enclosure_id, day) VALUES (3, 2, 'Tuesday');
INSERT INTO assignments (employee_id, enclosure_id, day) VALUES (2, 1, 'Monday');
INSERT INTO assignments (employee_id, enclosure_id, day) VALUES (3, 3, 'Friday');
INSERT INTO assignments (employee_id, enclosure_id, day) VALUES (6, 4, 'Tuesday');
INSERT INTO assignments (employee_id, enclosure_id, day) VALUES (5, 2, 'Wednesday');
INSERT INTO assignments (employee_id, enclosure_id, day) VALUES (1, 1, 'Monday');
INSERT INTO assignments (employee_id, enclosure_id, day) VALUES (2, 4, 'Friday');
INSERT INTO assignments (employee_id, enclosure_id, day) VALUES (5, 3, 'Saturday');