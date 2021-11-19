USE Dmytryshyn_7_58;

DELIMITER //
DROP PROCEDURE IF EXISTS select_connected_tree_and_value_names //
CREATE PROCEDURE `select_connected_tree_and_value_names` (IN tree_name VARCHAR(45), IN value_name VARCHAR(100))
BEGIN
	SELECT tree.name, value.name FROM family_tree_has_family_value AS docking_table
    INNER JOIN family_tree AS tree ON docking_table.family_tree_id = tree.id
    INNER JOIN family_value AS value ON docking_table.family_value_id = value.id
    WHERE (tree_name = '' OR tree.name = tree_name) AND (value_name = '' OR value.name = value_name);
END //
