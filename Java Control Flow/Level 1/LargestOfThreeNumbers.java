import java.util.Scanner;

class LargestOfThreeNumbers {
   public static void main(String[] args) {
      // Create a Scanner Object
      Scanner input = new Scanner(System.in);

      // Get 3 input values for angles
      System.out.println("Enter first integer value: ");
      int x = input.nextInt();
      System.out.println("Enter second integer value: ");
      int y = input.nextInt();
      System.out.println("Enter third integer value: ");
      int z = input.nextInt();

      // Find the smallest of the three numbers
      int smallest = x;

      if (y > smallest) {
         smallest = y;
      }
      if (z > smallest) {
         smallest = z;
      }

      System.out.println("The smallest of the three numbers is: " + smallest);
      }

      // Closing the Scanner Stream
   }