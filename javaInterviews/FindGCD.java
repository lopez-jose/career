import java.util.Scanner;

public class FindGCD {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("This Program returns the GCD of two inputted numbers");
        System.out.print("Enter the First Number = ");
        int num1 = input.nextInt();
        System.out.print("Enter the Second Number = ");
        int num2 = input.nextInt();

        System.out.printf("The GCD of " + num1 + " and " + num2 + " = " + returnGCD(num1, num2) + "\n");
        input.close();

    }

    public static int returnGCD(int num1, int num2) {

        if (num1 == 0)
            return num2;
        if (num2 == 0)
            return num1;

        if (num1 > num2)
            return returnGCD(num1 % num2, num2);
        else
            return returnGCD(num2 % num1, num1);
    }
}
