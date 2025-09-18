import java.util.Scanner;

class CountDown2 {

   public static void main(String[] args) {
      Scanner input = new Scanner(System.in);

      System.out.println("Enter the countdown");
      int Start = input.nextInt();

      // Run while loop to access each digit of number
      for (; Start >= 1;) {
         System.out.println(Start--);
      }
      
      // Print the sum and close the Scanner Stream
      System.out.println("Launch!!!");
      input.close();
    }
   }