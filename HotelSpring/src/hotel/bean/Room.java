package hotel.bean;

public class Room {
	
	private int id_room;
	private int floor;
	private String customer;
	private String room_attendant;
	private String features;
	private String empty_room;
	private int rooms_count;
	
	//Constructor 1
	public Room(int rooms_count) {
		
		this.rooms_count = rooms_count;		
	}
	//Constructor 2
	public Room(int floor, String customer, String room_attendant, String features,String empty_room) {
		
		this.floor = floor;
		this.customer = customer;
		this.room_attendant = room_attendant;
		this.features = features;
		this.empty_room = empty_room;
	}
	//Constructor 3
	public Room(int id_room, int floor, String customer, String room_attendant, String features,String empty_room) {
		
		this.id_room = id_room;
		this.floor = floor;
		this.customer = customer;
		this.room_attendant = room_attendant;
		this.features = features;
		this.empty_room = empty_room;
	}

	public int getId_room() {
		return id_room;
	}

	public void setId_room(int id_room) {
		this.id_room = id_room;
	}

	public int getFloor() {
		return floor;
	}

	public void setFloor(int floor) {
		this.floor = floor;
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public String getRoom_attendant() {
		return room_attendant;
	}

	public void setRoom_attendant(String room_attendant) {
		this.room_attendant = room_attendant;
	}

	public String getFeatures() {
		return features;
	}

	public void setFeatures(String features) {
		this.features = features;
	}

	public String getEmpty_room() {
		return empty_room;
	}

	public void setEmpty_room(String empty_room) {
		this.empty_room = empty_room;
	}

	public int getRooms_count() {
		return rooms_count;
	}

	public void setRooms_count(int rooms_count) {
		this.rooms_count = rooms_count;
	}
										
	
}
