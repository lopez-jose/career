import java.util.*;
import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.Assert.assertEquals;
import org.junit.Assert;
import java.util.Arrays;

public class LongestSubstringWithoutRepeats {
    public int lengthOfLongestSubstring(String s) {
        int array[] = new int[128];
        Arrays.fill(array, -1);
        char currentChar = s.charAt(0);
        int index = 0;
        int length = 0; 
        while(position<s.length())
        {
            if(array[currentChar]==-1)
            {
                length++;
            }else{
                if(index-array[currentChar]>length)
                {
                    length++;
                }else{

                }

            }
        }


        return 0;
    }

}
