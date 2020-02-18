package greedy;

import java.util.*;

/**
 * Created by 杜文丽 on 2/18/2020 10:56 AM
 **/
public class PartitionLabels763 {
    public static void main(String[] args) {
        String S = "ababcbacadefegdehijhklij";
        List<Integer> res=partitionLabels(S);
    }

    public static List<Integer> partitionLabels(String S) {
        Map<Character, int[]> map = new HashMap<>();
        for (int i = 0; i < S.length(); i++) {
            if (map.containsKey(S.charAt(i))) {
                int[] index = map.get(S.charAt(i));
                index[1] = i;
                map.put(S.charAt(i), index);

            } else {
                int[] index = {i, -1};
                map.put(S.charAt(i),index);
            }
        }
        //遍历index
        Collection<int[]> indexs= map.values();
        int[][] indexsRes=new int[indexs.size()][2];
        int k=0;
        for (int[] single:indexs
             ) {
            indexsRes[k][0]=single[0];
            if (single[1]==-1){
                single[1]=single[0];
            }
            indexsRes[k][1]=single[1];
            k++;
        }

        Arrays.sort(indexsRes,Comparator.comparingInt(o->o[0]));//按照x升序排序
        int[] used=new int[indexsRes.length];//0代表未用，1代表用了
        List<Integer> res=new ArrayList<>();
        for (int i = 0; i <indexsRes.length ; i++) {
            if (used[i]==1){
                continue;
            }
            int left=indexsRes[i][0];
            int right=indexsRes[i][1];
            used[i]=1;
            for (int j = i+1; j <indexsRes.length ; j++) {
                if (used[j]==0){
                    if (indexsRes[j][0]<right){
                        if (indexsRes[j][1]>right){
                            right=indexsRes[j][1];
                        }
                        used[j]=1;
                        if (left>indexsRes[j][0]){
                            left=indexsRes[j][0];
                        }
                    }
                }
            }
            res.add(right-left+1);
        }
        return res;
    }
}
