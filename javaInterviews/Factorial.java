import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("This program calculates the factorial of an inputted number.");

        System.out.print("Enter the number = ");

        int toFactorial = input.nextInt();

        System.out.println("The Factorial of " + toFactorial + " = " + getFactorial(toFactorial));

        System.out.println("The Recursive Factorial of" + toFactorial + " = " + getRecursiveFactorial(toFactorial));
        input.close();
    }

    public static int getFactorial(int n) {

        int value = 1;
        for (int i = 1; i <= n; i++) {
            value = value * i;
        }
        return value;
    }

    public static int getRecursiveFactorial(int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return 1;
        }

        return getRecursiveFactorial((n - 1)) * n;
    }

}
