package schoolRecruitWrittenTest.huawei;

import java.util.*;

/**
 * Created by 杜文丽 on 8/21/2019 6:56 PM
 **/
public class Problem3 {
    static Set<String> know_names=new HashSet<>();
    static ArrayList<List<String>> namelist=new ArrayList<>();
    public static boolean allupdate(boolean[] update){
        for (int i = 0; i <update.length ; i++) {
            if (update[i]==false){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String name=sc.nextLine();
        int group_num=sc.nextInt();
        know_names.add(name);
        String[] group_names=new String[group_num];
        sc.nextLine();
        for (int i = 0; i <group_num ; i++) {

            group_names[i]=sc.nextLine();
            List<String> res= Arrays.asList(group_names[i].split(","));
            namelist.add(res);
        }
        boolean isupdate=true;

        boolean[] update=new boolean[group_num];
        for (int i = 0; i <group_num ; i++) {
            update[i]=false;
        }
        while (!allupdate(update)){

            for (int i = 0; i <group_num ; i++) {
                update[i]=true;
                for (int j = 0; j <namelist.get(i).size() ; j++) {
                    if (know_names.contains(namelist.get(i).get(j))){
                        int beforesize=know_names.size();
                        for (int k = 0; k <namelist.get(i).size() ; k++) {
                            know_names.add(namelist.get(i).get(k));
                        }
                        int aftersize=know_names.size();
                        if (beforesize!=aftersize){
                            for (int k = 0; k <update.length ; k++) {
                                update[i]=false;
                            }
                        }
                        break;
                    }
                }
            }
        }
        System.out.println(know_names.size());
    }
}
