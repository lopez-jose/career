import java.util.Scanner;

public class PrimeChecker {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("This program is a prime number checker");

        System.out.print("Enter a number =");

        int n = input.nextInt();

        if (isPrime(n))
            System.out.println(n + " is Prime");
        else
            System.out.println(n + " is not Prime");

        input.close();

    }

    public static boolean isPrime(int n) {

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0)
                return false;
        }

        return true;
    }

}
