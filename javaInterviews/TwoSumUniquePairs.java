import java.util.*;

public class TwoSumUniquePairs {

    public static void main(String[] args) {

        int nums[] = { 1, 1, 2, 45, 46, 46 };
        Arrays.sort(nums);
        printArray(nums);
    }

    public static void printArray(int nums[]) {
        for (int i = 0; i < nums.length; i++) {
            System.out.printf("%d ", nums[i]);
        }
        System.out.println();
        System.out.println(classic_binary_search(nums, 46));
        System.out.println(right_binary_search(nums, 37));
        System.out.println(left_binary_search(nums, 46));
    }

    public static int classic_binary_search(int nums[], int limit) {
        int low = 0, high = nums.length - 1, middle;
        while (low < high) {
            middle = (low + high) / 2;
            if (nums[middle] == limit) {
                return middle;
            }
            if (nums[middle] > limit) {
                high = middle - 1;
            } else {
                low = middle + 1;
            }
        }
        return -1;

    }

    public static int right_binary_search(int nums[], int limit) {
        int low = 0, high = nums.length - 1, middle;
        int count = 0;
        while (low < high) {
            middle = (low + high) / 2;
            if (limit < nums[middle]) {
                high = middle - 1;
            } else {
                low = middle + 1;
            }
            System.out.println(count++);
        }
        return high;
    }

    public static int left_binary_search(int nums[], int limit) {
        int low = 0, high = nums.length - 1, middle;

        while (low < high) {
            System.out.printf("Low = %d, High = %d\n", low, high);
            middle = (low + high) / 2;
            if (limit > nums[middle]) {
                low = middle + 1;
            } else {
                high = middle - 1;
            }
        }
        return low;
    }
}