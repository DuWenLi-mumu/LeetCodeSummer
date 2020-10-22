package jzOffer;

import java.util.*;

/**
 * Created by 杜文丽 on 10/22/2020 3:54 PM
 **/
public class TheFirstCharacterThatAppearsOnlyOnce50 {
    public char firstUniqChar(String s) {
        if (s == "") {
            return ' ';
        }
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < s.length() ; i++) {
            if (map.containsKey(s.charAt(i))){
                map.put(s.charAt(i),map.get(s.charAt(i))+1);
            }else {
                map.put(s.charAt(i),1);
            }
        }
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i))<=1){
                return s.charAt(i);
            }
        }
        return 'o';
    }
}
