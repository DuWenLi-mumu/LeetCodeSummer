package point;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by 杜文丽 on 7/26/2020 5:09 PM
 * 1.将单词列表中的n个单词统计归整到一个hashmap中
 * 2.从左到右依次扫描n个单词长度，若每个单词都出现在了hashmap中，且数目<=hashmap中保存的数量，则加入res列表
 * 3.若有一个没有出现或者数目大于hashmap中的数目，则break
 **/
public class SubstringWithConcatenationOfAllWords30 {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res=new ArrayList<>();
        if (words.length<=0){
            return res;
        }
        int wordLen=words[0].length();
        int wordNum=words.length;
        HashMap<String,Integer> oriHash=new HashMap<>();
        for (String word:words
             ) {
            if (oriHash.containsKey(word)){
                oriHash.put(word,oriHash.get(word)+1);
            }else {
                oriHash.put(word,1);
            }
        }

        //从头开始扫描
        for (int i = 0; i <s.length()-wordNum*wordLen+1 ; i++) {
            int num=0;
            HashMap<String,Integer> newHash=new HashMap<>();
            while (num<wordNum){
                String currWord=s.substring(i+num*wordLen,i+(num+1)*wordLen);
                if (oriHash.containsKey(currWord)){
                    int currNum=newHash.getOrDefault(currWord,0);
                    if ((currNum+1)>oriHash.get(currWord)){
                        break;
                    }
                    newHash.put(currWord,currNum+1);
                }else {
                    break;
                }
                num++;
            }
            if (num>=wordNum){
                res.add(i);
            }
        }
        return res;
    }
}
