import java.util.Scanner;

public class ReverseString {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("This program reverses a string");
        System.out.print("Enter a string = ");

        String toReverse = input.nextLine();

        System.out.println("The reversed string = " + reverseString(toReverse));
        input.close();
    }

    public static String reverseString(String s) {

        String reverse = "";

        for (int i = s.length() - 1; i >= 0; i--) {
            reverse = reverse + s.charAt(i);
        }
        return reverse;
    }

}
