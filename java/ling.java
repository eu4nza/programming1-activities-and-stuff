import java.util.InputMismatchException;
import java.util.Scanner;

public class ling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int age;

        while (true) {
            System.out.print("Enter your age: ");
            try {
                age = scanner.nextInt();
                break; 
            } catch (InputMismatchException e) {
                System.out.println("Invalid age input.");
                scanner.next();
            }
        }
        System.out.print("Enter a name: ");
        String name = scanner.next();

        System.out.print("Enter a course: ");
        String course = scanner.next();

        System.out.println("\nName " + name);
        System.out.println("Age: " + age);
        System.out.println("Course: " + course);
    }
}
