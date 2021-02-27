package everyday_problem;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class TheOldestStringWithAtLeastKRepeatingCharacters395 {
    public int longestSubstring(String s, int k) {
        if (k <= 1) return s.length();
        if (s.isEmpty() || s.length() < k) return 0;
        int[] hash = new int[128];
        for (int i = 0; i < s.length(); i++) {
            hash[s.charAt(i) - 'a']++;
        }
        int i = 0;
        while (i < s.length() && hash[s.charAt(i) - 'a'] >= k){
            i++;
        }
        if (i >= s.length()){
            return s.length();
        }

        int left = longestSubstring(s.substring(0,i),k);
        while (i < s.length() && hash[s.charAt(i) - 'a'] < k){
            i++;
        }
        int right = longestSubstring(s.substring(i),k);
        return Math.max(left,right);
    }
}
