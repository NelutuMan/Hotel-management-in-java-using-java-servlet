package hotel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import hotel.bean.Room;

public class RoomDao extends Database {
	
	private static final String INSERT_ROOMS_SQL = "INSERT INTO rooms" + "  (floor, customer, room_attendant, features, empty_room) VALUES "
			+ " (?, ?, ?, ?, ?);";
	private static final String SELECT_ROOM_BY_ID = "SELECT id_room, floor, customer, room_attendant, features, empty_room FROM rooms WHERE id_room =?";
	private static final String SELECT_ALL_ROOMS = "SELECT rooms.id_room, rooms.floor, customers.customer_name as customer , staff.staff_name as room_attendant, rooms.features, rooms.empty_room\r\n"
			+ "FROM Rooms\r\n"
			+ "INNER JOIN customers ON rooms.customer=customers.id_customer\r\n"
			+ "INNER JOIN staff ON rooms.room_attendant=staff.id_staff;\r\n"
			+ "";
	private static final String DELETE_ROOMS_SQL = "DELETE from rooms WHERE id_room = ?;";	
	private static final String UPDATE_ROOMS_SQL = "UPDATE rooms SET floor = ?, customer= ?, room_attendant =?, features =?, empty_room =?  WHERE id_room = ?;";	
	private static final String COUNT_ROOMS = "SELECT COUNT(id_room) AS rooms_count FROM rooms WHERE empty_room = 1; ";
	
	
	// insert 
	public void insertRoom(Room room) throws SQLException {
		System.out.println(INSERT_ROOMS_SQL);
		
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ROOMS_SQL)) {
			preparedStatement.setInt(1, room.getFloor());
			preparedStatement.setString(2, room.getCustomer());
			preparedStatement.setString(3, room.getRoom_attendant());
			preparedStatement.setString(4, room.getFeatures());
			preparedStatement.setString(5, room.getEmpty_room());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}
	
	//select  by id
	public Room selectRoom(int id_room) {
		Room room = null;
		
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ROOM_BY_ID);) {
			
			preparedStatement.setInt(1, id_room);
			System.out.println(preparedStatement);			
			ResultSet rs = preparedStatement.executeQuery();			
			while (rs.next()) {
				int floor = rs.getInt("floor");
				String customer = rs.getString("customer");
				String room_attendant = rs.getString("room_attendant");
				String features = rs.getString("features");
				String empty_room = rs.getString("empty_room");
				room = new Room(id_room, floor, customer, room_attendant, features, empty_room);
				}
			} catch (SQLException e) {
				printSQLException(e);
			}
			return room;
		}
	
	//select all 
	public List<Room> selectAllRooms() {
		List<Room> room = new ArrayList<>();
		try (Connection connection = getConnection();

			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_ROOMS);) {
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				int id_room = rs.getInt("id_room");
				int floor = rs.getInt("floor");
				String customer = rs.getString("customer");
				String room_attendant = rs.getString("room_attendant");
				String features = rs.getString("features");
				String empty_room = rs.getString("empty_room");
				room.add(new Room(id_room, floor, customer, room_attendant, features, empty_room));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return room;
	}
	
	//update 
	public boolean updateRoom(Room room) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_ROOMS_SQL);) {
			System.out.println("updated Customers:"+statement);
			statement.setInt(1, room.getFloor());
			statement.setString(2, room.getCustomer());
			statement.setString(3, room.getRoom_attendant());
			statement.setString(4, room.getFeatures());
			statement.setString(5, room.getEmpty_room());
			statement.setInt(6, room.getId_room());

			rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
	}
	
	//delete 
	public boolean deleteRoom(int id_room) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_ROOMS_SQL);) {
			statement.setInt(1, id_room);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}
	
	//count
	public Room count_rooms() {
		Room count = null;
		try (Connection connection = getConnection();
				
			PreparedStatement preparedStatement = connection.prepareStatement(COUNT_ROOMS);) {
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
						
			while (rs.next()) {
				int rooms_count = rs.getInt("rooms_count");
				count = new Room(rooms_count);
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
