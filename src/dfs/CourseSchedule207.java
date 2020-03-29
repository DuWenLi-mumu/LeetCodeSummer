package dfs;


import java.util.ArrayList;

/**
 * Created by 杜文丽 on 8/6/2019 6:37 PM
 **/
public class CourseSchedule207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList[] n= new ArrayList[numCourses];
        for (int i = 0; i <numCourses ; i++) {
            n[i]=new ArrayList();
        }
        int[] flag = new int[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            n[prerequisites[i][1]].add(prerequisites[i][0]);
        }
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(n, i, flag))
                return false;
        }
        return true;
    }
    public boolean dfs(ArrayList[] n, int i, int[] flag) {

        if (flag[i] == -1) {
            return false;
        } else if (flag[i] == 1) {
            return true;
        }
        flag[i] = -1;
        for (int j = 0; j <n[i].size() ; j++) {
            if (!dfs(n, (Integer) n[i].get(j), flag)) {
                return false;
            }
        }

        flag[i] = 1;
        return true;
    }
}

