import java.util.Scanner;

public class oddEvenNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Get input from user
        System.out.print("Enter a natural number: ");
        int number = sc.nextInt();

        // Check if input is a natural number
        if (number < 1) {
            System.out.println("Please enter a natural number (greater than 0).");
        } else {
            // Loop from 1 to number
            for (int i = 1; i <= number; i++) {
                if (i % 2 == 0) {
                    System.out.println(i + " is an Even number.");
                } else {
                    System.out.println(i + " is an Odd number.");
                }
            }
        }

        sc.close();
    }
}
