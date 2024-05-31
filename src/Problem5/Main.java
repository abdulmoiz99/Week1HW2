package Problem5;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean isExit = false;
        while (!isExit) {
            System.out.println("Enter C for Circle");
            System.out.println("Enter R for Rectangle");
            System.out.println("Enter T for Triangle");
            System.out.println("Enter E to Exit");

            System.out.print("Enter an option: ");
            Scanner input = new Scanner(System.in);
            String choice = input.nextLine();
            switch (choice) {
                case "C" -> CreateCircle();
                case "R" -> CreateRectangle();
                case "T" -> CreateTriangle();
                case "E" -> isExit = true;
                default -> System.out.println("Invalid choice, please enter valid choice");
            }
        }
    }

    public static void CreateRectangle() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the width of the Rectangle");
        double width = scanner.nextDouble();
        System.out.println("Enter the height of the Rectangle");
        double height = scanner.nextDouble();
        Rectangle rectangle = new Rectangle(width, height);
        System.out.println("The area of Rectangle is: " + rectangle.computeArea());
    }
    public static void CreateTriangle() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the base of the Triangle");
        double base = scanner.nextDouble();
        System.out.println("Enter the height of the Triangle");
        double height = scanner.nextDouble();
        Triangle triangle = new Triangle(base, height);
        System.out.println("The area of Triangle is: " + triangle.computeArea());
    }
    public static void CreateCircle() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the radius of the Circle");
        double radius = scanner.nextDouble();
        Circle circle = new Circle(radius);
        System.out.println("The area of Circle is: " + circle.computeArea());
    }
}
