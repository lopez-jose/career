import java.util.List;
import java.util.*;

class SearchSuggestionsBinary {

    int lower_bound(String[] products, int start, String word) {

        int i = start, j = products.length, mid;
        while (i < j) {
            mid = (i + j) / 2;

            if (products[mid].compareTo(word) >= 0)
                j = mid;
            else
                i = mid + 1;

        }
        return i;

    }

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        // We are supposed to return a list of lists;
        Arrays.sort(products);
        List<List<String>> result = new ArrayList<>();
        int start = 0, bsStart = 0, n = products.length;
        String prefix = new String();
        // This is the prefix which we will be searching
        for (char c : searchWord.toCharArray()) {
            prefix += c;
            start = lower_bound(products, bsStart, prefix);
            result.add(new ArrayList<>());
            for (int i = start; i < Math.min(start + 3, n); i++) {
                if (products[i].length() < prefix.length() || !products[i].substring(0, prefix.length()).equals(prefix))
                    break;
                // Here we add this result if it's not greater in length than the prefi and it
                // equals a the prefix for the length of the prefix
                result.get(result.size() - 1).add(products[i]);
            }
            bsStart = Math.abs(start);
        }
        return result;
    }
}
