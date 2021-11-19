USE Dmytryshyn_7_58;

DELIMITER //
DROP PROCEDURE IF EXISTS add_quotes //
CREATE PROCEDURE `add_quotes` (INOUT s VARCHAR(100))
BEGIN
	SET s = CONCAT("'",s,"'");
END //

DROP PROCEDURE IF EXISTS random_shuffle_family_tree_into_two_tables //
CREATE PROCEDURE `random_shuffle_family_tree_into_two_tables` ()
BEGIN
	DECLARE finished BOOL DEFAULT FALSE;
    DECLARE id INT;
    DECLARE name VARCHAR(45);
    DECLARE surname VARCHAR(45);
    DECLARE birth_date VARCHAR(45);
    DECLARE death_date VARCHAR(45);
    DECLARE birth_place VARCHAR(60);
    DECLARE death_place VARCHAR(60);
    DECLARE credit_card_number VARCHAR(21);
    DECLARE companion_id INT;
    DECLARE gender CHAR(3);
    DECLARE parent_tree_id INT;
    DECLARE family_tree_cursor CURSOR FOR SELECT * FROM family_tree;
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET finished = TRUE;
	SET @cur_date = CURDATE();
    SET @cur_time = CURTIME();
    SET @slice_table_1_name = CONCAT("slice_family_tree_table_", @cur_date, "-", @cur_time,"_1");
    SET @create_slice_table_1_query = CONCAT( 
    "CREATE TABLE `", @slice_table_1_name, "` (",
		"id INT,",
		"name VARCHAR(45) NOT NULL,",
		"surname VARCHAR(45) NOT NULL,",
		"birth_date DATE,",
		"death_date DATE,",
		"birth_place VARCHAR(60),",
		"death_place VARCHAR(60),",
		"credit_card_number VARCHAR(19),",
		"companion_id INT UNIQUE,",	
		"gender CHAR(1),",
		"parent_tree_id INT,",
		
        "CONSTRAINT pk_family_tree PRIMARY KEY (id)",
	");");
	PREPARE statement FROM @create_slice_table_1_query;
    EXECUTE statement;
    DEALLOCATE PREPARE statement;
    SET @slice_table_2_name = CONCAT("slice_family_tree_table_", @cur_date, "-", @cur_time, "_2");
    SET @create_slice_table_2_query = CONCAT(
    "CREATE TABLE `", @slice_table_2_name, "` (",
		"id INT,",
		"name VARCHAR(45) NOT NULL,",
		"surname VARCHAR(45) NOT NULL,",
		"birth_date DATE,",
		"death_date DATE,",
		"birth_place VARCHAR(60),",
		"death_place VARCHAR(60),",
		"credit_card_number VARCHAR(19),",
		"companion_id INT UNIQUE,",	
		"gender CHAR(1),",
		"parent_tree_id INT,",
		
        "CONSTRAINT pk_family_tree PRIMARY KEY (id)",
	");");
    PREPARE statement FROM @create_slice_table_2_query;
    EXECUTE statement;
    DEALLOCATE PREPARE statement;
    
    OPEN family_tree_cursor;
    family_tree_loop: LOOP 
		FETCH family_tree_cursor INTO id, name, surname, birth_date, death_date, birth_place, death_place, 
		credit_card_number, companion_id, gender, parent_tree_id;
        IF finished THEN
			LEAVE family_tree_loop;
        END IF;
        CALL add_quotes(name);
        CALL add_quotes(surname);
        CALL add_quotes(birth_date);
        CALL add_quotes(death_date);
        CALL add_quotes(birth_place);
        CALL add_quotes(death_place);
		CALL add_quotes(credit_card_number);
        CALL add_quotes(gender);
        IF RAND() >= 0.5 THEN
			SET @insert_query = CONCAT(
			"INSERT INTO `", @slice_table_1_name, "` (id, name, surname, birth_date, death_date, birth_place, death_place, 
			credit_card_number, companion_id, gender, parent_tree_id ) ", 
			"VALUES(", id, ",", name, ",", surname, ",", IFNULL(birth_date, "null"), ",", IFNULL(death_date, "null"), ",", 
            IFNULL(birth_place, "null"), ",", IFNULL(death_place, "null"), ",", IFNULL(credit_card_number, "null"), ",",
			IFNULL(companion_id, "null"), ",", gender, ",", IFNULL(parent_tree_id, "null"), ");");
		ELSE
			SET @insert_query = CONCAT(
			"INSERT INTO `", @slice_table_2_name, "` (id, name, surname, birth_date, death_date, birth_place, death_place, 
			credit_card_number, companion_id, gender, parent_tree_id ) ", 
			"VALUES(", id, ",", name, ",", surname, ",", IFNULL(birth_date, "null"), ",", IFNULL(death_date, "null"), ",", 
            IFNULL(birth_place, "null"), ",", IFNULL(death_place, "null"), ",", IFNULL(credit_card_number, "null"), ",",
			IFNULL(companion_id, "null"), ",", gender, ",", IFNULL(parent_tree_id, "null"), ");");
		END IF;
        PREPARE statement FROM @insert_query;
		EXECUTE statement;
		DEALLOCATE PREPARE statement;
	END LOOP;
	CLOSE family_tree_cursor;
    
    SET @select_query = CONCAT(
    "SELECT * FROM `", @slice_table_1_name, "`",
    " UNION ", 
     "SELECT null, null, null, null, null, 'TABLE 1', null, null, null, null, null",
    " UNION ",
    "SELECT * FROM `", @slice_table_2_name, "`",
    " UNION ",
    "SELECT null, null, null, null, null, 'TABLE 2', null, null, null, null, null", ";");
    PREPARE statement FROM @select_query;
	EXECUTE statement;
	DEALLOCATE PREPARE statement;
END //