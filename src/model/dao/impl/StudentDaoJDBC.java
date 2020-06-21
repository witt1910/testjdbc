package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import db.DB;
import db.DbException;
import model.dao.StudentDao;
import model.entities.School;
import model.entities.Student;

public class StudentDaoJDBC implements StudentDao {

	private Connection conn;
	
	public StudentDaoJDBC(Connection conn) {
		this.conn = conn;
	}
	
	@Override
	public void insert(Student obj) {
		
	}

	@Override
	public void update(Student obj) {
		
	}

	@Override
	public void deleteById(Integer id) {
		
	}

	@Override
	public Student findById(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
					"SELECT student.*, school.Name as SchName "
					+ "FROM student INNER JOIN school "
					+ "ON student.SchoolId = school.Id "
					+ "WHERE student.Id = ?");
			
			st.setInt(1, id);
			rs = st.executeQuery();
			if(rs.next()) {
				School sch = new School();
				sch.setId(rs.getInt("SchoolId"));
				sch.setName(rs.getString("SchName"));
				Student obj = new Student();
				obj.setId(rs.getInt("Id"));
				obj.setName(rs.getString("Name"));
				obj.setBirthDate(rs.getDate("BirthDate"));
				obj.setDemand(rs.getString("Demand"));
				obj.setGrade(rs.getInt("Grade"));
				obj.setSchool(sch);
				return obj;
			}
			return null;
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeResultSet(rs);
			DB.closeStatement(st);
		}
	}

	@Override
	public List<Student> findAll() {
		return null;
	}

}