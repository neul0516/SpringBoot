DROP DATABASE IF EXISTS spring_test;
CREATE DATABASE spring_test;
USE spring_test;

CREATE TABLE specialty (
    specialty_code INT PRIMARY KEY, 
    specialty_name VARCHAR(100) NOT NULL  
);

CREATE TABLE doctor (
    doctor_id INT PRIMARY KEY, 
    name VARCHAR(100) NOT NULL, 
    age INT NOT NULL, 
    specialty_code INT, 
    experience_years INT, 
    FOREIGN KEY (specialty_code) REFERENCES specialty(specialty_code) 
);
