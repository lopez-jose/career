import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.Assert.assertEquals;
import org.junit.Assert;

public class TwoSumArraySorted {

    public int[] twoSum(int[] numbers, int target) {
        boolean isFound = false;
        int left = 0;
        int right = numbers.length - 1;
        int sum = 0;
        int toReturn0 = 0, toReturn1 = 0;
        while (isFound == false) {
            sum = numbers[left] + numbers[right];
            if (sum == target) {
                toReturn0 = left;
                toReturn1 = right;
                isFound = true;
                return new int[] { toReturn0+1, toReturn1+1 };
            } else if (sum > target) {
                right--;
            } else {
                left++;
            }
        }

        return new int[] { 0, 0 };
    }

    @Test
    public void givenArrayReturns() {
        int[] numbers = { 2, 3, 4 };
        int target = 6;
        int[] array = { 1, 3 };
        Assert.assertArrayEquals(array, this.twoSum(numbers, target));

        int[] numbers2 = { -1, 0 };
        int[] array2 = { 1, 2 };
        Assert.assertArrayEquals(array2, this.twoSum(numbers2, -1));

    }
}