import java.util.Scanner;

class PersonCanVote {
   public static void main(String[] args) {
      // Create a Scanner Object
      Scanner input = new Scanner(System.in);

      // Get 3 input values for angles
      System.out.println("Enter your age: ");
      int n = input.nextInt();

      if (n >=18) {
         System.out.println("The person can vote.");
      } else {
         System.out.println("The person cannot vote.");
      }

      // Closing the Scanner Stream
      input.close();
   }
}