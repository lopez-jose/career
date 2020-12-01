import java.util.HashMap;

public class AnagramChecker {
    public static void main(String[] args) {
        System.out.println("This program prints out if two words are anagrams");

        String word1 = "mary";
        String word2 = "affy";

        if (isAnagram(word1, word2)) {
            System.out.printf("'%s' and '%s' are anagrams%n", word1, word2);
        } else {
            System.out.printf("'%s' and '%s' are NOT anagrams%n", word1, word2);
        }
    }

    public static boolean isAnagram(String word1, String word2) {

        char[] characters1 = word1.toCharArray();
        char[] characters2 = word2.toCharArray();

        if (word1.length() != word2.length()) {
            return false;
        }
        HashMap<Character, Integer> charMap1 = new HashMap<Character, Integer>();
        HashMap<Character, Integer> charMap2 = new HashMap<Character, Integer>();

        for (Character ch : characters1) {
            if (charMap1.containsKey(ch)) {
                charMap1.put(ch, charMap1.get(ch) + 1);

            } else {
                charMap1.put(ch, 1);

            }

        }
        for (Character ch : characters2) {
            if (charMap2.containsKey(ch)) {
                charMap2.put(ch, charMap2.get(ch) + 1);

            } else {
                charMap2.put(ch, 1);

            }

        }

        if (charMap1.equals(charMap2))
            return true;
        return false;

    }
}
