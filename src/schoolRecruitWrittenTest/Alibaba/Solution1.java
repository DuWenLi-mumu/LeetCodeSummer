package schoolRecruitWrittenTest.Alibaba;

public class Solution1 {
    public static void main(String[] args) {
        int[] num = {0,0,0,0,0,0,0};
        int left = 0;
        int right = 0;
        int max = 0;
        int curr = 0;
        int zero = 0;
        boolean is_zero = false;
        while (right < num.length && left < num.length && right >= left) {
            while (right < num.length && (num[right] == 1 || zero < 1)) {
                if (num[right] == 0) {
                    zero++;
                    is_zero = true;
                }
                curr++;
                right++;
            }
            max = Math.max(max, curr);
            //移动左边
            zero = 0;
            while (left <= right && num[left] == 1 && right < num.length) {
                left++;
                curr--;
            }
            if (num[left] == 0) {
                left++;
                is_zero = true;
                curr--;
            }
        }
        if (is_zero){
            System.out.println(max - 1);
        }else {
            System.out.println(max);
        }

    }
}
