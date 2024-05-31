package Problem2;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class HeartRates {
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private final int RESTING_HEART_RATE = 60;
    private static final double LOWER_BOUNDARY = 0.5;
    private static final double Upper_BOUNDARY = 0.85;



    public HeartRates (String firstName, String lastName, LocalDate dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
    }


    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    public String getLastName() {
        return this.lastName;
    }

    public int getMaximumHeartRate() {
        return 220 - this.calculateAge();
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int averageHeartRate() {
        return getMaximumHeartRate() - RESTING_HEART_RATE;
    }

    public double lowerBoundaryTargetHeartRate () {
        int avgHeartRate = this.averageHeartRate();
        return (avgHeartRate * LOWER_BOUNDARY) + RESTING_HEART_RATE;
    }

    public double upperBoundaryTargetHeartRate () {
        int avgHeartRate = this.averageHeartRate();
        return (avgHeartRate * Upper_BOUNDARY) + RESTING_HEART_RATE;
    }


    public int calculateAge() {
        LocalDate today = LocalDate.now();
        return Period.between(dateOfBirth, today).getYears();
    }

    @Override
    public String toString() {
        return "First Name: " + firstName +
                "\nLast Name: " + lastName +
                "\nAge: " + calculateAge() +
                "\nDate of Birth: " + dateOfBirth +
                "\nMaximum Heart Rate: " + getMaximumHeartRate();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please, enter your first name:");
        String firstName = scanner.nextLine();

        System.out.println("Please, enter your last name:");
        String lastName = scanner.nextLine();

        System.out.println("Please, enter your birth date in the format-(yyyy-mm-dd)-Example 1989-04-14:");
        String birthDateString = scanner.nextLine();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        LocalDate birthDate = LocalDate.parse(birthDateString, formatter);

        HeartRates heartRates = new HeartRates(firstName, lastName, birthDate);

        System.out.printf("The Target Heart Range is between %.1f and %.1f%n", heartRates.lowerBoundaryTargetHeartRate(), heartRates.upperBoundaryTargetHeartRate());
        System.out.println(heartRates);
    }


}
