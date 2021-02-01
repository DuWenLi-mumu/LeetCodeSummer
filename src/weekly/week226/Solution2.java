package weekly.week226;

import java.util.*;

/**
 * Created by 杜文丽 on 1/31/2021 10:19 AM
 **/
public class Solution2 {
    List<Integer> res = new ArrayList<>();
    Queue<Integer> queue = new LinkedList<>();
    public int[] restoreArray(int[][] adjacentPairs) {
        if (adjacentPairs.length <= 0){
            return new int[0];
        }else if (adjacentPairs.length <= 1){
            return adjacentPairs[0];
        }
        Map<Integer,Integer> map = new HashMap<>();//做一个统计
        for (int i = 0; i < adjacentPairs.length ; i++) {
            if (map.isEmpty()){
                map.put(adjacentPairs[i][0],1);
                map.put(adjacentPairs[i][1],1);
            }else {
                if (map.containsKey(adjacentPairs[i][0])){
                    map.put(adjacentPairs[i][0],map.get(adjacentPairs[i][0]) + 1);
                }else {
                    map.put(adjacentPairs[i][0],1);
                }
                if (map.containsKey(adjacentPairs[i][1])){
                    map.put(adjacentPairs[i][1],map.get(adjacentPairs[i][1]) + 1);
                }else {
                    map.put(adjacentPairs[i][1],1);
                }
            }
        }
        //找到表头
        int root = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 2){
                root = entry.getKey();
                break;
            }
        }
        queue.add(root);
        dfs(adjacentPairs);
        int[] result = new int[res.size()];
        for (int i = 0; i < res.size() ; i++) {
            result[i] = res.get(i);
        }
        return result;

    }
    public void dfs(int[][] adjacentPairs){
        while (!queue.isEmpty()){
            int v = queue.poll();
            if (res.isEmpty()){
                res.add(v);
            }else {
                //判断是在头加还是尾加
                for (int i = 0; i < adjacentPairs.length ; i++) {
                    if (v == adjacentPairs[i][0] && adjacentPairs[i][1] == res.get(res.size() - 1)){
                        res.add(v);
                        break;
                    }else if (v == adjacentPairs[i][0] && adjacentPairs[i][1] == res.get(0)){
                        res.add(0,v);
                        break;
                    }else if (v == adjacentPairs[i][1] && adjacentPairs[i][0] == res.get(res.size() - 1)){
                        res.add(v);
                        break;
                    }else if (v == adjacentPairs[i][1] && adjacentPairs[i][0] == res.get(0)){
                        res.add(0,v);
                        break;
                    }
                }
            }

            for (int i = 0; i < adjacentPairs.length ; i++) {
                if (adjacentPairs[i][0] == v && !res.contains(adjacentPairs[i][1])){
                    queue.add(adjacentPairs[i][1]);
                }else if (adjacentPairs[i][1] == v && !res.contains(adjacentPairs[i][0])){
                    queue.add(adjacentPairs[i][0]);
                }
            }
        }

    }
}
class Solution2_2{
    /*
     * 找到一个入度和出度都为1的边 从改点开始dfs遍历完构建出一个数组
     * @param adjacentPairs
     * @return
     */
    int[] res;
    boolean[] used;
    int index = 0;
    public int[] restoreArray(int[][] adjacentPairs) {
        if (adjacentPairs.length <= 0){
            return new int[0];
        }else if (adjacentPairs.length <= 1){
            return adjacentPairs[0];
        }
        Map<Integer,Integer> map = new HashMap<>();//做一个统计
        for (int i = 0; i < adjacentPairs.length ; i++) {
            if (map.isEmpty()){
                map.put(adjacentPairs[i][0],1);
                map.put(adjacentPairs[i][1],1);
            }else {
                if (map.containsKey(adjacentPairs[i][0])){
                    map.put(adjacentPairs[i][0],map.get(adjacentPairs[i][0]) + 1);
                }else {
                    map.put(adjacentPairs[i][0],1);
                }
                if (map.containsKey(adjacentPairs[i][1])){
                    map.put(adjacentPairs[i][1],map.get(adjacentPairs[i][1]) + 1);
                }else {
                    map.put(adjacentPairs[i][1],1);
                }
            }
        }
        //找到表头
        int root = 0;
        res = new int[map.size()];
        used = new boolean[map.size()];

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1){
                root = entry.getKey();
                break;
            }
        }
        res[index++] = root;
        while (index < map.size()){
            dfs(res[index - 1],adjacentPairs);
        }
        return res;
    }
    public void dfs(int val,int[][] adjacentPairs){
        for (int i = 0; i < adjacentPairs.length; i++) {
            if (adjacentPairs[i][0] == val && !used[i]){
                res[index++] = adjacentPairs[i][1];
                used[i] = true;
                return;
            }else if (adjacentPairs[i][1] == val && !used[i]){
                res[index++] = adjacentPairs[i][0];
                used[i] = true;
                return;
            }
        }
    }
}

class Solution2_3{
    /**
     * 构建图
     * @param adjacentPairs
     * @return
     */
    Map<Integer,List<Integer>> graph = new HashMap<>();
    Map<Integer,Integer> in = new HashMap<>();
    Map<Integer,Integer> out = new HashMap<>();
    Map<Integer,Boolean> visited = new HashMap<>();
    int[] res;
    int index = 0;
    public int[] restoreArray(int[][] adjacentPairs){
        for (int i = 0; i < adjacentPairs.length; i++) {
            int n1 = adjacentPairs[i][0];
            int n2 = adjacentPairs[i][1];
            //更新入度
            if (in.containsKey(n1)){
                in.put(n1,in.get(n1) + 1);
            }else {
                in.put(n1,1);
            }
            if (in.containsKey(n2)){
                in.put(n2,in.get(n2) + 1);
            }else {
                in.put(n2,1);
            }
            //更新出度
            if (out.containsKey(n1)){
                out.put(n1,out.get(n1) + 1);
            }else {
                out.put(n1,1);
            }
            if (out.containsKey(n2)){
                out.put(n2,out.get(n2) + 1);
            }else {
                out.put(n2,1);
            }
            //构建图
            if (graph.containsKey(n1)){
                graph.get(n1).add(n2);
            }else {
                List<Integer> list = new ArrayList<>();
                list.add(n2);
                graph.put(n1,list);
            }
            if (graph.containsKey(n2)){
                graph.get(n2).add(n1);
            }else {
                List<Integer> list = new ArrayList<>();
                list.add(n1);
                graph.put(n2,list);
            }
        }
        res = new int[in.size()];
        for (Integer integer:in.keySet()
             ) {
            if (in.get(integer) == 1 && out.get(integer) == 1){
                dfs(integer);
                break;
            }
        }
        return res;
    }
    public void dfs(int val){
        visited.put(val,true);
        res[index++] = val;
        List<Integer> list = graph.get(val);
        for (Integer i:list
             ) {
            if (!visited.containsKey(i)){
                dfs(i);
            }
        }
    }

}
