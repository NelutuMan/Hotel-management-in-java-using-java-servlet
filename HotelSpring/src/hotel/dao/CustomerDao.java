package hotel.dao;

import java.sql.Connection;
//import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import hotel.bean.Customer;

public class CustomerDao extends Database {
				
	private static final String INSERT_CUSTOMERS_SQL = "INSERT INTO customers" + "  (customer_name, customer_email, checkin, checkout) VALUES "
			+ " (?, ?, ?, ?);";
	private static final String SELECT_CUSTOMER_BY_ID = "SELECT id_customer,customer_name, customer_email, checkin, checkout FROM customers WHERE id_customer =?";
	private static final String SELECT_ALL_CUSTOMERS = "SELECT * from customers";
	private static final String DELETE_CUSTOMERS_SQL = "DELETE from customers WHERE id_customer = ?;";
	private static final String UPDATE_CUSTOMERS_SQL = "UPDATE customers SET customer_name = ?,customer_email= ?, checkin =?, checkout =?  WHERE id_customer = ?;";
	private static final String COUNT_CUSTOMERS = "SELECT COUNT(id_customer) AS customers_count FROM customers WHERE checkout > NOW(); ";
	
	// insert 
	public void insertCustomer(Customer customer) throws SQLException {
		System.out.println(INSERT_CUSTOMERS_SQL);
		
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CUSTOMERS_SQL)) {
			preparedStatement.setString(1, customer.getCustomer_name());
			preparedStatement.setString(2, customer.getCustomer_email());
			preparedStatement.setString(3, customer.getCheckin());
			preparedStatement.setString(4, customer.getCheckout());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}

	//select  
	public Customer selectCustomer(int id_customer) {
		Customer customer = null;
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CUSTOMER_BY_ID);) {
			preparedStatement.setInt(1, id_customer);
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				String customer_name = rs.getString("customer_name");
				String customer_email = rs.getString("customer_email");
				String checkin = rs.getString("checkin");
				String checkout = rs.getString("checkout");
				customer = new Customer(id_customer, customer_name, customer_email, checkin, checkout);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return customer;
	}
	
	//select all
	public List<Customer> selectAllCustomers() {
		List<Customer> customers = new ArrayList<>();
		try (Connection connection = getConnection();
	
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CUSTOMERS);) {
			System.out.println(preparedStatement);
			
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				int id_customer = rs.getInt("id_customer");
				String customer_name = rs.getString("customer_name");
				String customer_email = rs.getString("customer_email");
				String checkin = rs.getString("checkin");
				String checkout = rs.getString("checkout");
				customers.add(new Customer(id_customer, customer_name, customer_email, checkin,checkout));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return customers;
	}
	
	//update 	
	public boolean updateCustomer(Customer customer) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_CUSTOMERS_SQL);) {
			System.out.println("updated Customers:"+statement);
			statement.setString(1, customer.getCustomer_name());
			statement.setString(2, customer.getCustomer_email());
			statement.setString(3, customer.getCheckin());
			statement.setString(4, customer.getCheckout());
			statement.setInt(5, customer.getId_customer());

			rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
	}
	
	//delete 
	public boolean deleteCustomer(int id_customer) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_CUSTOMERS_SQL);) {
			statement.setInt(1, id_customer);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}
	
	//count
	public Customer count_customers() {
		Customer count = null;
		try (Connection connection = getConnection();
				
			PreparedStatement preparedStatement = connection.prepareStatement(COUNT_CUSTOMERS);) {
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			
			
			while (rs.next()) {
				int customers_count = rs.getInt("customers_count");
				count = new Customer(customers_count);
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
