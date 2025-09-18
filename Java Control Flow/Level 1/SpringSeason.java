import java.util.Scanner;

class SpringSeason {
   public static void main(String[] args) {
      // Create a Scanner Object
      Scanner input = new Scanner(System.in);

      // Get 3 input values for angles
      System.out.println("Enter the month: ");
      int a = input.nextInt();
      System.out.println("Enter the day: ");
      int b = input.nextInt();

      if (a>=1 && a<=12 && b>=1 && b<=31) {
         System.out.println("Its a Spring Season");
      }else {
         System.out.println("“Not Spring Season”");
      }

      // Closing the Scanner Stream
      input.close();
   }
}