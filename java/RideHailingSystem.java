import java.util.ArrayList;   // Import for using ArrayList (to store bookings)
import java.util.List;        // Import List interface
import java.util.Scanner;     // Import Scanner for user input

// ---------- Booking class ----------
class Booking {
    int id;            // Unique booking number
    String passenger;  // Passenger name
    String date;       // Booking date
    String time;       // Booking time
    String pickup;     // Pick-up location
    String dropoff;    // Drop-off location
    float distance;   // Distance traveled (in km)
    float fare;       // Fare amount in PHP

    // Constructor to initialize a booking
    public Booking(int id, String passenger, String date, String time,
                   String pickup, String dropoff, float distance, float fare) {
        this.id = id;
        this.passenger = passenger;
        this.date = date;
        this.time = time;
        this.pickup = pickup;
        this.dropoff = dropoff;
        this.distance = distance;
        this.fare = fare;
    }
}

// ---------- Main System Class ----------
public class RideHailingSystem {
    private static final Scanner sc = new Scanner(System.in); // Scanner for console input
    private static final List<Booking> bookings = new ArrayList<>(); // List to hold bookings in memory
    private static int nextBookingId = 1; // Auto-incrementing booking ID counter

    // ---------- MAIN METHOD ----------
    public static void main(String[] args) {
        seedSampleData(); // Add initial sample data for testing

        // Infinite loop to keep showing the menu until user exits
        while (true) {
            // Display main menu options
            System.out.println("\nRIDE-HAILING BOOKING SYSTEM");
            System.out.println("a. View All Bookings");
            System.out.println("b. Book a Ride");
            System.out.println("c. Delete a Booking");
            System.out.println("d. Generate Booking Report");
            System.out.println("e. Exit Application");
            System.out.print("\nSelect an option: ");

            // Read user's choice
            String choice = sc.nextLine().trim().toLowerCase();

            // Perform action based on user input
            switch (choice) {
                case "a" -> viewAllBookings(); // View all bookings
                case "b" -> bookARide();       // Add new booking
                case "c" -> deleteBooking();   // Delete a booking
                case "d" -> generateReport();  // Generate booking report
                case "e" -> {
                    // Exit program
                    System.out.println("\nThank you!");
                    return; // End the main method (and program)
                }
                default -> System.out.println("Invalid option. Please choose a, b, c, d, or e."); // Invalid input
            }
        }
    }

    // ---------- View All Bookings ----------
    private static void viewAllBookings() {
        // If no bookings exist, show message
        if (bookings.isEmpty()) {
            System.out.println("\nNo bookings found.\n");
            return;
        }

        // Print table headers
        System.out.printf("\n%-3s %-12s %-8s %-15s %-20s %-20s %-13s %-10s\n",
                "#", "Date", "Time", "Passenger Name", "Pick-up Location", "Drop-off Location", "Distance(km)", "Fare(PHP)");
        System.out.println("----------------------------------------------------------------------------------------------");

        // Loop through each booking and print details
        for (Booking b : bookings) {
            System.out.printf("%-3d %-12s %-8s %-15s %-20s %-20s %-13.1f %-10.2f\n",
                    b.id, b.date, b.time, b.passenger, b.pickup, b.dropoff, b.distance, b.fare);
        }
        System.out.println(); // Blank line for spacing
    }

    // ---------- Add a New Booking ----------
    private static void bookARide() {
        System.out.println("\nBook a Ride — enter details (leave blank to cancel)");

        // Get passenger name
        System.out.print("Passenger Name: ");
        String passenger = sc.nextLine().trim();
        if (passenger.isEmpty()) {
            System.out.println("Booking cancelled.\n");
            return;
        }

        // Get date
        System.out.print("Date (e.g. 9/10/2024): ");
        String date = sc.nextLine().trim();
        if (date.isEmpty()) {
            System.out.println("Booking cancelled.\n");
            return;
        }

        // Get time
        System.out.print("Time (e.g. 10:00 AM): ");
        String time = sc.nextLine().trim();
        if (time.isEmpty()) {
            System.out.println("Booking cancelled.\n");
            return;
        }

        // Get pickup location
        System.out.print("Pickup Location: ");
        String pickup = sc.nextLine().trim();
        if (pickup.isEmpty()) {
            System.out.println("Booking cancelled.\n");
            return;
        }

        // Get dropoff location
        System.out.print("Dropoff Location: ");
        String dropoff = sc.nextLine().trim();
        if (dropoff.isEmpty()) {
            System.out.println("Booking cancelled.\n");
            return;
        }

        // Get distance and validate numeric input
        float distance;
        while (true) {
            System.out.print("Distance (km): ");
            String input = sc.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("Booking cancelled.\n");
                return;
            }
            try {
                distance = Float.parseFloat(input); // Convert input to float
                if (distance <= 0) {
                    System.out.println("Distance must be greater than 0.");
                    continue; // Ask again
                }
                break; // Valid input
            } catch (NumberFormatException e) {
                System.out.println("Invalid number. Try again.");
            }
        }

        // Calculate fare based on distance
        float fare = calculateFare(distance);

        // Create new Booking object
        int newId = bookings.size() + 1;
        Booking booking = new Booking(newId, passenger, date, time, pickup, dropoff, distance, fare);

        // Add booking to list
        bookings.add(booking);

        // Show confirmation
        System.out.printf("\nBooking successfully added! Booking #%d\n", booking.id);
        System.out.printf("Fare calculated: PHP %.2f\n\n", fare);
    }

    // ---------- Delete a Booking ----------
    private static void deleteBooking() {
        if (bookings.isEmpty()) {
            System.out.println("\nNo bookings to delete.\n");
            return;
        }

        while (true) {
            System.out.print("\nEnter booking number to delete (blank to cancel): ");
            String input = sc.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("Delete cancelled.\n");
                return;
            }

            try {
                int id = Integer.parseInt(input);
                Booking found = null;

                for (Booking b : bookings) {
                    if (b.id == id) {
                        found = b;
                        break;
                    }
                }

                if (found == null) {
                    System.out.println("No booking with that number found.\n");
                    return;
                }

                System.out.printf("Confirm delete booking #%d for %s? (y/N): ",
                        found.id, found.passenger);
                String confirm = sc.nextLine().trim().toLowerCase();

                if (confirm.equals("y")) {
                    bookings.remove(found); // Remove selected record
                    System.out.println("Booking deleted.\n");

                    // Renumber remaining bookings
                    renumberBookings();
                } else {
                    System.out.println("Delete cancelled.\n");
                }
                break;

            } catch (NumberFormatException e) {
                System.out.println("Invalid number.");
            }
        }
    }

    // ---------- Generate Booking Report ----------
    private static void generateReport() {
        System.out.println("\nBOOKING REPORT");

        // If there are no bookings, show message
        if (bookings.isEmpty()) {
            System.out.println("No bookings to report.\n");
            return;
        }

        // Print table headers
        System.out.printf("%-3s %-12s %-8s %-15s %-13s %-10s\n",
                "#", "Date", "Time", "Passenger", "Distance(km)", "Fare(PHP)");
        System.out.println("-------------------------------------------------------------");

        int totalBookings = 0;
        float totalDistance = 0;
        float totalFare = 0;

        // Loop through each booking and print summary
        for (Booking b : bookings) {
            System.out.printf("%-3d %-12s %-8s %-15s %-13.1f %-10.2f\n",
                    b.id, b.date, b.time, b.passenger, b.distance, b.fare);
            totalBookings++;
            totalDistance += b.distance;
            totalFare += b.fare;
        }

        // Print totals
        System.out.println("-------------------------------------------------------------");
        System.out.println("Total Number of Bookings: " + totalBookings);
        System.out.printf("Total Distance: %.1f km\n", totalDistance);
        System.out.printf("Total Fare Collected: PHP %.2f\n\n", totalFare);
    }

    // ---------- Fare Calculation ----------
    private static float calculateFare(float distance) {
        // ₱25 for first kilometer, ₱20 for each additional kilometer
        if (distance <= 1){
            return 25.0f;
        }
        return 25.0f + (distance - 1) * 20.0f;
    }

    // ---------- Renumber all bookings ----------
    private static void renumberBookings() {
        int id = 1;
        for (Booking b : bookings) {
            b.id = id++; // reset IDs sequentially
        }
    }

    // ---------- Seed Sample Data ----------
    private static void seedSampleData() {
        // Clear any previous data just in case
        bookings.clear();

        // Preload 3 example bookings
        bookings.add(new Booking(1, "BenKen", "9/10/2024", "10:00 AM",
                "NU Baliwag", "Boss R", 10.0f, calculateFare(10.0f)));

        bookings.add(new Booking(2, "NebNek", "9/12/2024", "11:00 AM",
                "Puregold Baliwag", "Glorietta Park", 4.8f, calculateFare(4.8f)));

        bookings.add(new Booking(3, "Neburnek", "9/14/2024", "9:00 AM",
                "Boss R", "Sogo Baliwag", 9.1f, calculateFare(9.1f)));
    }
}
