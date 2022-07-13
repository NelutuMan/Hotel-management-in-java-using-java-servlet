package hotel.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hotel.bean.Customer;
import hotel.bean.Room;
import hotel.bean.Staff;
import hotel.bean.Login;
import hotel.dao.CustomerDao;
import hotel.dao.RoomDao;
import hotel.dao.StaffDao;
import hotel.dao.LoginDao;

/**
 * Servlet implementation class CustomerServlet
 */
@WebServlet(urlPatterns = "/")
public class HotelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
		private CustomerDao customerDao;
		private StaffDao staffDao;
		private RoomDao roomDao;
		private LoginDao loginDao;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init() throws ServletException {
		customerDao = new CustomerDao();
		staffDao = new StaffDao();
		roomDao = new RoomDao();
		loginDao = new LoginDao();
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
	
		try {
			switch (action) {
			
			//customer
			
			case "/new_customer":
				showNewCustomerForm(request, response);
				break;
			case "/insert_customer":
				insertCustomer(request, response);
				break;
			case "/delete_customer":
				deleteCustomer(request, response);
				break;
			case "/edit_customer":
				showEditCustomerForm(request, response);
				break;
			case "/update_customer":
				updateCustomer(request, response);
				break;
			case "/list_customer":
				listCustomer(request, response);
				break;
			case "/home":
				count(request, response);
				break;
				
			//staff
				
			case "/new_staff":
				showNewStaffForm(request, response);
				break;
			case "/insert_staff":
				insertStaff(request, response);
				break;
			case "/delete_staff":
				deleteStaff(request, response);
				break;
			case "/edit_staff":
				showEditStaffForm(request, response);
				break;
			case "/update_staff":
				updateStaff(request, response);
				break;
			case "/list_staff":
				listStaff(request, response);
				break;	
			
			//rooms	
				
			case "/new_room":
				showNewRoomForm(request, response);
				break;
			case "/insert_room":
				insertRoom(request, response);
				break;
			case "/delete_room":
				deleteRoom(request, response);
				break;
			case "/edit_room":
				showEditRoomForm(request, response);
				break;
			case "/update_room":
				updateRoom(request, response);
				break;
			case "/list_room":
				listRoom(request, response);
				break;
			case "/login":
				login(request, response);
				break;									
			}
			
			
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}
	
	private void login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		Login login = new Login(username,password);
		boolean res = loginDao.check(login);
		
		if (res) {
			System.out.println("Welcome!");
			RequestDispatcher dispatcher = request.getRequestDispatcher("hotel_management.jsp");
			dispatcher.forward(request, response);
		} else { 
			System.out.println("Wrong username or password.");
			RequestDispatcher dispatcher = request.getRequestDispatcher("login-form.jsp");
			dispatcher.forward(request, response);}	
	}
	
	// Customer
	
	private void showNewCustomerForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("customer-form.jsp");
		dispatcher.forward(request, response);
	}
	
	//Insert 
	private void insertCustomer(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		String customer_name = request.getParameter("customer_name");
		String customer_email = request.getParameter("customer_email");
		String checkin = request.getParameter("checkin");
		String checkout = request.getParameter("checkout");
		Customer newCustomer = new Customer(customer_name, customer_email, checkin, checkout );
		customerDao.insertCustomer(newCustomer);
		response.sendRedirect("list_customer");
	}

	//Delete 
	private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		
		int id_customer = Integer.parseInt(request.getParameter("id_customer"));
		customerDao.deleteCustomer(id_customer);
		response.sendRedirect("list_customer");

	}
	
	//Edit 
	private void showEditCustomerForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id_customer = Integer.parseInt(request.getParameter("id_customer"));
		Customer existingCustomer = customerDao.selectCustomer(id_customer);
		RequestDispatcher dispatcher = request.getRequestDispatcher("customer-form.jsp");
		request.setAttribute("customer", existingCustomer);
		dispatcher.forward(request, response);

	}
	
	//Update 
	private void updateCustomer(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id_customer = Integer.parseInt(request.getParameter("id_customer"));
		String customer_name = request.getParameter("customer_name");
		String customer_email = request.getParameter("customer_email");
		String checkin = request.getParameter("checkin");
		String checkout = request.getParameter("checkout");

		Customer update = new Customer(id_customer, customer_name, customer_email, checkin, checkout);
		customerDao.updateCustomer(update);
		response.sendRedirect("list_customer");
	}
	
	
	// List 
	private void listCustomer(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Customer> listCustomer = customerDao.selectAllCustomers();
		request.setAttribute("listCustomer", listCustomer);
		RequestDispatcher dispatcher = request.getRequestDispatcher("customer-list.jsp");
		dispatcher.forward(request, response);
	}
	
	//Count 
	private void count(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		
		Customer customer_count = customerDao.count_customers();
		request.setAttribute("customer_count", customer_count);
		
		Staff staff_count = staffDao.count_staff();
		request.setAttribute("staff_count", staff_count);
		
		Room room_count = roomDao.count_rooms();
		request.setAttribute("room_count", room_count);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("hotel_management.jsp");
		dispatcher.forward(request, response);
	}
			
	//Staff
	
	private void showNewStaffForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("staff-form.jsp");
		dispatcher.forward(request, response);
	}
	
	//Insert 
	private void insertStaff(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		String staff_name = request.getParameter("staff_name");
		String staff_email = request.getParameter("staff_email");
		String position = request.getParameter("position");
		int salary = Integer.parseInt(request.getParameter("salary"));
		Staff newStaff = new Staff(staff_name, staff_email, position, salary );
		staffDao.insertStaff(newStaff);
		response.sendRedirect("list_staff");
	}
		
	//Delete
	private void deleteStaff(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
			
		int id_staff = Integer.parseInt(request.getParameter("id_staff"));
		staffDao.deleteStaff(id_staff);
		response.sendRedirect("list_staff");

	}
		
	//Edit 
	private void showEditStaffForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id_staff = Integer.parseInt(request.getParameter("id_staff"));
		Staff existingStaff = staffDao.selectStaff(id_staff);
		RequestDispatcher dispatcher = request.getRequestDispatcher("staff-form.jsp");
		request.setAttribute("staff", existingStaff);
		dispatcher.forward(request, response);

	}
	
	//Update 
	private void updateStaff(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id_staff = Integer.parseInt(request.getParameter("id_staff"));
		String staff_name = request.getParameter("staff_name");
		String staff_email = request.getParameter("staff_email");
		String position = request.getParameter("position");
		int salary = Integer.parseInt(request.getParameter("salary"));

		Staff update = new Staff(id_staff, staff_name, staff_email, position, salary);
		staffDao.updateStaff(update);
		response.sendRedirect("list_staff");
		}
	
	
	// List 
	private void listStaff(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Staff> listStaff = staffDao.selectAllStaff();
		request.setAttribute("listStaff", listStaff);
		RequestDispatcher dispatcher = request.getRequestDispatcher("staff-list.jsp");
		dispatcher.forward(request, response);
	}
		
	//Rooms
	
	
	private void showNewRoomForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("room-form.jsp");
		dispatcher.forward(request, response);
	}
	
	//Insert
	private void insertRoom(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int floor = Integer.parseInt(request.getParameter("floor"));
		String customer = request.getParameter("customer");
		String room_attendant = request.getParameter("room_attendant");
		String features = request.getParameter("features");
		String empty_room = request.getParameter("empty_room");
		Room newRoom = new Room(floor, customer, room_attendant, features, empty_room);
		roomDao.insertRoom(newRoom);
		response.sendRedirect("list_room");
	}
	
	//Delete
	private void deleteRoom(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
			
		int id_room = Integer.parseInt(request.getParameter("id_room"));
		roomDao.deleteRoom(id_room);
		response.sendRedirect("list_room");

	}
	
	//Edit
	private void showEditRoomForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id_room = Integer.parseInt(request.getParameter("id_room"));
		Room existingRoom = roomDao.selectRoom(id_room);
		RequestDispatcher dispatcher = request.getRequestDispatcher("room-form.jsp");
		request.setAttribute("room", existingRoom);
		dispatcher.forward(request, response);

	}
	
	//Update
	private void updateRoom(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id_room = Integer.parseInt(request.getParameter("id_room"));
		int floor = Integer.parseInt(request.getParameter("floor"));
		String customer = request.getParameter("customer");
		String room_attendant = request.getParameter("room_attendant");
		String features = request.getParameter("features");
		String empty_room = request.getParameter("empty_room");

		Room update = new Room(id_room, floor, customer, room_attendant, features, empty_room);
		roomDao.updateRoom(update);
		response.sendRedirect("list_room");
		}
	
	//List
	private void listRoom(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Room> listRoom = roomDao.selectAllRooms();
		request.setAttribute("listRoom", listRoom);
		RequestDispatcher dispatcher = request.getRequestDispatcher("room-list.jsp");
		dispatcher.forward(request, response);
	}
	
	
	

}
