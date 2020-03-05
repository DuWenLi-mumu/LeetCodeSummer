package everyday_problem;

/**
 * Created by 杜文丽 on 3/5/2020 3:24 PM
 **/
public class DistributeCandiestoPeople1103 {
    public int[] distributeCandies(int candies, int num_people) {
        int[] res=new int[num_people];
        if (candies==0||num_people==0){
            return res;
        }
        int curr=1;
        int index=0;
        while (candies!=0){
            if (candies>=curr){
                res[index]+=curr;
                candies-=curr;
                curr++;
                index=(index+1)%num_people;
            }else {
                res[index]+=candies;
                candies=0;
                break;
            }
        }
        return res;
    }
}
