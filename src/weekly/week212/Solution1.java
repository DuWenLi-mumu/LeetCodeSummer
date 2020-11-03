package weekly.week212;

/**
 * Created by 杜文丽 on 10/25/2020 10:29 AM
 **/
public class Solution1 {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        char c = keysPressed.charAt(0);
        int continueTime = releaseTimes[0];
        for (int i = 1; i < keysPressed.length() ; i++) {
            int currTime = releaseTimes[i] - releaseTimes[i-1];
            if (currTime > continueTime){
                continueTime = currTime;
                c = keysPressed.charAt(i);
            }else if (continueTime == currTime){
                if (c < keysPressed.charAt(i)){
                    c = keysPressed.charAt(i);
                }
            }
        }
        return c;
    }
}
