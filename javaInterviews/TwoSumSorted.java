import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.Assert.assertEquals;

public class TwoSumSorted {
    public static void main(String[] args) {
        System.out.println("Hello world");
        int[] numbers = { 2, 3, 4 };
        int target = 6;
        int[] output = twoSum(numbers, target);

        for (int i = 0; i < output.length; i++) {
            System.out.print(output[i] + " ");
        }

    }

    public static int[] twoSum(int[] numbers, int target) {
        boolean isFound = false;
        int startPosition = 0;
        while (isFound == false) {
            int toFind = target - numbers[startPosition];
            int position = binarySearch(numbers, toFind, (startPosition + 1));
            if (position != startPosition) {
                return new int[] { numbers[startPosition], numbers[position] };
            }
            startPosition++;

        }
        return new int[] { 0, 0 };
    }

    public static int binarySearch(int[] numbers, int target, int low) {
        int high = numbers.length, middle;
        int savedLow = low - 1; // original position
        while (low < high) {
            middle = (low + high) / 2;
            if (target == numbers[middle]) {
                return middle;
            }
            if (target < numbers[middle]) {
                high = middle - 1;
            } else {
                low = middle + 1;
            }
        }
        return savedLow;
    }

    @Test
    public void givenArrayReturns() {
        int[] numbers = { 2, 3, 4 };
        int target = 6;
        int[] array = { 1, 2 };
        assertEquals(array, twoSum(numbers, target));

    }
}
