package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class Booking
{
	private int bookingId;
    private Room room;
    private Customer customer;
    private Date bookingDate;
    private int duration;
    private static List<Booking> bookings = new ArrayList<>();
    
    public Booking(int bookingId, Customer customer, Room room, int duration) {
        this.bookingId = bookingId;
        this.customer = customer;
        this.room = room;
        this.duration = duration;
        this.bookingDate = new Date();
        bookings.add(this);
    }

    public int getBookingId() {
        return bookingId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Room getRoom() {
        return room;
    }

    public int getDuration() {
        return duration;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

	public static boolean remove(int bookingId) {
		// TODO Auto-generated method stub
		 Iterator<Booking> iterator = bookings.iterator();
	        while (iterator.hasNext()) {
	            Booking booking = iterator.next();
	            if (booking.getBookingId() == bookingId) {
	                iterator.remove(); 
	                return true; 
	            }
	        }
	        return false; 
	}

	

}
