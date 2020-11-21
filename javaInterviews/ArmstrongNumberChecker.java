import java.util.Scanner;

public class ArmstrongNumberChecker {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("This Program checks if a number is equal to the cube of every digit");

        System.out.print("Enter the number to check = ");
        int toCheck = input.nextInt();

        if (isArmstrong(toCheck) == true)
            System.out.println(toCheck + " is an Armstrong Number");
        else
            System.out.println(toCheck + " is not an Armstrong Number");
        input.close();

    }

    public static boolean isArmstrong(int n) {

        int number = n;
        int numberToCube = 0;
        int sum = 0;

        int cubeResult = 0;
        while (number != 0) {
            numberToCube = number % 10;

            cubeResult = (int) Math.pow(numberToCube, 3);
            System.out.println(cubeResult);
            sum += cubeResult;
            number = number / 10;
        }

        if (sum == n)
            return true;
        return false;
    }
}
