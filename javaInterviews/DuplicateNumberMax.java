import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class DuplicateNumberMax {
    public static void main(String[] args) {
        System.out.println("This program outputs the max number that matches itself");

        int array[] = { 1, 5, 3, 2, 5, 5, 5, 5, 5, 3, 5, 29, 4, 4, 4, 4, 7, 7, 7, 7, 7, 7, 7 };

        System.out.println("Max matching = " + getMatchingMax(array));
    }

    public static int getMatchingMax(int array[]) {
        int maxMatching = 0;

        Map<Integer, Integer> test = new HashMap<Integer, Integer>();

        for (int i = 0; i < array.length; i++) {
            if (test.containsKey(array[i])) {
                test.put(i, test.get(i) + 1);
            } else {
                test.put(i, 1);
            }
        }
        Set<Map.Entry<Integer, Integer>> entrySet = test.entrySet();
        for (Map.Entry<Integer, Integer> entry : entrySet) {
            System.out.println(entry.getValue() + " " + entry.getKey());

        }

        return maxMatching;
    }
}
