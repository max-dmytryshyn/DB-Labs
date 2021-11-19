USE Dmytryshyn_7_58;

DELIMITER //
DROP PROCEDURE IF EXISTS insert_into_family_value //
CREATE PROCEDURE `insert_into_family_value` (
    IN name VARCHAR(100),
    IN estimated_cost DECIMAL(10,1) UNSIGNED,
    IN max_cost DECIMAL(10,1) UNSIGNED,
    IN min_cost DECIMAL(10,1))
BEGIN
	INSERT INTO family_value(name, estimated_cost, max_cost,  min_cost) 
    VALUES(name, estimated_cost, max_cost,  min_cost);
END //