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
    }

    public static int right_bound(int num[], int limit) {
        int i = 0, j = num.length, mid;

        
    }
}