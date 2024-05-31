package Package3;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class ConsoleHandler {

    public void DisplayMenu() {
        System.out.println("--------- Event Manager ---------");
        System.out.println("1. Add Event");
        System.out.println("2. Display Events");
        System.out.println("3. Format Event Details");
        System.out.println("0. Exit");

    }

    public int TakeChoiceInput() {
        Scanner input = new Scanner(System.in);
        return input.nextInt();
    }

    public void AddEvent(ArrayList<Event> events) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input event name");
        String eventName = scanner.nextLine();
        LocalDate eventDate = getEventDate(scanner);
        Event event = new Event(eventName, eventDate, LocalTime.MAX);
        events.add(event);
        System.out.println("Event added successfully.");
        event.displayEventDetails(null);
    }
    public void FormatEventDetails(ArrayList<Event> events) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter time zone");
        String timeZone = scanner.nextLine();
        for (Event e : events) {
            e.displayEventDetails(timeZone);
        }
    }
    public void DisplayEvents(ArrayList<Event> events) {
        for (Event e : events) {
            e.displayEventDetails(null);
        }
    }

    public LocalDate getEventDate(Scanner scanner) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-M-d");
        while (true) {
            System.out.println("Please enter event date in yyyy-MM-dd format (e.g. 1980-9-28): ");
            String input = scanner.nextLine();
            try {
                return LocalDate.parse(input, formatter);

            } catch (DateTimeParseException e) {
                System.out.println("Please enter date in yyyy-MM-dd format (e.g. 1980-9-28): ");
            }
        }
    }
}
