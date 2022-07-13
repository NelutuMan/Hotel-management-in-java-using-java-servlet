package hotel.bean;

public class Customer {
	private int id_customer;
	private String customer_name;
	private String customer_email;
	private String checkin;
	private String checkout;
	private int customers_count;

	//constructor 1
	public Customer(int customers_count) {
		
		this.customers_count = customers_count;
	}
	
	//constructor 2
	public Customer(String customer_name, String customer_email, String checkin, String checkout) {
		
		this.customer_name = customer_name;
		this.customer_email = customer_email;
		this.checkin = checkin;
		this.checkout = checkout;
	}
	
	//constructor 3
	public Customer(int id_customer, String customer_name, String customer_email, String checkin, String checkout) {
		
		this.id_customer = id_customer;
		this.customer_name = customer_name;
		this.customer_email = customer_email;
		this.checkin = checkin;
		this.checkout = checkout;
	}
	public int getId_customer() {
		return id_customer;
	}
	public void setId_customer(int id_customer) {
		this.id_customer = id_customer;
	}
	public String getCustomer_name() {
		return customer_name;
	}
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
	public String getCustomer_email() {
		return customer_email;
	}
	public void setCustomer_email(String customer_email) {
		this.customer_email = customer_email;
	}
	public String getCheckin() {
		return checkin;
	}
	public void setCheckin(String checkin) {
		this.checkin = checkin;
	}
	public String getCheckout() {
		return checkout;
	}
	public void setCheckout(String checkout) {
		this.checkout = checkout;
	}
	public int getCustomers_count() {
		return customers_count;
	}
	
	public void setCustomers_count(int customers_count) {
		 this.customers_count = customers_count;
	}
	
}