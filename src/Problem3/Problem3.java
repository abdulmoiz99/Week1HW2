package Problem3;

import java.util.ArrayList;

public class Problem3 {
    static ArrayList<Event> events = new ArrayList<Event>();

    public static void main(String[] args) {

        boolean isExit = false;
        ConsoleHandler _handler = new ConsoleHandler();
        while (!isExit) {
            _handler.DisplayMenu();
            System.out.println("Please enter choice:");
            int userChoice = _handler.TakeChoiceInput();
            switch (userChoice) {
                case 1 -> _handler.AddEvent(events);
                case 2 -> _handler.DisplayEvents(events);
                case 3 -> _handler.FormatEventDetails(events);
                case 0 -> isExit = true;
                default -> System.out.println("Invalid choice, please enter valid choice");
            }
            ;
        }
    }
}
