import static org.junit.jupiter.api.Assertions.fail;

public class TwoSumArraySorted {

    public int[] twoSum(int[] numbers, int target) {
        boolean isFound = false;
        int left = 0;
        int right = numbers.length - 1;
        int sum = 0;
        int toReturn0 = 0, toReturn1 = 0;
        while (isFound == false) {
            sum = numbers[left]+numbers[right];
            if(sum == target)
            {
                toReturn0 = left;
                toReturn1 = right;
                isFound = true; 
                return new int[] {toReturn0, toReturn1};
            }else if(sum>target)
            {
                right--;
            }else{
                left++;
            }
        }

        return new int[]{0,0};
    }

}