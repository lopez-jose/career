import java.util.Scanner;

public class SquareRootNewton {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("This program calculates the square root of a number");
        System.out.print("Input a number = ");

        int number = input.nextInt();

        System.out.println("The square root of " + number + " = " + findSquareRoot(number));
        input.close();
    }

    public static double findSquareRoot(int n) {
        double square = 0;
        double start = 1;
        double tempSquare = start;
        for (int i = 0; i < 10; i++) {
            tempSquare = 0.5 * (tempSquare + (n / tempSquare));
            System.out.println(tempSquare);
        }
        square = tempSquare;
        return square;
    }

}
