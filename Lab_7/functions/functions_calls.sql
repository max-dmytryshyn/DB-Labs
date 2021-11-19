USE Dmytryshyn_7_58;

SELECT * FROM family_value
WHERE min_cost > family_value_average_min_cost();

SELECT name, surname, birth_date, death_date, birth_place, death_place, 
    credit_card_number, companion_id, gender_retrieval(gender), parent_tree_id FROM family_tree