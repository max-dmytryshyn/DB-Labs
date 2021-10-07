USE Labor_SQL;
/*
1.БД «Аеропорт». Знайдіть номери всіх рейсів, на яких не курсує літак 'IL-86'. 
Вивести: trip_no, plane, town_from, town_to. Вихідні дані впорядкувати за зростанням за стовпцем plane.
*/
SELECT trip_no, plane, town_from, town_to FROM Trip
WHERE plane != 'IL-86'
ORDER BY plane;
/*
2.БД «Кораблі». З таблиці Ships вивести назви кораблів, що починаються на 'W' та закінчуються літерою 'n'.
*/
SELECT name FROM Ships
WHERE name LIKE 'W%n';
/*
3.БД «Комп. фірма». Виведіть виробника, тип, модель та частоту процесора для ноутбуків, 
частота процесорів яких перевищує 600 МГц. Вивести: maker, type, model, speed.
*/
SELECT Product.maker, Product.type, Laptop.model, Laptop.speed FROM Laptop
INNER JOIN Product ON Laptop.model = Product.model
WHERE Laptop.speed > 600;
/*
4.БД «Комп. фірма». Знайти наявну кількість комп’ютерів (таблиця PC), що випущені виробником 'A'.
*/
SELECT COUNT(PC.model) FROM PC
INNER JOIN Product ON PC.model = Product.model
WHERE Product.maker = 'A';
/*
5.БД «Комп. фірма». Знайдіть виробників принтерів, що випускають ПК із найвищою швидкістю процесора. Виведіть: maker.
*/
SELECT DISTINCT maker FROM Product 
WHERE Product.type = 'Printer' and maker IN(
	SELECT Product.maker FROM PC
	INNER JOIN Product ON PC.model = Product.model
	WHERE PC.speed = (SELECT MAX(PC.speed) FROM PC)
);
/*
6.БД «Фірма прий. вторсировини». З таблиці Income виведіть дати в такому форматі: 
рік.число_місяця.день, наприклад, 2001.02.15 (без формату часу).
*/
SELECT DATE_FORMAT(date, '%Y.%m.%d') FROM Income;
/*
7.БД «Комп. фірма». Знайти моделі та ціни ПК, вартість яких перевищує мінімальну вартість ноутбуків.
Вивести: model, price.
*/
SELECT model, price FROM PC
WHERE price > (SELECT MIN(price) FROM Laptop);
/*
8.БД «Кораблі». Вкажіть назву, країну та число гармат кораблів, що були пошкоджені в битвах. 
Вивести: ship, country, numGuns.
*/
SELECT Outcomes.ship, Ships.country, Ships.numGuns FROM Outcomes
LEFT JOIN (
SELECT Ships.name, Classes.country, Classes.numGuns FROM Ships
INNER JOIN Classes ON Ships.class = Classes.class
) 
AS Ships ON Outcomes.ship=Ships.name
WHERE result ='damaged';
/*
9.БД «Кораблі». Визначити назви всіх кораблів із таблиці Ships, які задовольняють, у крайньому випадку,
комбінації будь-яких трьох ритеріїв із наступного списку: numGuns=9, bore=16, displacement=46000, type='bb',
country='Japan', launched=1916,class='Revenge'. 
Вивести: name, numGuns, bore, displacement, type, country, launched, class.
*/
SELECT Ships.name, Cl.numGuns, Cl.bore, Cl.displacement, Cl.type, Cl.country, Ships.launched, Ships.class FROM Ships
INNER JOIN Classes AS Cl ON Ships.class = Cl.class
WHERE ((Cl.numGuns=9) + (Cl.bore=16) + (Cl.displacement=46000) + (Cl.type='bb') + 
(Cl.country='Japan') + (Ships.launched=1916) + (Ships.class='Revenge')) > 2;
/*
10.БД «Кораблі». Знайдіть класи, у яких входить лише один корабель з усієї БД (врахувати також кораблі в таблиці Outcomes,
яких немає в таблиці Ships). Вивести: class.
*/
SELECT class FROM Ships
GROUP BY class
HAVING COUNT(class)=1
UNION
SELECT DISTINCT ship FROM Outcomes
WHERE ship NOT IN(SELECT name FROM Ships);
