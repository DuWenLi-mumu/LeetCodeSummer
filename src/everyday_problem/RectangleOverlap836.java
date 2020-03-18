package everyday_problem;

/**
 * Created by 杜文丽 on 3/18/2020 7:41 PM
 **/
public class RectangleOverlap836 {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        //将面积转化为 线段 牛逼！
        return !(rec1[2] <= rec2[0] || rec2[2] <= rec1[0] || rec1[3] <= rec2[1] || rec2[3] <= rec1[1]);
    }

    public static void main(String[] args) {

    }
}
