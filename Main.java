package main;

import model.*;
import exception.RoomUnavailableException;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Hotel hotel = new Hotel();
        Scanner scanner = new Scanner(System.in);

        // Adding some rooms for testing
        hotel.addRoom(new StandardRoom(101, 2000));
        hotel.addRoom(new SuiteRoom(102, 5000));

        while (true) {
            System.out.println("\nHotel Booking System:");
            System.out.println("1. View Available Rooms");
            System.out.println("2. Create Booking");
            System.out.println("3. Cancel Booking");
            System.out.println("4. View All Bookings");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    hotel.viewAvailableRooms();
                    break;

                case 2:
                    System.out.print("Enter Customer ID: ");
                    int customerId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter Customer Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Contact: ");
                    String contact = scanner.nextLine();
                    System.out.print("Enter Room ID: ");
                    int roomId = scanner.nextInt();
                    System.out.print("Enter Duration (in days): ");
                    int duration = scanner.nextInt();

                    Customer customer = new Customer(customerId, name, contact);
                    Room room = hotel.getRoomById(roomId);
                    if (room != null) {
                        try {
                            hotel.createBooking(customer, room, duration);
                        } catch (RoomUnavailableException e) {
                            System.out.println(e.getMessage());
                        }
                    } else {
                        System.out.println("Room ID " + roomId + " not found.");
                    }
                    break;

                case 3:
                    System.out.print("Enter Booking ID to cancel: ");
                    int bookingId = scanner.nextInt();
                    hotel.cancelBooking(bookingId);
                    break;

                case 4:
                    hotel.viewAllBookings();
                    break;

                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
