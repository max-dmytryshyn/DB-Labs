CREATE DATABASE IF NOT EXISTS Dmytryshyn_7_58;
USE Dmytryshyn_7_58;

DROP TABLE IF EXISTS family_companion;
DROP TABLE IF EXISTS gender;
DROP TABLE IF EXISTS family_tree;
DROP TABLE IF EXISTS family_value;
DROP TABLE IF EXISTS family_tree_has_family_value;

CREATE TABLE family_companion (
	id INT AUTO_INCREMENT,
    name VARCHAR(45) NOT NULL,
    surname VARCHAR(45) NOT NULL,
    birth_date DATE,
    death_date DATE,
    birth_place VARCHAR(60),
    death_place VARCHAR(60),
    marriage_date DATE,
    gender CHAR(1),
    
    CONSTRAINT pk_family_companion PRIMARY KEY (id)
);

CREATE TABLE gender (
	gender CHAR(1),
    CONSTRAINT pk_gender PRIMARY KEY (gender)
);

INSERT INTO gender(gender) VALUES ('F'), ('M');

CREATE TABLE family_tree (
    id INT AUTO_INCREMENT,
    name VARCHAR(45) NOT NULL,
    surname VARCHAR(45) NOT NULL,
    birth_date DATE,
    death_date DATE,
    birth_place VARCHAR(60),
    death_place VARCHAR(60),
    credit_card_number VARCHAR(19),
    companion_id INT UNIQUE,
    gender CHAR(1) NOT NULL,
    parent_tree_id INT,
    
    CONSTRAINT pk_family_tree PRIMARY KEY (id)
);

CREATE TABLE family_value (
	id INT AUTO_INCREMENT,
    name VARCHAR(100),
    estimated_cost DECIMAL(10,1) UNSIGNED,
    max_cost DECIMAL(10,1) UNSIGNED,
    min_cost DECIMAL(10,1) UNSIGNED,
    
    CONSTRAINT family_value_pk PRIMARY KEY (id)
);

CREATE TABLE family_tree_has_family_value(
	family_tree_id INT,
    family_value_id INT,
    
    CONSTRAINT family_tree_has_family_value_pk PRIMARY KEY (family_tree_id, family_value_id)
);