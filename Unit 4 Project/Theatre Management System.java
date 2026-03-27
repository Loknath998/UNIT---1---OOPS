import java.util.*;
class BookingException extends Exception {
    public BookingException(String message) {
        super(message);
    }
}
class Show {
    private String movieName;
    private int totalSeats;
    private int bookedSeats;
    public Show(String movieName, int totalSeats) {
        this.movieName = movieName;
        this.totalSeats = totalSeats;
        this.bookedSeats = 0;
    }
    public void bookSeat(int seatsToBook) throws BookingException {
        if (seatsToBook <= 0) {
            throw new BookingException("Invalid number of seats.");
        }
        if (bookedSeats + seatsToBook > totalSeats) {
            throw new BookingException("Housefull! Only " + (totalSeats - bookedSeats) + " seats left.");
        }
        bookedSeats += seatsToBook;
        System.out.println("Successfully booked " + seatsToBook + " seats for " + movieName);
    }
    @Override
    public String toString() {
        return movieName + " (Available: " + (totalSeats - bookedSeats) + "/" + totalSeats + ")";
    }
}
public class CinemaManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<Integer, Show> theatreShows = new HashMap<>();
        theatreShows.put(101, new Show("Avatar 2", 50));
        theatreShows.put(102, new Show("Inception", 30));

        while (true) {
            System.out.println("\n--- CINEMA THEATRE MANAGEMENT ---");
            System.out.println("1. View Shows");
            System.out.println("2. Book Tickets");
            System.out.println("3. Exit");
            System.out.print("Choice: ");
            try {
                int choice = Integer.parseInt(sc.nextLine());
                if (choice == 1) {
                    System.out.println("\n--- Current Shows ---");
                    for (int id : theatreShows.keySet()) {
                        System.out.println("ID: " + id + " | " + theatreShows.get(id));
                    }
                } 
                else if (choice == 2) {
                    System.out.print("Enter Show ID: ");
                    int id = Integer.parseInt(sc.nextLine());
                    if (!theatreShows.containsKey(id)) {
                        throw new BookingException("Error: Show ID " + id + " does not exist.");
                    }
                    System.out.print("Enter number of seats: ");
                    int count = Integer.parseInt(sc.nextLine());
                    theatreShows.get(id).bookSeat(count);
                } 
                else if (choice == 3) {
                    System.out.println("Closing System...");
                    break;
                } 
                else {
                    System.out.println("Invalid Option.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Input Error: Please enter numbers only.");
            } catch (BookingException e) {
                System.out.println("Booking Refused: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("An unexpected error occurred: " + e);
            }
        }
        sc.close();
    }
}
