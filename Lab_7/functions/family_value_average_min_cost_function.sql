USE Dmytryshyn_7_58;
SET GLOBAL log_bin_trust_function_creators = 1;

DELIMITER //
DROP FUNCTION IF EXISTS family_value_average_min_cost //
CREATE FUNCTION family_value_average_min_cost()
RETURNS DECIMAL(10,2) 
BEGIN
    return(SELECT AVG(min_cost) FROM family_value);
END//