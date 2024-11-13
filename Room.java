package model;

public abstract class Room {
    private int roomId;
    private String roomType;
    private double price;
    private boolean availablity;
	public int getRoomId() {
		return roomId;
	}
	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}
	
	public String getRoomType() {
		return roomType;
	}
	
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public boolean isAvailablity() {
		return availablity;
	}
	
	public void setAvailablity(boolean availablity) {
		this.availablity = availablity;
	}
	
    
}
