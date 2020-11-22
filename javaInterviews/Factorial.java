import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("This program calculates the factorial of an inputted number.");

        System.out.print("Enter the number = ");

        int toFactorial = input.nextInt();

        System.out.println("The Factorial of " + toFactorial + " = " +getFactorial(toFactorial);

        input.close();
    }

    public static int getFactorial(int n) {

        int value = 1;
        for (int i = 1; i <= n; i++) {
            value = value * i;
        }
        return value;
    }

}
