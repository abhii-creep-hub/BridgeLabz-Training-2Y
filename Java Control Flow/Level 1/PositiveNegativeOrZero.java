import java.util.Scanner;

class PositiveNegativeOrZero {
   public static void main(String[] args) {
      // Create a Scanner Object
      Scanner input = new Scanner(System.in);

      // Get 3 input values for angles
      System.out.println("Enter the number: ");
      int n = input.nextInt();

      if (n > 0) {
         System.out.println("Positive.");
      } if (n < 0) {
         System.out.println("Negative.");
      } else {
         System.out.println("Zero.");
      }

      // Closing the Scanner Stream
      input.close();
   }
}