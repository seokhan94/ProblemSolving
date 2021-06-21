package Inflearn.String;

import java.util.*;

public class 문자열압축 {
    public static String solution(String input){
        String answer = "";

        char repeatCnt = '0';
        char prevChar = ' ';

        int totalLength = 0;

        for(int i = 0; i < input.length(); i++){
            if(prevChar == input.charAt(i))
                repeatCnt++;
            else{
                if(prevChar != ' ') {
                    answer += prevChar;
                    if(repeatCnt != '1')
                       answer += (char)repeatCnt;
                    totalLength += (repeatCnt - '0');
                }
                prevChar = input.charAt(i);
                repeatCnt = '1';
            }
        }

        if(totalLength != input.length()){
            answer += prevChar;
            if(repeatCnt != '1')
                answer += repeatCnt;
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String input = in.nextLine();

        System.out.println(solution(input));
    }
}
