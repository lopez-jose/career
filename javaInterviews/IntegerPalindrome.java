
import java.util.Scanner;

public class IntegerPalindrome {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter the number = ");

        int toCheck = input.nextInt();

        if (isIntPalindrome(toCheck))
            System.out.println("Number is a Palindrome");
        else
            System.out.println("Number is not a Palindrome");

        input.close();
    }

    public static boolean isIntPalindrome(int n) {

        int number = n;

        int digit = 0;
        String s = "";
        while (number != 0) {

            digit = number % 10;
            number = number / 10;

            s = s + digit;
            System.out.print(digit + " ");

        }

        System.out.println(s);
        if (Integer.valueOf(s) == n)
            return true;

        return false;

    }
}