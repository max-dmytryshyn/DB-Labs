USE Dmytryshyn_7_58;
-- Insert into family companion with wrong gender
-- CALL insert_into_family_companion("Max", "Dmytryshyn", '2003-04-04', null, "Lviv", null, null, 'H'); 

-- Update family companion's gender
UPDATE family_companion SET gender = 'H' WHERE id = 1;

-- Delete tuple in family companion connected with family tree
-- DELETE FROM family_companion WHERE id = 1;

-- Insert into/update/delete from gender table
-- INSERT INTO gender(gender, gender_full) VALUES('H', "Helicopter");
-- UPDATE gender SET gender_full = 'Female';
-- DELETE FROM gender WHERE gender = 'M';

-- Delete tuple in family_value connected with family_tree_has_family_value
-- DELETE FROM family_value WHERE id = 4; 

-- Insert tuple into family_tree_has_family_value with wrong family_tree_id
-- INSERT INTO family_tree_has_family_value(family_tree_id, family_value_id) VALUES (11, 1);

-- Insert tuple into family_tree_has_family_value with wrong family_tree_id
-- INSERT INTO family_tree_has_family_value(family_tree_id, family_value_id) VALUES (1, 11);

-- Update tuple in family_tree_has_family_value with wrong family_tree_id
-- UPDATE family_tree_has_family_value SET family_tree_id = 11 WHERE family_value_id =1;

-- Update tuple in family_tree_has_family_value with wrong family_tree_id
-- UPDATE family_tree_has_family_value SET family_value_id = 11 WHERE family_tree_id =1;

-- Insert tuple into family_tree with wrong gender
-- CALL insert_into_family_tree("Max", "Dmytryshyn", '2003-04-04', null, "c.Lviv", null, "5375414121372964", 7, 'H', 4);

-- Insert tuple into family_tree with wrong companion_id
-- CALL insert_into_family_tree("Max", "Dmytryshyn", '2003-04-04', null, "c.Lviv", null, "5375414121372964", 17, 'M', 4);

-- Insert tuple into family_tree with wrong parent_tree_id
-- CALL insert_into_family_tree("Max", "Dmytryshyn", '2003-04-04', null, "c.Lviv", null, "5375414121372964", null, 'M', 23131);

-- Update family_tree gender
-- UPDATE family_tree SET gender = 'H' WHERE id = 1;

-- Update family_tree companion with wrong companion_id
-- UPDATE family_tree SET companion_id = 13123 WHERE id = 1;

-- Update family_tree null parent_tree_id with wrong id
-- UPDATE family_tree SET parent_tree_id = 213 WHERE id = 1;

-- Update family_tree not null parent_tree_id
-- UPDATE family_tree SET parent_tree_id = 213 WHERE id = 2;

-- Delete tuple in family_tree connected with family_tree_has_family_value
-- DELETE FROM family_tree WHERE id = 5; 

-- Delete tuple in family_tree connected with family_tree.parent_tree_id
-- DELETE FROM family_tree WHERE id = 1; 

-- Insert tuple into family_tree with wrong birth_place
-- CALL insert_into_family_tree("Max", "Dmytryshyn", '2003-04-04', null, "Kyiv", null, "5375414121372964", null, 'M', 4);

-- Update family_tree with wrong birth_place
-- UPDATE family_tree SET birth_place = "Kyiv" WHERE id = 1;

-- Insert family_companion with wrong birth_date
-- CALL insert_into_family_companion("Future", "Wife1", "2222-01-01", null, null, null, null, 'F');

-- Update family_companion with wrong birth_date
-- UPDATE family_companion SET birth_date = "2222-01-01" WHERE id = 1;

-- Update family_value
-- UPDATE family_value SET max_cost = 21343;