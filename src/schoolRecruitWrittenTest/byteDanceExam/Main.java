package schoolRecruitWrittenTest.byteDanceExam;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        while(n > 0){
            n--;
            int num = in.nextInt();
            List<Need> needs = new ArrayList();
            for(int i = 0; i < num; i++){
                int day = in.nextInt();
                int cost = in.nextInt();
                needs.add(new Need(i + 1,cost,day));
            }
            while(needs.size() >= 1){
                if(needs.size() <= 1){
                    System.out.println(needs.get(0).id);
                    needs.remove(0);
                    break;
                }
                int remove_index = 0;
                Need curr = needs.get(0);
                for(int j = 1; j < needs.size(); j++){
                    if(curr.day * needs.get(j).cost > curr.cost * needs.get(j).day){
                        curr = needs.get(j);
                        remove_index = j;
                    }else if(curr.day * needs.get(j).cost == curr.cost * needs.get(j).day){
                        if(curr.cost < needs.get(j).cost){
                            curr = needs.get(j);
                            remove_index = j;
                        }
                    }
                }
                System.out.print(curr.id + " ");
                needs.remove(remove_index);
            }

        }
    }
    static class Need{
        public int id;
        public int cost;
        public int day;
        public Need(int id,int cost,int day){
            this.id = id;
            this.cost = cost;
            this.day = day;
        }
    }
}