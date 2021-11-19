USE Dmytryshyn_7_58;

CALL clear_tables();

CALL insert_into_family_companion("Hanna", "Dmytryshyn", "1952-05-09", "2008-06-07", "v.Zarudtsi", 
"v.Zarudtsi", "1971-11-12", 'F');
CALL insert_into_family_companion("Future", "Husband1", null, null, null, null, null, 'M');
CALL insert_into_family_companion("Halyna", "Dmytryshyn", "1973-01-01", null, "v.Zarudtsi", null, 
"1996-04-05", 'F');
CALL insert_into_family_companion("Olena", "Dmytryshyn", "1978-12-17", null, "c.Lviv", null, "2001-07-28", 'F');
CALL insert_into_family_companion("Lybov", "Dmytryshyn", "1984-05-06", null, "c.Lviv", null, "2008-03-17", 'F');
CALL insert_into_family_companion("Ivan", "Ivanusa", "1996-03-15", null, "v.Zashkiv", null, "2021-08-08", 'M');
CALL insert_into_family_companion("Future", "Wife1", null, null, null, null, null, 'F');
CALL insert_into_family_companion("Future", "Wife2", null, null, null, null, null, 'F');
CALL insert_into_family_companion("Future", "Wife3", null, null, null, null, null, 'F');
CALL insert_into_family_companion("Future", "Husband2", null, null, null, null, null, 'M');

CALL insert_into_family_tree("Ivan", "Dmytryshyn", "1951-03-07", null, "v.Zarudtsi", null, null, 1, 'M', null);
CALL insert_into_family_tree("Nadya", "Dmytryshyn", "1973-11-12", null, "v.Zarudtsi", null, null, 2, 'F', 1);
CALL insert_into_family_tree("Ivan","Dmytryshyn", "1975-09-24", null, "v.Zarudtsi", null, null, 3, 'M', 1);
CALL insert_into_family_tree("Vasyl", "Dmytryshyn", "1979-01-03", null, "v.Zarudtsi", null, null, 4, 'M', 1);
CALL insert_into_family_tree("Volodymyr", "Dmytryshyn", "1981-03-04", null, "v.Zarudtsi", null, null, 5, 'M', 1);
CALL insert_into_family_tree("Iryna", "Ivanusa", "2001-09-022", null, "v.Zarudtsi", null, null, 6, 'F', 3);
CALL insert_into_family_tree("Max", "Dmytryshyn", '2003-04-04', null, "c.Lviv", null, "5375414121372964", 7, 'M', 4);
CALL insert_into_family_tree("Stepan", "Dmytryshyn", "2005-05-15", null, "v.Zarudtsi", null, null, 8, 'M', 3);
CALL insert_into_family_tree("Matviy", "Dmytryshyn", "2011-11-23", null, "c.Lviv", null, null, 9, 'M', 5);
CALL insert_into_family_tree("Liza", "Dmytryshyn", "2015-02-14", null, "c.Lviv", null, null, 10, 'F', 5);

CALL insert_into_family_value("value1", "20", "25", "15");
CALL insert_into_family_value("value2", "25", "35", "13");
CALL insert_into_family_value("value3", "17", "23", "12");
CALL insert_into_family_value("value4", "11", "30", "7");
CALL insert_into_family_value("value5", "42", "78", "33");
CALL insert_into_family_value("value6", "56", "103", "42");
CALL insert_into_family_value("value7", "8", "12", "5");
CALL insert_into_family_value("value8", "32", "54", "28");
CALL insert_into_family_value("value9", "150", "173", "92");
CALL insert_into_family_value("value10", "228", "341", "157");

INSERT INTO family_tree_has_family_value(family_tree_id, family_value_id)
VALUES (5, 1), (2,7), (2,1), (2,4), (3,5), (6,1), (7,4), (10,1), (9,8), (8,4);