import java.util.ArrayList;

public class ReverseWords {
    public static void main(String[] args) {
        System.out.println("This program reverses the order of words in a sentence.");

        String words = "Take a seat over there";

        System.out.println("Original string = " + words);
        ArrayList<String> toPrint = reverseWords(words);

        System.out.println("Reversed string = " + toPrint);

    }

    public static ArrayList<String> reverseWords(String words) {
        String tempString = "";

        ArrayList<String> reverseString = new ArrayList<String>();
        ArrayList<String> returnString = new ArrayList<String>();

        for (int i = 0; i < words.length(); i++) {
            if (words.charAt(i) == ' ') {
                reverseString.add(tempString);
                tempString = "";

            } else {
                tempString = tempString + words.charAt(i);
            }
        }

        for (int i = reverseString.size() - 1; i >= 0; i--) {
            returnString.add(reverseString.get(i));
        }
        reverseString.add(tempString);

        return returnString;
    }

}
