import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.Assert.assertEquals;
import org.junit.Assert;

public class SubArraySum {
    public int subarraySum(int[] nums, int k) {
        int sumArray[] = new int[nums.length + 1];
        sumArray[0] = 0;
        int count = 0;
        for (int i = 1; i <= nums.length; i++) {
            sumArray[i] = sumArray[i - 1] + nums[i - 1];
        }
        for (int start = 0; start < nums.length; start++) {
            for (int end = start + 1; end <= nums.length; end++) {
                int sum = sumArray[end] - sumArray[start];
                System.out.println(sumArray[end] + " " + sumArray[start] + " " + sum);
                if (sumArray[end] - sumArray[start] == k) {
                    count++;
                }
            }
            System.out.println("=======Start = " + start);
        }

        return count;
    }

    public int subarraySum1(int[] nums, int k) {
        int count = 0;
        int[] sum = new int[nums.length + 1];
        sum[0] = 0;
        for (int i = 1; i <= nums.length; i++)
            sum[i] = sum[i - 1] + nums[i - 1];
        for (int start = 0; start < nums.length; start++) {
            for (int end = start + 1; end <= nums.length; end++) {
                int total = sum[end] - sum[start];
                System.out.println(sum[end] + " " + sum[start] + " " + total);
                if (sum[end] - sum[start] == k)
                    count++;
            }
        }
        return count;
    }

    @Test
    public void checkifValid() {
        int[] array = new int[] { 1, 2, 3, 4, 5 };

        int a = subarraySum(array, 6);

    }
}
