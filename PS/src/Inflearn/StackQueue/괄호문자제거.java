package Inflearn.StackQueue;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class 괄호문자제거 {
    public static String solution(String str){
        String answer = "";

        Stack<Character> stack = new Stack<>();

        for(char c : str.toCharArray()){
            if(c != ')'){
                stack.push(c);
            }else{
                while(!stack.isEmpty()){
                    char a = stack.pop();
                    if(a == '(') break;
                }
            }
        }

//        while(!stack.isEmpty())
//            answer += stack.pop();
//        answer = new StringBuilder(answer).reverse().toString();

        for(int i = 0; i < stack.size(); i++)
            answer += stack.get(i);

        return answer;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String str = in.nextLine();

        System.out.println(solution(str));
    }
}
