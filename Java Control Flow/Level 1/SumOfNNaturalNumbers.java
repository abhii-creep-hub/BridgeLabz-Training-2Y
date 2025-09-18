import java.util.Scanner;

class SumOfNNaturalNumbers {
   public static void main(String[] args) {
      // Create a Scanner Object
      Scanner input = new Scanner(System.in);

      // Get 3 input values for angles
      System.out.println("Enter the number of integers: ");
      int n = input.nextInt();

      if (n > 0) {
         int sum = n * (n+1) / 2;
         System.out.println("The sum of the first " + n + " integers is: " + sum);
      } else {
         System.out.println("Please enter a positive integer.");
      }

      // Closing the Scanner Stream
      input.close();
   }
}