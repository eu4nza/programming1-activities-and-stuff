import java.util.Scanner;

public class WhileDemo {
  public static void main(String[] args) {
    /* counting from 1 to 10 */
    // int count = 0;
    // do{
    //     count++;
    //     System.out.println("Count is: " + count);
    // } while(count < 10);

    /* iteration from 10 to 1 */
    // for (int i = 10; i>0; i--){
    //     System.out.println("Iteration: " + i);
    // }

    /* Pyramid rows wow */
    Scanner scanner = new Scanner(System.in);

    System.out.print("Enter number of rows for the pyramid: ");
    int rows = scanner.nextInt(); // Number of rows for the pyramid

    // Outer loop for the number of rows
    for (int i = 1; i <= rows; i++) {

      // Inner loop to print leading spaces
      for (int j = 1; j <= rows - i; j++) {
        System.out.print(" ");
      }

      // Inner loop to print stars
      for (int k = 1; k <= 2 * i - 1; k++) {
        System.out.print("*");
        try {
          // Pause for 1 second (1000 milliseconds)
          Thread.sleep(10);
        } catch (InterruptedException e) {
          // Handle the case where the thread is interrupted while sleeping
          System.err.println("Thread interrupted: " + e.getMessage());
          Thread.currentThread().interrupt(); // Re-interrupt the thread
        }
      }

      // Move to the next line after each row
      System.out.println();
    }
  }
}