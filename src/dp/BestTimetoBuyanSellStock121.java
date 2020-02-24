package dp;

/**
 * Created by 杜文丽 on 2/24/2020 12:15 AM
 * 只能买一次的场景
 *
 **/
public class BestTimetoBuyanSellStock121 {
    public int maxProfit(int[] prices) {
        if (prices.length<=1){
            return 0;
        }
        int res=0;
        int min=0;
        int max=min+1;
        while (min<prices.length&&max<prices.length){
            if (prices[min]<prices[max]){
                res=Math.max(res,prices[max]-prices[min]);
                max++;
            }else {
                //出现min大于等于max的情况
                min=max;
                max++;
            }
        }
        return res;
    }
}
