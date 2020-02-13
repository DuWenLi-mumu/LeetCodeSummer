package greedy;

/**
 * Created by 杜文丽 on 2/13/2020 10:32 PM
 * 这道题 脑壳有病嗖
 **/
public class DeleteColumnsToMakeSorted944 {
    public int minDeletionSize(String[] A) {
        if (A.length<=0){
            return 0;
        }
        int res=0;
        for (int j = 0; j <A[0].length() ; j++) {
            for (int i = 0; i <A.length-1 ; i++) {
                if (A[i].charAt(j)>A[i+1].charAt(j)){
                    res++;
                    break;
                }

            }

        }
        return res;
    }
}
