package Inflearn.StackQueue;

import java.util.Scanner;
import java.util.Stack;

public class 후위식연산 {
    public static int solution(String str){
        int answer = 0;

        Stack<Integer> stack = new Stack<>();

        for(char c : str.toCharArray()){
            if(c >= '0' && c <= '9'){
                stack.push(Integer.parseInt(String.valueOf(c)));
            }else{
                int v2 = stack.pop();
                int v1 = stack.pop();

                if(c == '+') stack.push(v1 + v2);
                else if(c == '-') stack.push(v1 - v2);
                else if(c == '*') stack.push(v1 * v2);
                else if(c == '/') stack.push(v1 / v2);
            }
        }

        answer = stack.pop();

        return answer;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String str = in.nextLine();

        System.out.println(solution(str));
    }
}
