import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by 杜文丽 on 12/4/2020 11:11 AM
 **/
public class Test {
    public static void main(String[] args) {
        Map<Integer,Integer> map = new LinkedHashMap<>();
        Set<Integer> set = new HashSet<>();
        map.put(1,1);
        map.put(3,3);
        map.put(2,2);
        map.put(10,10);
        map.put(7,7);
        System.out.println(map.toString());
    }
}
