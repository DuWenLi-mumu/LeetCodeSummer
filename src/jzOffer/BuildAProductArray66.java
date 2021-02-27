package jzOffer;

public class BuildAProductArray66{
    public int[] constructArr(int[] a) {
        int[] res = new int[a.length];
        int n = 1;
        for (int i = 0; i < a.length; i++) {
            res[i] = n;
            n *= a[i];
        }
        n = 1;
        for (int i = a.length - 1; i >=0 ; i--) {
            res[i] *= n;
            n *= a[i];
        }
        return res;
    }
}
