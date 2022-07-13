package hotel.bean;

public class Staff {
	
	private int id_staff;
	private String staff_name;
	private String staff_email;
	private String position;
	private int salary;
	private int staff_count;
	
	//Constructor 1
	public Staff(int staff_count) {
		
		this.staff_count = staff_count;
	}
	
	//Constructor 2
	public Staff(String staff_name, String staff_email, String position, int salary) {
		
		this.staff_name = staff_name;
		this.staff_email = staff_email;
		this.position = position;
		this.salary = salary;
	}
	
	//Constructor 3
	public Staff(int id_staff, String staff_name, String staff_email, String position, int salary) {
		
		this.id_staff = id_staff;
		this.staff_name = staff_name;
		this.staff_email = staff_email;
		this.position = position;
		this.salary = salary;
	}
	
	public int getId_staff() {
		return id_staff;
	}
	
	public void setId_staff(int id_staff) {
		this.id_staff = id_staff;
	}
	
	public String getStaff_name() {
		return staff_name;
	}
	
	public void setStaff_name(String staff_name) {
		this.staff_name = staff_name;
	}
	
	public String getStaff_email() {
		return staff_email;
	}
	
	public void setStaff_email(String staff_email) {
		this.staff_email = staff_email;
	}
	
	public String getPosition() {
		return position;
	}
	
	public void setPosition(String position) {
		this.position = position;
	}
	
	public int getSalary() {
		return salary;
	}
	
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	public int getStaff_count() {
		return staff_count;
	}
	
	public void setStaff_count(int staff_count) {
		this.staff_count = staff_count;
	}
			
}
