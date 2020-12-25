public class SlowestKey {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        int prev = 0;
        char ans = '\0';
        int max = 0;
        for(int i = 0; i < releaseTimes.length; i++) {
            int pressDuration = releaseTimes[i] - prev;            
            if(pressDuration >= max) {
                char expected = keysPressed.charAt(i);
                if(pressDuration > max || expected > ans) {
                    ans = expected;
                }
                
                max = pressDuration;
            }
            
            prev = releaseTimes[i];
        }
        
        return ans;
    }
}
}
