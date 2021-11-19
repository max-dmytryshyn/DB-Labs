USE Dmytryshyn_7_58;

DELIMITER //
DROP TRIGGER IF EXISTS before_family_tree_input_check_birth_place //
CREATE TRIGGER before_family_tree_input_check_birth_place
BEFORE INSERT
ON family_tree FOR EACH ROW
BEGIN 
	IF (new.birth_place IS NOT NULL) AND 
    (new.birth_place NOT IN ("v.Zarudtsi", "c.Lviv", "v.Zashkiv")) THEN
		SIGNAL SQLSTATE '45000'
		SET MESSAGE_TEXT = "Value error. Wrong value for birth_place in family_tree";
	END IF;
END //

DROP TRIGGER IF EXISTS before_family_tree_update_check_birth_place //
CREATE TRIGGER before_family_tree_update_check_birth_place
BEFORE UPDATE
ON family_tree FOR EACH ROW
BEGIN 
	IF (new.birth_place IS NOT NULL) AND 
    (new.birth_place NOT IN ("v.Zarudtsi", "c.Lviv", "v.Zashkiv")) THEN
		SIGNAL SQLSTATE '45000'
		SET MESSAGE_TEXT = "Value error. Wrong value for birth_place in family_tree";
	END IF;
END //