package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import db.DB;

public class Program {

	public static void main(String[] args) {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Connection conn = null;
		PreparedStatement st = null;
		
		try {
			conn = DB.getConnection();
			st = conn.prepareStatement(""
					+ "INSERT INTO student "
					+ "(Name, BirthDate, Demand, Grade, SchoolId) "
					+ "VALUES (?, ?, ?, ?, ?)",
					Statement.RETURN_GENERATED_KEYS);
			
			st.setString(1, "Elizabeth Tavares Alin");
			st.setDate(2, new java.sql.Date(sdf.parse("22/04/2012").getTime()));
			st.setString(3, "TDAH");
			st.setInt(4, 2);
			st.setInt(5, 1);
			
			int rowsAffected = st.executeUpdate();
			
			if(rowsAffected > 0) {
				ResultSet rs = st.getGeneratedKeys();
				while(rs.next()) {
					int id = rs.getInt(1);
					System.out.println("Done! Id = " + id);
				}
				DB.closeResultSet(rs);
			}
			else {
				System.out.println("No rown affected!");
			}
			
			
		}
		catch (SQLException e) {
			e.printStackTrace();
			// throw new DbException(e.getMessage());
		}
		catch (ParseException e) {
			e.printStackTrace();
			// throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
			DB.closeConnection();
		}
		
	}

}
