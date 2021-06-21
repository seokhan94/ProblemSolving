package Inflearn.String;

import java.util.*;

public class 중복문자제거 {

    public static String solution(String input){
        String answer = "";

//        boolean[] alpha = new boolean[26];
//
//        for(char c : input.toCharArray()){
//            if(alpha[c - 'a']) continue;
//
//            alpha[c - 'a'] = true;
//            answer += c;
//        }

        for(int i = 0 ; i < input.length(); i++){
            if(input.indexOf(input.charAt(i)) == i) answer += input.charAt(i);
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String input = in.nextLine();

        System.out.println(solution(input));
    }
}
