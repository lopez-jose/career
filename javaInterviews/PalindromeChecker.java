import java.util.*;

public class PalindromeChecker {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String toCheck = "";
        System.out.println("This program checks if the inputted string is a palindrome");
        System.out.print("Enter a string = ");
        toCheck = input.nextLine();

        if (is_Palindrome_recursive(toCheck))
            System.out.println(toCheck + " is a Palindrome");
        else
            System.out.println(toCheck + " is not a Palindrome");
        input.close();
    }

    public static boolean is_Palindrome(String s) {

        int length = s.length() - 1;
        for (int i = 0; i < (s.length() / 2); i++) {
            if (s.charAt(i) != s.charAt(length - i)) {
                return false;
            }
        }
        return true;
    }

    public static boolean is_Palindrome_recursive(String s) {
        if (s.length() == 1 || s.length() == 0) {
            return true;
        }

        String subString = "";
        for (int i = 1; i < s.length() - 1; i++) {
            subString += s.charAt(i);
        }
        if (s.charAt(0) != s.charAt(s.length() - 1))
            return false;
        return is_Palindrome_recursive(subString);
    }
}