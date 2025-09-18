import java.util.Scanner;

public class FriendsComparison {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Taking input for Amar
        System.out.print("Enter Amar's age: ");
        int ageAmar = sc.nextInt();
        System.out.print("Enter Amar's height (in cm): ");
        int heightAmar = sc.nextInt();

        // Taking input for Akbar
        System.out.print("Enter Akbar's age: ");
        int ageAkbar = sc.nextInt();
        System.out.print("Enter Akbar's height (in cm): ");
        int heightAkbar = sc.nextInt();

        // Taking input for Anthony
        System.out.print("Enter Anthony's age: ");
        int ageAnthony = sc.nextInt();
        System.out.print("Enter Anthony's height (in cm): ");
        int heightAnthony = sc.nextInt();

        // Finding youngest
        if (ageAmar < ageAkbar && ageAmar < ageAnthony) {
            System.out.println("Youngest friend is Amar with age " + ageAmar);
        } else if (ageAkbar < ageAnthony) {
            System.out.println("Youngest friend is Akbar with age " + ageAkbar);
        } else {
            System.out.println("Youngest friend is Anthony with age " + ageAnthony);
        }

        // Finding tallest
        if (heightAmar > heightAkbar && heightAmar > heightAnthony) {
            System.out.println("Tallest friend is Amar with height " + heightAmar + " cm");
        } else if (heightAkbar > heightAnthony) {
            System.out.println("Tallest friend is Akbar with height " + heightAkbar + " cm");
        } else {
            System.out.println("Tallest friend is Anthony with height " + heightAnthony + " cm");
        }

        sc.close();
    }
}
