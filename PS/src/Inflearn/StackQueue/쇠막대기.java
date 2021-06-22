package Inflearn.StackQueue;

import java.util.Scanner;
import java.util.Stack;

public class 쇠막대기 {
    public static int solution(String str){
        int answer = 0;

        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == '(') stack.push(str.charAt(i));
            else{
                stack.pop();
                if(i != 0 && str.charAt(i - 1) == '('){ // 레이저 발사
                    answer += stack.size();
                }else{ // 막대 갯수 추가.
                    answer ++;
                }
            }
        }

        return answer;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String str = in.nextLine();

        System.out.println(solution(str));
    }
}
