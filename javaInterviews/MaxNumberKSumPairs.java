import java.util.*;

public class MaxNumberKSumPairs {
    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int operations = 0;
        int low = 0, high = nums.length - 1;

        while (low < high) {
            if (nums[low] + nums[high] > k) {
                high--;
            } else if (nums[low] + nums[high] < k) {
                low++;
            } else {
                operations++;
                high--;
                low++;
            }

        }
        return operations;
    }
}
