package hotel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import hotel.bean.Staff;

public class StaffDao extends Database{
	
	private static final String INSERT_STAFF_SQL = "INSERT INTO staff" + "  (staff_name, staff_email, position, salary) VALUES "
			+ " (?, ?, ?, ?);";
	
	private static final String SELECT_STAFF_BY_ID = "SELECT id_staff, staff_name, staff_email, position, salary FROM staff WHERE id_staff =?";
	private static final String SELECT_ALL_STAFF = "SELECT * from staff";
	private static final String DELETE_STAFF_SQL = "DELETE from staff WHERE id_staff = ?;";
	private static final String UPDATE_STAFF_SQL = "UPDATE staff SET staff_name = ?,staff_email= ?, position =?, salary =?  WHERE id_staff = ?;";
	private static final String COUNT_STAFF = "SELECT COUNT(id_staff) AS staff_count FROM staff; ";
	
	//insert 
	public void insertStaff(Staff staff) throws SQLException {
		System.out.println(INSERT_STAFF_SQL);
		
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_STAFF_SQL)) {
			preparedStatement.setString(1, staff.getStaff_name());
			preparedStatement.setString(2, staff.getStaff_email());
			preparedStatement.setString(3, staff.getPosition());
			preparedStatement.setInt(4, staff.getSalary());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}
	
	//select 
	public Staff selectStaff(int id_staff) {
		Staff staff = null;
		try (Connection connection = getConnection();
				
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_STAFF_BY_ID);) {
			preparedStatement.setInt(1, id_staff);
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				String staff_name = rs.getString("staff_name");
				String staff_email = rs.getString("staff_email");
				String position = rs.getString("position");
				int salary = rs.getInt("salary");
				staff = new Staff(id_staff, staff_name, staff_email, position, salary);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return staff;
	}
	
	//select all 
	public List<Staff> selectAllStaff() {
	
		List<Staff> staff = new ArrayList<>();
		try (Connection connection = getConnection();
		
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_STAFF);) {
			System.out.println(preparedStatement);			
			ResultSet rs = preparedStatement.executeQuery();
		
			while (rs.next()) {
				int id_staff = rs.getInt("id_staff");
				String staff_name = rs.getString("staff_name");
				String staff_email = rs.getString("staff_email");
				String position = rs.getString("position");
				int salary = rs.getInt("salary");
				staff.add(new Staff(id_staff, staff_name, staff_email,position,salary));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return staff;
	}
	
	//update 
	public boolean updateStaff(Staff staff) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_STAFF_SQL);) {
			System.out.println("updated Staff:"+statement);
			statement.setString(1, staff.getStaff_name());
			statement.setString(2, staff.getStaff_email());
			statement.setString(3, staff.getPosition());
			statement.setInt(4, staff.getSalary());
			statement.setInt(5, staff.getId_staff());

			rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
	}
	
	//delete 
	public boolean deleteStaff(int id_staff) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = getConnection();
			PreparedStatement statement = connection.prepareStatement(DELETE_STAFF_SQL);) {
			statement.setInt(1, id_staff);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}
	
	//count
	public Staff count_staff() {
		Staff count = null;
		try (Connection connection = getConnection();
					
			PreparedStatement preparedStatement = connection.prepareStatement(COUNT_STAFF);) {
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
				
				
			while (rs.next()) {
				int staff_count = rs.getInt("staff_count");
				count = new Staff(staff_count);
			}
				
		} catch (SQLException e) {
			printSQLException(e);
		}
		return count;
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
