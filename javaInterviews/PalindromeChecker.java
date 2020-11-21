import java.util.*;

public class PalindromeChecker {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String toCheck = "";
        System.out.println("This program checks if the inputted string is a palindrome");
        System.out.print("Enter a string = ");
        toCheck = input.nextLine();

    }

    public static boolean isPalindrome(String s) {

        int length = s.length();
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(length - i)) {
                return false;
            }
        }
        return true;
    }
}