package schoolRecruitWrittenTest.tx;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by 杜文丽 on 8/17/2019 8:02 PM
 **/
public class Problem1 {
    public static void main(String[] args) {
        Stack<String> stack=new Stack<String>();
        String s="";
        String res="";
        Scanner sc = new Scanner(System.in);
        s=sc.nextLine();
        for (int i = 0; i <s.length() ; i++) {
            if (s.charAt(i)!=']'){
                stack.add(String.valueOf(s.charAt(i)));
            }else{
                String tmp="";
                int num=0;
                while (!stack.peek().equals("|")){
                    tmp=stack.peek()+tmp;
                    stack.pop();
                }
                if (stack.peek().equals("|")){
                    stack.pop();//pop掉|
                    num= Integer.parseInt(stack.peek());//记录num
                    stack.pop();//pop掉num
                }
                if (stack.peek().equals("[")){
                    tmp=sub(num,tmp);
                    stack.pop();
                }
                //将tmp加入栈；
                stack.push(tmp);
            }
        }
        while (!stack.empty()){
            res=stack.peek()+res;
            stack.pop();
        }
        System.out.println(res);
    }
    public static String sub(int num,String s){
        String tmp=s;
        for (int i = 1; i <num ; i++) {
            s+=tmp;
        }
        return s;
    }
}
