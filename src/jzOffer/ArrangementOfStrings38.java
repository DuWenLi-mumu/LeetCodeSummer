package jzOffer;

import java.util.HashSet;
import java.util.Set;

public class ArrangementOfStrings38 {
    private Set<String> res = new HashSet<>();
    private boolean[] visited;
    public String[] permutation(String s) {
        visited = new boolean[s.length()];
        dfs(s,"");
        String[] result = new String[res.size()];
        int index = 0;
        for (String s1:res
             ) {
            result[index++] = s1;
        }
        return result;
    }
    public void dfs(String s,String curr){
        if (curr.length() >= s.length()){
            res.add(curr);
            return;
        }
        for (int i = 0; i < s.length() ; i++) {
            if (visited[i]){
                continue;
            }
            visited[i] = true;
            dfs(s,curr + s.charAt(i));
            visited[i] = false;
        }
    }
}
