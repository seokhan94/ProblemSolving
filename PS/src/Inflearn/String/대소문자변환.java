package Inflearn.String;

import java.util.*;

public class 대소문자변환 {

    public static String solution(String input){
        String answer = "";

        for(char c : input.toCharArray()){
            if(Character.isUpperCase(c))
                answer += Character.toLowerCase(c);
            else
                answer += Character.toUpperCase(c);
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String input1 = in.nextLine();

        System.out.println(solution(input1));
    }
}
