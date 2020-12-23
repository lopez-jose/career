import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.Assert.assertEquals;
import org.junit.Assert;

public class TwoSumSorted {
    public static void main(String[] args) {
        System.out.println("Hello world");
        int[] numbers = { 2, 7, 11, 15 };
        int target = 9;
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
            System.out.printf("toFind = %d, position = %d\n", toFind, position);
            if (position != startPosition) {
                return new int[] { startPosition + 1, position + 1 };
            }
            startPosition++;

        }
        return new int[] { 0, 0 };
    }

    public static int binarySearch(int[] numbers, int target, int low) {
        int high = numbers.length - 1, middle;
        int savedLow = low - 1; // original position
        while (low <= high) {
            middle = (low + high) / 2;
            System.out.printf("Low = %d, high =%d,  Array middle = %d\n", low, high, numbers[middle]);
            if (target == numbers[middle]) {
                System.out.println(middle);
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
        int[] array = { 1, 3 };
        Assert.assertArrayEquals(array, twoSum(numbers, target));

        int[] numbers2 = { -1, 0 };
        int[] array2 = { 1, 2 };
        Assert.assertArrayEquals(array2, twoSum(numbers2, -1));

    }
}
