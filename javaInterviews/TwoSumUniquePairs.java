import java.util.*;

public class TwoSumUniquePairs {

    public static void main(String[] args) {

        int nums[] = { 1, 1, 2, 45, 46, 46, 59, 23, 39, 53, 99, 98, 97, 96, 95 };
        Arrays.sort(nums);
        printArray(nums);
    }

    public static void printArray(int nums[]) {
        for (int i = 0; i < nums.length; i++) {
            System.out.printf("%d ", nums[i]);
        }
        System.out.println();
        System.out.println(right_bound(nums));
    }

    public static int right_bound(int nums[], int limit) {
        int i = 0, j = num.length, middle;
        while (i < j) {
            middle = (i + j) / 2;
            if (nums[middle] == limit) {
                return middle;
            }
            if (nums[middle] > limit) {
                j = middle;
            } else {
                i = middle + 1;
            }
        }
        return -1;

    }
}