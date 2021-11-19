USE Dmytryshyn_7_58;

DELIMITER //
DROP TRIGGER IF EXISTS prohibit_family_value_update //
CREATE TRIGGER prohibit_family_value_update
BEFORE UPDATE
ON family_value FOR EACH ROW
BEGIN 
	SIGNAL SQLSTATE '45000'
	SET MESSAGE_TEXT = "Immutability error. Cannot update family_value table";
END //