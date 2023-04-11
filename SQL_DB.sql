CREATE DATABASE `Druzia cheloveka`;
USE `Druzia cheloveka`;

-- 8. Создать таблицы с иерархией из диаграммы в БД

CREATE TABLE `Zhivotnie`
(
id int PRIMARY KEY AUTO_INCREMENT,
name_of_top VARCHAR(25)
);

INSERT INTO `Zhivotnie` (name_of_top)
VALUES
('Domashnie zhivotnie'),
('Viuchnie zhivotnie')
;

CREATE TABLE `Domashnie zhivotnie`
(
id int PRIMARY KEY AUTO_INCREMENT,
type_animal_Id int not null,
name_of_home_animal VARCHAR(10) not null,
foreign key (type_animal_Id) references `Zhivotnie` (id) on delete cascade
);

INSERT INTO `Domashnie zhivotnie` (type_animal_Id, name_of_home_animal)
VALUES
(1, 'Sobaki'),
(1, 'Koshki'),
(1, 'Homyaki');

CREATE TABLE `Viuchnie zhivotnie`
(
id int PRIMARY KEY AUTO_INCREMENT,
type_animal_Id int not null,
name_of_baggage_animal VARCHAR(10),
foreign key (type_animal_Id) references `Zhivotnie` (id) on delete cascade
);

INSERT INTO `Viuchnie zhivotnie` (type_animal_Id, name_of_baggage_animal)
VALUES
(2, 'Loshadi'),
(2, 'Verbludi'),
(2, 'Osly');

CREATE TABLE `Sobaki`
(
id int PRIMARY KEY AUTO_INCREMENT,
name_of_animal VARCHAR(10),
date_of_birth date,
instruction VARCHAR(15),
object_id int not null,
foreign key (object_id) references `Domashnie zhivotnie` (id) on delete cascade
);

CREATE TABLE `Koshki`
(
id int PRIMARY KEY AUTO_INCREMENT,
name_of_animal VARCHAR(10),
date_of_birth date,
instruction VARCHAR(15),
object_id int not null,
foreign key (object_id) references `Domashnie zhivotnie` (id) on delete cascade
);

CREATE TABLE `Homyaki`
(
id int PRIMARY KEY AUTO_INCREMENT,
name_of_animal VARCHAR(10),
date_of_birth date,
instruction VARCHAR(15),
object_id int not null,
foreign key (object_id) references `Domashnie zhivotnie` (id) on delete cascade
);

CREATE TABLE `Loshadi`
(
id int PRIMARY KEY AUTO_INCREMENT,
name_of_animal VARCHAR(10),
date_of_birth date,
instruction VARCHAR(15),
object_id int not null,
foreign key (object_id) references `Viuchnie zhivotnie` (id) on delete cascade
);

CREATE TABLE `Verbludi`
(
id int PRIMARY KEY AUTO_INCREMENT,
name_of_animal VARCHAR(10),
date_of_birth date,
instruction VARCHAR(15),
object_id int not null,
foreign key (object_id) references `Viuchnie zhivotnie` (id) on delete cascade
);

CREATE TABLE `Osly`
(
id int PRIMARY KEY AUTO_INCREMENT,
name_of_animal VARCHAR(25),
date_of_birth date,
instruction VARCHAR(15),
object_id int not null,
foreign key (object_id) references `Viuchnie zhivotnie` (id) on delete cascade
);

-- 9. Заполнить низкоуровневые таблицы именами(животных), командами, которые они выполняют и датами рождения

INSERT INTO `Sobaki` (name_of_animal, date_of_birth, instruction, object_id)
VALUES
("Tuzik", date '2022-10-15', "Dai lapu", 1),
("Sharik", date '2021-11-15', "Sidet", 1);

INSERT INTO `Koshki` (name_of_animal, date_of_birth, instruction, object_id)
VALUES
("Murzik", date '2021-05-04', "Idi est", 2),
("Kotik", date '2022-01-15', "Kis kis", 2);

INSERT INTO `Homyaki` (name_of_animal, date_of_birth, instruction, object_id)
VALUES
("Homa", date '2022-09-22', "Begi", 3),
("Amoh", date '2021-01-17', "Spi", 3);

INSERT INTO `Loshadi` (name_of_animal, date_of_birth, instruction, object_id)
VALUES
("Loshadka", date '2018-04-03', "Galopom", 1),
("Loshak", date '2015-03-04', "Prygai", 1);

INSERT INTO `Verbludi` (name_of_animal, date_of_birth, instruction, object_id)
VALUES
("Odnogorbyi", date '2009-11-16', "Lezhi", 2),
("Dvugorbyi", date '2016-02-16', "Stoi", 2);

INSERT INTO `Osly` (name_of_animal, date_of_birth, instruction, object_id)
VALUES
("Ia", date '2020-11-07', "Molchi", 3),
("Osel", date '1965-12-30', "Nesi", 3);

-- 10. Удалив из таблицы верблюдов, т.к. верблюдов решили перевезти в другой питомник на зимовку.
select * from `Verbludi`;
delete from `Verbludi`
where id > 0;
select * from `Verbludi`;

--  Объединить таблицы лошади, и ослы в одну таблицу.

select * from `Sobaki`
union
select * from `Koshki`;

-- 11. Создать новую таблицу “молодые животные” в которую попадут все
-- животные старше 1 года, но младше 3 лет и в отдельном столбце с точностью
-- до месяца подсчитать возраст животных в новой таблице

CREATE TABLE `Molodye zhivotnie`
(
id int PRIMARY KEY AUTO_INCREMENT,
name_of_animal VARCHAR(25),
date_of_birth date,
instruction VARCHAR(15)
);
INSERT INTO `Molodye zhivotnie` (name_of_animal, date_of_birth, instruction)
SELECT name_of_animal, date_of_birth, instruction FROM `Sobaki`
WHERE date_of_birth between date '2020-02-21' and '2022-02-21'
union
SELECT name_of_animal, date_of_birth, instruction FROM `Koshki`
WHERE date_of_birth between date '2020-02-21' and '2022-02-21'
union
SELECT name_of_animal, date_of_birth, instruction FROM `Homyaki`
WHERE date_of_birth between date '2020-02-21' and '2022-02-21'
union
SELECT name_of_animal, date_of_birth, instruction FROM `Loshadi`
WHERE date_of_birth between date '2020-02-21' and '2022-02-21'
union
SELECT name_of_animal, date_of_birth, instruction FROM `Verbludi`
WHERE date_of_birth between date '2020-02-21' and '2022-02-21'
union
SELECT name_of_animal, date_of_birth, instruction FROM `Osly`
WHERE date_of_birth between date '2020-02-21' and '2022-02-21';

select name_of_animal, date_of_birth, instruction, CEILING(DATEDIFF('2023-02-21', date_of_birth)/30) AS month from `Molodye zhivotnie`;

-- 12. Объединить все таблицы в одну, при этом сохраняя поля, указывающие на
-- прошлую принадлежность к старым таблицам.

select * from `Sobaki`
union
select * from `Koshki`
union
select * from `Homyaki`
union
select * from `Loshadi`
union
select * from `Verbludi`
union
select * from `Osly`;