package model;

import java.util.HashMap;
import java.util.Map;

import exception.RoomUnavailableException;

public class Hotel {
	private Map<Integer,Room> rooms;
	private Map<Integer,Booking> bookings;
	private int nextBookingId=1;
	 
	public Hotel() {
		rooms=new HashMap<>();
		bookings=new HashMap<>();
	}
	public void addRoom(Room room) {
		rooms.put(room.getRoomId(),room) ;
		
	}
	public void createBooking(Customer customer,Room room,int duration) throws RoomUnavailableException {
		if(room.isAvailablity()) {
			room.setAvailablity(false);
			Booking book=new Booking(nextBookingId++,customer,room,duration);
			bookings.put(book.getBookingId(), book);
			System.out.println("Booking created: "+book);
		}
		else {
			throw new RoomUnavailableException("Room "+room.getRoomId()+" is not available");
		}
	}

	public void cancelBooking(int bookingId) {
		Booking book = bookings.get(bookingId);
		if(book!=null) {
			book.getRoom().setAvailablity(true);
			Booking.remove(bookingId);
			System.out.println("Booking canceled: " + bookingId);
			
		}
		else {
            System.out.println("Booking ID " + bookingId + " not found");

		}
	}
	public boolean checkAvailability(int roomId) {
        Room room = rooms.get(roomId);
        return room != null && room.isAvailablity();
    }
	public void viewAllBookings() {
        if (bookings.isEmpty()) {
            System.out.println("No bookings found.");
        } else {
            for (Booking booking : bookings.values()) {
                System.out.println("Booking ID: " + booking.getBookingId() +
                        ", Room ID: " + booking.getRoom().getRoomId() +
                        ", Customer: " + booking.getCustomer().getName() +
                        ", Duration: " + booking.getDuration() + " days");
            }
        }
    }
	public void viewAvailableRooms() {
        System.out.println("Available Rooms:");
        for (Room room : rooms.values()) {
            if (room.isAvailablity()) {
                System.out.println("Room ID: " + room.getRoomId() +
                        ", Type: " + room.getRoomType() +
                        ", Price: " + room.getPrice());
            }
        }
    }
	public Room getRoomById(int roomId) {
		// TODO Auto-generated method stub
		return null;
	}
}
