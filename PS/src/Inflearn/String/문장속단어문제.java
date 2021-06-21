package Inflearn.String;

import java.util.*;

public class 문장속단어문제 {

    public static String solution(String input){
        String answer = "";
        int max_cnt = -1;

//        String str = input + " ";
//
//        while(str.indexOf(" ") != -1){
//            int length = str.indexOf(" ");
//
//            if(max_cnt < length){
//                max_cnt = length;
//                answer = str.substring(0, length);
//            }
//
//            str = str.substring(length + 1, str.length());
//        }

        String[] s = input.split(" ");

        for(String x : s){
            if(max_cnt < x.length()){
                max_cnt = x.length();
                answer = x;
            }
        }


        return answer;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String input = in.nextLine();

        System.out.println(solution(input));
    }
}
