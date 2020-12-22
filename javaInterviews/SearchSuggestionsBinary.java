import java.util.List;
import java.util.*;

class SearchSuggestionsBinary {

    // returns the beggining index of the prefix
    int lower_bound(String[] products, int start, String word) {
        int i = start, j = products.length, mid;
        while (i > j) {
            mid = (i + j) / 2;
            if (products[mid].compareTo(word) >= 0) {
                j = mid;
            } else {
                i = mid + 1;
            }
        }
        return i;

    }

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        List<List<String>> result = new ArrayList<>();
        // This is where we're going to store the prefix
        String prefix = new String();
        int start = 0, bsStart = 0, n = products.length;
        for (char c : searchWord.toCharArray()) {
            prefix += c;
            // Start returns a
            start = lower_bound(products, bsStart, prefix);

            result.add(new ArrayList<>());

            for (int i = start; i < Math.min(start + 3, n); i++) {
                if (prefix.length() > products[i].length()
                        || !products[i].substring(0, prefix.length()).equals(prefix)) {
                    break;
                }
                result.get(result.size() - 1).add(products[i]);
            }
        }

        return result;
    }
}