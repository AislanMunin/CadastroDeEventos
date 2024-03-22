import controller.EventController;
import controller.UserController;
import model.Event;
import model.User;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final UserController userController = new UserController();
    private static final EventController eventController = new EventController();

    public static void main(String[] args) {
        System.out.println("Welcome to the Event Registration System!");

        while (true) {
            System.out.println("1. Register User");
            System.out.println("2. Create Event");
            System.out.println("3. List Users");
            System.out.println("4. List Events");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    registerUser();
                    break;
                case 2:
                    createEvent();
                    break;
                case 3:
                    listUsers();
                    break;
                case 4:
                    listEvents();
                    break;
                case 5:
                    System.out.println("Exiting the program. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void registerUser() {
        System.out.print("Enter user name: ");
        String name = scanner.nextLine();
        System.out.print("Enter user email: ");
        String email = scanner.nextLine();
        System.out.print("Enter user city: ");
        String city = scanner.nextLine();
        userController.registerUser(name, email, city);
    }

    private static void createEvent() {
        System.out.print("Enter event name: ");
        String name = scanner.nextLine();
        System.out.print("Enter event address: ");
        String address = scanner.nextLine();
        System.out.print("Enter event category: ");
        String category = scanner.nextLine();

        LocalDateTime dateTime = null;
        boolean validDateTime = false;
        while (!validDateTime) {
            try {
                System.out.print("Enter event date and time (yyyy-MM-dd HH:mm): ");
                String dateTimeInput = scanner.nextLine();
                dateTime = LocalDateTime.parse(dateTimeInput, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
                validDateTime = true;
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date and time format. Please enter in the format yyyy-MM-dd HH:mm.");
            }
        }

        System.out.print("Enter event description: ");
        String description = scanner.nextLine();
        eventController.createEvent(name, address, category, dateTime, description);
    }

    private static void listUsers() {
        List<User> users = userController.getUsers();
        System.out.println("Registered Users:");
        for (User user : users) {
            System.out.println(user.getName() + " - " + user.getEmail() + " - " + user.getCity());
        }
    }

    private static void listEvents() {
        List<Event> events = eventController.getEvents();
        System.out.println("Registered Events:");
        for (Event event : events) {
            System.out.println("Name: " + event.getName());
            System.out.println("Address: " + event.getAddress());
            System.out.println("Category: " + event.getCategory());
            System.out.println("Date and Time: " + event.getDateTime());
            System.out.println("Description: " + event.getDescription());
            System.out.println();
        }
    }
}
