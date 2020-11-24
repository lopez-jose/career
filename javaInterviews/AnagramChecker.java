import java.util.HashMap;
import java.util.Map;

public class AnagramChecker {
    public static void main(String[] args) {
        System.out.println("This program prints out if two words are anagrams");

        String word1 = "mary";
        String word2 = "army";


        System.out.println(isAnagram(word1, word2));
        if(isAnagram(word1,word))

    }

    public static boolean isAnagram(String word1, String word2) {

        char[] characters1 = word1.toCharArray();

        if (word1.length() != word2.length()) {
            return false;
        }
        Map<Character, Integer> charMap1 = new HashMap<Character, Integer>();
        Map<Character, Integer> charMap2 = new HashMap<Character, Integer>();

        for (Character ch : characters1) {
            if (charMap1.containsKey(ch)) {
                charMap1.put(ch, charMap1.get(ch) + 1);
                charMap2.put(ch, charMap2.get(ch) + 1);
            } else {
                charMap1.put(ch, 1);
                charMap2.put(ch, 1);
            }

        }

        if (charMap1.equals(charMap2))
            return true;
        return false;

    }
}
