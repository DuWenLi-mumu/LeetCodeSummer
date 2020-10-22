package jzOffer;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 杜文丽 on 10/17/2020 1:14 PM
 **/
public class TheLongestSubstringWithoutRepeatingCharacters48 {
    public int lengthOfLongestSubstring(String s) {
        int len=s.length();
        if (len<1){
            return 0;
        }
        int max=1;
        int[] f=new int[len];//f[i]存储以第i个字符串结尾的最长不重复子串的长度
        Map<Character,Integer> map=new HashMap<>();
        f[0]=1;
        map.put(s.charAt(0),0);
        for(int i = 1;i < len;i++){
            if (map.containsKey(s.charAt(i))){
                //前面已经出现过了
                int index=map.get(s.charAt(i));
                int d=i-index;
                map.put(s.charAt(i),i);
                if (d<=f[i-1]){
                    f[i]=d;
                }else {
                    f[i]=f[i-1]+1;
                }
            }else {
                f[i]=f[i-1]+1;
                map.put(s.charAt(i),i);
            }
            max=Math.max(max,f[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        TheLongestSubstringWithoutRepeatingCharacters48 test=new TheLongestSubstringWithoutRepeatingCharacters48();
        test.lengthOfLongestSubstring("abcabcbb");
    }
}
