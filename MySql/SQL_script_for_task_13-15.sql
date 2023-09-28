DROP DATABASE IF EXISTS last_task;
CREATE DATABASE IF NOT EXISTS last_task;

USE last_task;

CREATE TABLE animal_list (
	id INT PRIMARY KEY AUTO_INCREMENT,
	type_id INT,
    animal_name TEXT,
    birthday DATE
);

CREATE TABLE animal_types (
	id INT PRIMARY KEY AUTO_INCREMENT,
	type_name TEXT
);

CREATE TABLE animal_command (
	command_id INT PRIMARY KEY AUTO_INCREMENT,
	animal_id INT,
	command_name TEXT
);

INSERT INTO animal_types (id, type_name) VALUES 
	('1', 'Cats'),
	('2', 'Dogs'),
    ('3', 'Hamsters'),
	('4', 'Horses'),
	('5', 'Donkeys'),
    ('6', 'Camels');