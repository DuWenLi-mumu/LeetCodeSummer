package stack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * Created by 杜文丽 on 2019/11/29 12:42
 **/
public class BasicCalculator224 {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        int sign = 1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                int curr = c - '0';
                while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1)))
                    curr = curr * 10 + (s.charAt(++i) - '0');
                res += sign * curr;
            } else if (c == '+') {
                sign = 1;
            } else if (c == '-'){
                sign = -1;
            } else if (c == '('){
                stack.push(res);
                stack.push(sign);
                sign = 1;
                res = 0;
            } else if (c == ')'){
                res = res * (stack.pop()) + stack.pop();
            }
        }
        return res;
    }
}
/**
 * private Stack<Character> stack = new Stack<>();
 * private Stack<Character> solveStr = new Stack<>();
 * <p>
 * public void cal() {
 * //只要一进入这个函数，则表明一定有一个子式是需要计算的
 * List<Character> mystack = new ArrayList<>();
 * //取出需要计算的所有式子 然后从左往右计算
 * while (!stack.empty()&&stack.peek() != '(' && stack.peek() != ' ') {
 * mystack.add(stack.peek());
 * stack.pop();
 * }
 * stack.pop();//去除'('或者' '
 * <p>
 * //进行翻转处理
 * Collections.reverse(mystack);
 * int res = 0;
 * String num1 = "";
 * String num2 = "";
 * char op='#';
 * //开始顺序计算
 * <p>
 * int index = 0;
 * if (mystack.get(index)=='-'){
 * index++;
 * while (index<mystack.size()&& mystack.get(index)>='0' && mystack.get(index) <= '9') {
 * num1 = num1+mystack.get(index);
 * index++;
 * }
 * <p>
 * num1='-'+num1;
 * }else{
 * while (index<mystack.size()&& mystack.get(index)>='0' && mystack.get(index) <= '9') {
 * num1 = num1+mystack.get(index) ;
 * index++;
 * }
 * <p>
 * }
 * <p>
 * <p>
 * boolean positiveNum2=true;
 * boolean positiveNum1=true;
 * while (index<mystack.size()){
 * if (mystack.get(index)=='+'||mystack.get(index)=='-'){
 * op=mystack.get(index);
 * index++;
 * }
 * if (mystack.get(index)=='-'){
 * positiveNum2=false;
 * index++;
 * }else {
 * positiveNum2=true;
 * }
 * while (index<mystack.size()&&mystack.get(index) >='0'&& mystack.get(index) <='9') {
 * num2 = num2+mystack.get(index);
 * index++;
 * }
 * if (op=='#'){
 * //不知道会不会出这个异常
 * System.out.println("error");
 * }else if (op=='+'){
 * res=Integer.valueOf(num1)+Integer.valueOf(num2)*(positiveNum2?1:-1);
 * num2="";
 * }else if (op=='-'){
 * res=Integer.valueOf(num1)-Integer.valueOf(num2)*(positiveNum2?1:-1);
 * num2="";
 * }
 * <p>
 * num1=String.valueOf(res);
 * }
 * if (op=='#'){
 * //只有一个数字，没有运算
 * for (int i = 0; i <num1.length() ; i++) {
 * stack.push(num1.charAt(i));
 * }
 * }else {
 * stackPush(res);
 * }
 * <p>
 * }
 * <p>
 * public void stackPush(int num) {
 * List<Integer> nums = new ArrayList<>();
 * boolean positive=true;
 * if (num==0){
 * stack.push('0');
 * return;
 * }
 * if (num<0){
 * positive=false;
 * num=-1*num;
 * }
 * while (num != 0) {
 * int curr = num % 10;
 * nums.add(curr);
 * num /= 10;
 * }
 * if (!positive){
 * stack.push('-');
 * }
 * for (int i = nums.size()-1; i >=0; i--) {
 * stack.push(Character.forDigit(nums.get(i), 10));
 * }
 * }
 * <p>
 * public void solveString(String s) {
 * <p>
 * solveStr.push('(');
 * for (int i = 0; i < s.length(); i++) {
 * if (s.charAt(i) == ' ') {
 * continue;
 * } else {
 * solveStr.push(s.charAt(i));
 * }
 * }
 * solveStr.push(')');
 * }
 * <p>
 * //全是数字 运算符号 括号
 * public void compute() {
 * //处理成str形式
 * String s = "";
 * while (!solveStr.empty()) {
 * s = solveStr.peek() + s;
 * solveStr.pop();
 * }
 * for (int i = 0; i < s.length(); i++) {
 * if (s.charAt(i) == '(') {
 * stack.add('(');
 * } else if (s.charAt(i) == ')') {
 * cal();
 * } else if (s.charAt(i) <= '9' && s.charAt(i) >= '0') {
 * stack.add(s.charAt(i));
 * } else if (s.charAt(i) == '+') {
 * stack.add(s.charAt(i));
 * } else if (s.charAt(i) == '-') {
 * stack.add(s.charAt(i));
 * }
 * }
 * }
 * <p>
 * public int calculate(String s) {
 * solveString(s);
 * compute();
 * String res = "";
 * while (!stack.empty()) {
 * res = stack.peek() + res;
 * stack.pop();
 * }
 * return Integer.valueOf(res);
 * }
 * <p>
 * public static void main(String[] args) {
 * //System.out.println(Integer.valueOf("-34")+6);
 * BasicCalculator224 test = new BasicCalculator224();
 * System.out.println(test.calculate("(-102)")); //（1+11-3）+14  9+14
 * }
 */

