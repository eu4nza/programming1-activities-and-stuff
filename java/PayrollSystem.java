import java.util.Scanner;

public class PayrollSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n=== Payroll System ===");

        // Input employee name
        System.out.print("Enter Employee Name: ");
        String employeeName = scanner.nextLine();

        // Input hours worked
        System.out.print("Enter Hours Worked: ");
        int hoursWorked = scanner.nextInt();

        // Input hourly rate
        System.out.print("Enter Hourly Rate: ");
        int hourlyRate = scanner.nextInt();

        // Input deductions
        System.out.print("\nEnter Deductions: ");
        int deductions = scanner.nextInt();

        // Calculate gross salary (Arithmetic operator *)
        int grossSalary = hoursWorked * hourlyRate;

        // Calculate bonus using conditional operator (?:)
        // Bonus = 500 if hoursWorked > 160, otherwise 0
        int bonus = (hoursWorked > 160) ? 500 : 0;

        // Calculate total earnings (Arithmetic + assignment operator +=)
        int totalEarnings = grossSalary;
        totalEarnings += bonus;

        // Calculate net salary (Arithmetic + assignment operator -=)
        int netSalary = totalEarnings;
        netSalary -= deductions;

        // Display salary details with 2 decimal places
        System.out.println("\n--- Salary Details ---");
        System.out.printf("Gross Salary: ₱%.2f%n", (double)grossSalary);
        System.out.printf("Bonus: ₱%.2f%n", (double)bonus);
        System.out.printf("Total Earnings: ₱%.2f%n", (double)totalEarnings);
        System.out.printf("Net Salary: ₱%.2f%n", (double)netSalary);

        // Determine employee remarks using logical operators
        // Outstanding if hours > 200 OR netSalary >= 10000
        if (hoursWorked > 200 || netSalary >= 10000) {
            System.out.println("\nRemarks: Outstanding employee!");
        }

        // Needs improvement if netSalary < 10000
        if (netSalary < 10000) {
            System.out.println("\nRemarks: Needs improvement or part-time status.");
        }

        // Close the scanner
        scanner.close();
    }
}
