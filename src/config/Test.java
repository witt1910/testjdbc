package config;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SchoolDao;
import model.dao.StudentDao;
import model.entities.School;
import model.entities.Student;

public class Test {

	public static void main(String[] args) {

		/*
		CREATE TABLE school (
		  Id int(11) NOT NULL AUTO_INCREMENT,
		  Name varchar(60) DEFAULT NULL,
		  PRIMARY KEY (Id)
		);
		
		CREATE TABLE student (
		  Id int(11) NOT NULL AUTO_INCREMENT,
		  Name varchar(60) NOT NULL,
		  BirthDate datetime NOT NULL,
		  Demand varchar(100) NOT NULL,
		  Grade int(11) NOT NULL,
		  SchoolId int(11) NOT NULL,
		  PRIMARY KEY (Id),
		  FOREIGN KEY (SchoolId) REFERENCES school (id)
		);
		
		INSERT INTO school (Name) VALUES 
		  ('Alice'),
		  ('Araci'),
		  ('CEJU'),
		  ('Flora');
		
		INSERT INTO student (Name, BirthDate, Demand, Grade, SchoolId) VALUES 
		  ('Ana Luiza Assis','2009-04-21','Dislexia',5,1),
		  ('Emanuela Alfredo Borges','2009-04-21','TDAH',5,2),
		  ('Ricardo Albuquerque','2010-04-21','Dislexia',4,2),
		  ('Evandro Marques Souza','2010-04-21','Depressão',4,3),
		  ('Caroline Matias Rodrigues','2009-04-21','Dificuldade de aprendizagem',5,4),
		  ('Julio Mendes de Souza','2011-04-21','TOC',3,4),
		  ('Tadeu Montoia Rodrigues','2011-04-21','Dificuldade de aprendizagem',3,4);
		 */
		
		Scanner sc = new Scanner(System.in);

		StudentDao studentDao = DaoFactory.createStudentDao();
		SchoolDao schoolDao = DaoFactory.createSchoolDao();

		System.out.println("\n=== STUDENTS TESTS ===\n");

		System.out.println("=== TEST 1: student findById ===");
		Student student = studentDao.findById(9);
		System.out.println(student);

		System.out.println("\n=== TEST 2: student findBySchool ===");
		School school = new School(2, null);
		List<Student> list = studentDao.findBySchool(school);
		list.forEach(System.out::println);

		System.out.println("\n=== TEST 3: student findAll ===");
		list = studentDao.findAll();
		list.forEach(System.out::println);

		System.out.println("\n=== TEST 4: student insert ===");
		Student newStudent = new Student(null, "Antonia de Almeida", new Date(), "Dislexia", 4, school);
		studentDao.insert(newStudent);
		System.out.println("Inserted! New id = " + newStudent.getId());
		System.out.println("Inserted ok.");

		System.out.println("\n=== TEST 5: student update ===");
		student = studentDao.findById(1);
		student.setName("João Ferreira Coelho");
		studentDao.update(student);
		System.out.println("Update completed!");
		System.out.println("Updated ok.");

		System.out.println("\n=== TEST 6: student delete ===");
		System.out.print("Enter id for delete test: ");
		int id = sc.nextInt();
		studentDao.deleteById(id);
		System.out.println("Delete completed!\n");
		System.out.println("Updated list");
		list = studentDao.findAll();
		list.forEach(System.out::println);

		System.out.println("\n=== SCHOOLS TESTS ===\n");

		System.out.println("\n=== TEST 1: school findById ===");
		school = schoolDao.findById(3);
		System.out.println(school);

		System.out.println("\n=== TEST 2: school findAll ===");
		List<School> listSch = schoolDao.findAll();
		listSch.forEach(System.out::println);

		System.out.println("\n=== TEST 3: school insert ===");
		School newSchool = new School(null, "Monsenhor");
		schoolDao.insert(newSchool);
		System.out.println("Inserted! New id = " + newSchool.getId());

		System.out.println("\n=== TEST 4: school update ===");
		School school2 = schoolDao.findById(1);
		school2.setName("Maria das Dores");
		schoolDao.update(school2);
		System.out.println("Update completed!");

		System.out.println("\n=== TEST 5: school delete ===");
		System.out.print("Enter id for delete test: ");
		id = sc.nextInt();
		schoolDao.deleteById(id);
		System.out.println("Delete completed!\n");
		System.out.println("Updated list");
		listSch = schoolDao.findAll();
		listSch.forEach(System.out::println);

		sc.close();
	}
}