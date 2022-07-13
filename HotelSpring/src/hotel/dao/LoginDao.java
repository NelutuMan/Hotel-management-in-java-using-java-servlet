package hotel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import hotel.bean.Login;

public class LoginDao extends Database {
	
	private static final String SELECT_VALUES = "SELECT * from login WHERE username = ? and password = ?";
	
	public boolean check(Login form_values) {
		boolean result = false;
		
		try (Connection connection = getConnection();
			
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_VALUES);) {
			preparedStatement.setString(1, form_values.getUsername());
			preparedStatement.setString(2, form_values.getPassword());
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
								
		result = rs.next();	
		} catch (SQLException e) {
			printSQLException(e);
		}
		return result;
	}
			
	private void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}
		
}
