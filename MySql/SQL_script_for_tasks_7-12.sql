DROP DATABASE IF EXISTS Друзья_человека;
CREATE DATABASE IF NOT EXISTS Друзья_человека;

USE Друзья_человека;

CREATE TABLE Кошки (
	id INT PRIMARY KEY AUTO_INCREMENT,
	animal_name CHAR(30),
    commands TEXT,
    date_of_birth DATE
);

CREATE TABLE Собаки (
	id INT PRIMARY KEY AUTO_INCREMENT,
	animal_name CHAR(30),
    commands TEXT,
    date_of_birth DATE
);

CREATE TABLE Хомяки (
	id INT PRIMARY KEY AUTO_INCREMENT,
	animal_name CHAR(30),
    commands TEXT,
    date_of_birth DATE
);

CREATE TABLE Ослы (
	id INT PRIMARY KEY AUTO_INCREMENT,
	animal_name CHAR(30),
    commands TEXT,
    date_of_birth DATE
);

CREATE TABLE Верблюды (
	id INT PRIMARY KEY AUTO_INCREMENT,
	animal_name CHAR(30),
    commands TEXT,
    date_of_birth DATE
);

CREATE TABLE Лошади (
	id INT PRIMARY KEY AUTO_INCREMENT,
	animal_name CHAR(30),
    commands TEXT,
    date_of_birth DATE
);

INSERT INTO Кошки (animal_name, commands, date_of_birth) VALUES 
	('Степан', 'сидеть', '2015-10-01'),
	('Вася', 'лежать', '2016-11-01'),
    ('Коржик', 'гулять', '2017-01-01'),
    ('Муся', 'лапу', '2018-05-13');
   
INSERT INTO Собаки (animal_name, commands, date_of_birth) VALUES 
	('Патрик', 'сидеть', '2023-01-01'),
	('Мишель', 'лежать', '2019-10-10'),
    ('Харли', 'гулять', '2018-01-02'),
    ('Пёс', 'лапу', '2010-04-03');
    
INSERT INTO Хомяки (animal_name, commands, date_of_birth) VALUES 
	('Ваня', 'сидеть', '2023-01-20'),
	('Халк', 'лежать', '2022-12-10'),
    ('Рамен', 'гулять', '2002-02-02'),
    ('Жульен', 'лапу', '1975-03-03');
    
INSERT INTO Ослы (animal_name, commands, date_of_birth) VALUES 
	('Коржик', 'сидеть', '2012-02-02'),
	('Андрей', 'лежать', '2013-03-03'),
    ('Рыжик', 'гулять', '2014-04-04'),
    ('Себастьян', 'лапу', '2015-05-05');
    
INSERT INTO Верблюды (animal_name, commands, date_of_birth) VALUES 
	('Гоби', 'сидеть', '2023-09-23'),
	('Тоби', 'лежать', '2019-12-11'),
    ('Габи', 'гулять', '2020-02-11'),
    ('Таби', 'лапу', '2022-11-11');
    
INSERT INTO Лошади (animal_name, commands, date_of_birth) VALUES 
	('Яблоко', 'сидеть', '2021-05-01'),
	('Дыня', 'лежать', '2017-09-10'),
    ('Мелочь', 'гулять', '2020-02-02'),
    ('Пушистик', 'лапу', '2005-05-05');

CREATE TABLE Домашние_животные (
	id INT PRIMARY KEY AUTO_INCREMENT,
	animal_name CHAR(30)
);

CREATE TABLE Вьючные_животные (
	id INT PRIMARY KEY AUTO_INCREMENT,
	animal_name CHAR(30)
    );

INSERT INTO Домашние_животные (animal_name)
SELECT animal_name
FROM Кошки
UNION SELECT animal_name
FROM Собаки
UNION SELECT animal_name
FROM Хомяки;

INSERT INTO Вьючные_животные (animal_name)
SELECT animal_name
FROM Ослы
UNION SELECT animal_name
FROM Верблюды
UNION SELECT animal_name
FROM Лошади;

CREATE TABLE Животные (
	id INT PRIMARY KEY AUTO_INCREMENT,
	animal_name CHAR(30),
    commands TEXT,
    date_of_birth DATE,
    age TEXT,
    animal_type ENUM('Кошки','Собаки','Хомяки', 'Лошади_и_ослы', 'Молодые_животные') NOT NULL
);

TRUNCATE Верблюды;

INSERT INTO Лошади (animal_name, commands, date_of_birth)
SELECT animal_name, commands, date_of_birth
FROM Ослы;

DROP TABLE Ослы;
RENAME TABLE Лошади TO Лошади_и_ослы;

CREATE TABLE Молодые_животные (
	id INT PRIMARY KEY AUTO_INCREMENT,
	animal_name CHAR(30),
    commands TEXT,
    date_of_birth DATE,
    age TEXT
);

DELIMITER $$
CREATE FUNCTION age_an (date_of_b DATE)
RETURNS TEXT
DETERMINISTIC
BEGIN
    DECLARE result TEXT DEFAULT '';
	SET result = CONCAT(
            TIMESTAMPDIFF(YEAR, date_of_b, CURDATE()),
            ' years ',
            TIMESTAMPDIFF(MONTH, date_of_b, CURDATE()) % 12,
            ' month'
        );
	RETURN result;
END $$
DELIMITER ;

INSERT INTO Молодые_животные (animal_name, commands, date_of_birth, age)
SELECT animal_name, commands, date_of_birth, age_an(date_of_birth)
FROM Кошки
WHERE TIMESTAMPDIFF(YEAR, date_of_birth, CURDATE()) BETWEEN 1 AND 2
UNION ALL
SELECT animal_name, commands, date_of_birth, age_an(date_of_birth)
FROM Собаки
WHERE TIMESTAMPDIFF(YEAR, date_of_birth, CURDATE()) BETWEEN 1 AND 2
UNION ALL
SELECT animal_name, commands, date_of_birth, age_an(date_of_birth)
FROM Хомяки
WHERE TIMESTAMPDIFF(YEAR, date_of_birth, CURDATE()) BETWEEN 1 AND 2
UNION ALL
SELECT animal_name, commands, date_of_birth, age_an(date_of_birth)
FROM Лошади_и_ослы
WHERE TIMESTAMPDIFF(YEAR, date_of_birth, CURDATE()) BETWEEN 1 AND 2;


INSERT INTO Животные (animal_name, commands, date_of_birth, age, animal_type)
SELECT animal_name, commands, date_of_birth, age_an(date_of_birth), 'Кошки'
FROM Кошки
UNION SELECT animal_name, commands, date_of_birth, age_an(date_of_birth), 'Собаки'
FROM Собаки
UNION SELECT animal_name, commands, date_of_birth, age_an(date_of_birth), 'Хомяки'
FROM Хомяки
UNION SELECT animal_name, commands, date_of_birth, age_an(date_of_birth), 'Лошади_и_ослы'
FROM Лошади_и_ослы
UNION SELECT animal_name, commands, date_of_birth, age_an(date_of_birth), 'Молодые_животные'
FROM Молодые_животные;