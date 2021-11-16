USE Dmytryshyn_7_58;
SET GLOBAL log_bin_trust_function_creators = 1;

DELIMITER //
DROP FUNCTION IF EXISTS gender_retrieval //
CREATE FUNCTION gender_retrieval(
	gender CHAR(1)
)
RETURNS VARCHAR(10)
BEGIN
    return(SELECT gender_full FROM gender WHERE gender.gender=gender);
END//