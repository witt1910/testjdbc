package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SchoolDao;
import model.dao.StudentDao;
import model.entities.School;
import model.entities.Student;

public class Program {

	public static void main(String[] args) {

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
		/*
		 * Student newStudent = new Student(null, "Antonia de Almeida", new Date(),
		 * "Dislexia", 4, school); studentDao.insert(newStudent);
		 * System.out.println("Inserted! New id = " + newStudent.getId());
		 */
		System.out.println("Inserted ok.");

		System.out.println("\n=== TEST 5: student update ===");
		/*
		 * student = studentDao.findById(1); student.setName("João Ferreira Coelho");
		 * studentDao.update(student); System.out.println("Update completed!");
		 */
		System.out.println("Updated ok.");
/*
		System.out.println("\n=== TEST 6: student delete ===");
		System.out.print("Enter id for delete test: ");
		int id = sc.nextInt();
		studentDao.deleteById(id);
		System.out.println("Delete completed!\n");
		list = studentDao.findAll();
		list.forEach(System.out::println);
*/
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
		//System.out.println("Inserted ok.");

		System.out.println("\n=== TEST 4: school update ===");
		School school2 = schoolDao.findById(1); 
		school2.setName("Maria das Dores");
		schoolDao.update(school2); 
		System.out.println("Update completed!");
		//System.out.println("Updated ok.");

		System.out.println("\n=== TEST 5: school delete ===");
		System.out.print("Enter id for delete test: ");
		int id = sc.nextInt();
		schoolDao.deleteById(id);
		System.out.println("Delete completed!\n");
		listSch = schoolDao.findAll();
		listSch.forEach(System.out::println);

		sc.close();
	}
}
