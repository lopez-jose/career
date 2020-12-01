import java.util.HashMap;
import java.util.Map;

public class ReverseDuplicateWords {
    public static void main(String[] args) {
        String input = "the sun is lifted up by the moon.\n";

        reverseDuplicates(input);

    }

    public static void reverseDuplicates(String input) {

        Map<String, Integer> stringMap = new HashMap<String, Integer>();

        int position = 0;
        String tempString = "";
        String toPrint = "";
        while (input.charAt(position) != '\n') {
            char cChar = input.charAt(position);
            // System.out.print(input.charAt(position));
            if (cChar == ' ' || position == input.length() - 2) {
                if (stringMap.containsKey(tempString)) {
                    stringMap.put(tempString, stringMap.get(tempString) + 1);

                    toPrint += reverseString(tempString) + " ";

                } else {
                    stringMap.put(tempString, 1);
                    toPrint += tempString + " ";
                }

                tempString = "";
            } else {
                tempString += cChar;
            }
            position++;
        }

        System.out.println(toPrint);

    }

    public static String reverseString(String input) {
        String reverse = "";

        for (int i = input.length() - 1; i >= 0; i--) {
            reverse += input.charAt(i);
        }
        System.out.println(reverse);

        return reverse;
    }

}
