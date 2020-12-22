
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
}
