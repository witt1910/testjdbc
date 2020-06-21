package application;

import java.util.Date;

import model.dao.DaoFactory;
import model.dao.StudentDao;
import model.entities.School;
import model.entities.Student;

public class Program {

	public static void main(String[] args) {

		StudentDao studentDao = DaoFactory.createStudentDao();
		
		Student student = studentDao.findById(9);
		
		System.out.println(student);
		
	}

}
