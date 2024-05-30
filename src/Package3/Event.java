package Package3;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class Event {
    private final String eventName;
    private final LocalDate date;
    private final LocalTime time;

    public Event(String eventName, LocalDate date, LocalTime time) {
        this.eventName = eventName;
        this.date = date;
        this.time = time;
    }

    public String getEventName() {
        return eventName;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void displayEventDetails(String timeZone) {

        System.out.println("------- EVENT Details -------");
        System.out.println("Name: " + eventName);
        if (timeZone != null) {
            System.out.println("Formated Date: " + formatDate(date, time, timeZone));
        } else
        {
            System.out.println("Date: " + date);
            System.out.println("Time: " + time);
        }
        System.out.println("Day of the month: " + date.getDayOfMonth());
        System.out.println("Is Leap Year: " + (date.isLeapYear() ? "yes" : "no"));
        System.out.println("Number of days for the event: " + calculateTheNumberOfDays(date).getDays());

    }

    public String formatDate(LocalDate eventDate, LocalTime eventTime, String timeZone) {
        // Combine eventDate and eventTime into a ZonedDateTime
        ZoneId zoneId = ZoneId.of(timeZone);
        ZonedDateTime zonedDateTime = ZonedDateTime.of(eventDate, eventTime, zoneId);

        // Define the desired date-time format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, MMMM d, yyyy ' @ ' HH:mm [VV]");

        // Format the ZonedDateTime using the formatter
        return zonedDateTime.format(formatter);
    }

    public Period calculateTheNumberOfDays(LocalDate eventDate) {
        return Period.between(LocalDate.now(), eventDate);
    }
}
