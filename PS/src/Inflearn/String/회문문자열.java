package Inflearn.String;

import java.util.*;

public class 회문문자열 {
    public static String solution(String input){
        String answer = "YES";
        input = input.toLowerCase();

//        int left = -1, right = input.length();
//        while(left < right){
//            left++;
//            right--;
//            if(input.charAt(left) == input.charAt(right)) continue;
//            answer = "NO";
//            break;
//        }
        String tmp = new StringBuilder(input).reverse().toString();
        if(!tmp.equals(input)) answer = "NO";

        return answer;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String input = in.nextLine();

        System.out.println(solution(input));
    }
}
