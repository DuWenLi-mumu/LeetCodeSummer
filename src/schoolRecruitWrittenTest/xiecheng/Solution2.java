package schoolRecruitWrittenTest.xiecheng;

import java.util.*;

public class Solution2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<Integer> visited = new ArrayList<>();
        List<Integer> pivot = new ArrayList<>();
        List<Integer> newPivot = new ArrayList<>();
        Set<Integer> res = new HashSet<>();
        //输入
        int n = in.nextInt();
        String s = in.nextLine();
        while (in.hasNextLine()){
            String str = in.nextLine();
            if (str.length() <= 1){
                break;
            }
            String[] chars = str.split(",");

            int key = Integer.valueOf(chars[0]);

            List<Integer> list = new ArrayList<>();
            for (int i = 1; i < chars.length; i++) {
                list.add(Integer.valueOf(chars[i]));
            }
            map.put(key,list);
        }

        //处理
        visited.add(n);
        pivot.add(n);

        boolean haschanged = false;
        boolean change = true;
        while (change){
            change = false;
            for (Integer p:pivot
                 ) {
                for(Map.Entry<Integer, List<Integer>> entry : map.entrySet()){
                    Integer mapKey = entry.getKey();
                    List mapValue = entry.getValue();
                    boolean visit = visited.contains(mapKey);
                    if (mapValue.contains(p) && !visit){
                        visited.add(p);
                        newPivot.add(mapKey);
                        res.add(mapKey);
                        change = true;
                        haschanged = true;
                    }
                }

            }
            pivot = newPivot;
            newPivot = new ArrayList<>();
        }
        int result = 0;
        for (Integer i:res
             ) {
            result += i;
        }
        if (haschanged){
            System.out.println(result);
        }else{
            System.out.print(-1);
        }


    }
}
