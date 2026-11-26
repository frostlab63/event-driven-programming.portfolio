CREATE DATABASE IF NOT EXISTS university_db;
USE university_db;
CREATE TABLE IF NOT EXISTS programs (program_id INT AUTO_INCREMENT PRIMARY KEY, program_name VARCHAR(100) NOT NULL UNIQUE, required_units INT NOT NULL);
CREATE TABLE IF NOT EXISTS students (student_id INT AUTO_INCREMENT PRIMARY KEY, registration_number VARCHAR(20) UNIQUE NOT NULL, first_name VARCHAR(50) NOT NULL, last_name VARCHAR(50) NOT NULL, email VARCHAR(100) UNIQUE NOT NULL, program_id INT, created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP, CONSTRAINT fk_students_program FOREIGN KEY (program_id) REFERENCES programs(program_id));
INSERT IGNORE INTO programs(program_name,required_units) VALUES ('Bachelor of Computer Science',56),('Diploma in IT',24);
