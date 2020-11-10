package jzOffer;

/**
 * Created by 杜文丽 on 11/6/2020 11:41 PM
 **/
public class RotateTheMinimumNumberOfTheArray11 {
    public int minArray(int[] numbers) {
        if(numbers.length < 1){
            return -1;
        }
        int num = numbers[0];
        for (int i = 0; i < numbers.length-1; i++) {
            if (numbers[i] > numbers[i+1]){
                return numbers[i+1];
            }
        }
        return numbers[0];
    }
}
