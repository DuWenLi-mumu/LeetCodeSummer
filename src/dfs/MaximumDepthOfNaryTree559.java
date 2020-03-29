package dfs;

import util.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 杜文丽 on 3/29/2020 4:35 PM
 **/
public class MaximumDepthOfNaryTree559 {
    int dep=1;
    public int maxDepth(Node root) {
        if (root==null){
            return 0;
        }
        return sub(root.children);
    }
    public int sub(List<Node> root){
        if (root.isEmpty()){
            return dep;
        }
        dep++;
        List<Node> children=new ArrayList<>();
        for (Node kid: root
             ) {
            for (Node node:kid.children
                 ) {
                children.add(node);
            }
        }
        return sub(children);
    }
}
