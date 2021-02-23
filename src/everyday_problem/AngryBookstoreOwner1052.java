package everyday_problem;

public class AngryBookstoreOwner1052 {
    public static int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int otherSum = 0;
        int currSum = 0;
        int max = 0;
        int len = customers.length;
        if (len <= X){
            for (int i = 0; i < len; i++) {
                otherSum += customers[i];
            }
            return otherSum;
        }
        for (int i = 0; i < X; i++) {
            currSum += customers[i];
        }
        for (int i = X ; i < len; i++) {
            otherSum += ((grumpy[i] + 1) % 2) * customers[i];
        }
        max = currSum + otherSum;
        for (int ct = 1; ct<= len - X; ct++) {
            currSum = currSum - customers[ct - 1];
            currSum = currSum + customers[ct + X - 1];
            otherSum = otherSum + ((grumpy[ct - 1] + 1) % 2) * customers[ct - 1];
            otherSum = otherSum - ((grumpy[ct + X - 1] + 1) % 2) * customers[ct + X - 1];
            max = Math.max(max,otherSum + currSum);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] cus = {1,0,1,2,1,1,7,5};
        int[] gru = {0,1,0,1,0,1,0,1};
        maxSatisfied(cus,gru,2);
    }
}
