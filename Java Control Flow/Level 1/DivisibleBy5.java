import java.util.Scanner;

class DivisibleBy5 {
   public static void main(String[] args) {
      // Create a Scanner Object
      Scanner input = new Scanner(System.in);

      // Get 3 input values for angles
      System.out.println("Enter an integer value: ");
      int x = input.nextInt();
     
      // Find the sum of all angles
      int DivisibleBy5 = x%5;

      if (DivisibleBy5 == 0) {
         System.out.println("Is the number " + x + " divisible by 5? Yes");
      } else {
         System.out.println("Is the number " + x + " divisible by 5? No");
      }

      // Closing the Scanner Stream
      input.close();
   }
}
