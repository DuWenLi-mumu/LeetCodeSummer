package jzOffer;

import java.util.ArrayList;
import java.util.List;

public class MedianInTheDataStream41 {
    private List<Integer> myList;
    /** initialize your data structure here. */
    public void MedianFinder() {
        myList = new ArrayList<>();
    }

    public void addNum(int num) {

        int index = myList.size() - 1;
        myList.add(num);
        while (index >= 0 && myList.get(index) >= num){
            myList.set(index + 1,myList.get(index));
            index--;
        }
        if (index < 0){
            myList.set(0,num);
        }else {
            myList.set(index + 1,num);
        }
    }

    public double findMedian() {
        if(myList.size() <= 0){
            return 0;
        }else if(myList.size() <= 1){
            return myList.get(0);
        }
        if (myList.size() % 2 == 0){
            return 1.0 * (myList.get(myList.size() / 2) + myList.get(myList.size() / 2 - 1)) / 2;
        }else {
            return myList.get(myList.size() / 2);
        }
    }
}
