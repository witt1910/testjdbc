package application;

import java.util.Date;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.StudentDao;
import model.entities.School;
import model.entities.Student;

public class Program {

	public static void main(String[] args) {

		StudentDao studentDao = DaoFactory.createStudentDao();
		
		System.out.println("=== TEST 1: student findById ===");
		Student student = studentDao.findById(9);
		System.out.println(student);
		
		System.out.println();
		System.out.println("=== TEST 2: student findBySchool ===");
		School school = new School(2, null);
		List<Student> list = studentDao.findBySchool(school);
		list.forEach(System.out::println);

		System.out.println();
		System.out.println("=== TEST 3: student findAll ===");
		list = studentDao.findAll();
		list.forEach(System.out::println);

		System.out.println();
		System.out.println("=== TEST 4: student insert ===");
		Student newStudent = new Student(null, "Antonia de Almeida", new Date(), "Dislexia", 4, school);
		studentDao.insert(newStudent);
		System.out.println("Inserted! New id = " + newStudent.getId());
		
		
		
	
	}

}
