package Inflearn.String;

import java.util.*;

public class 암호 {

    public static String solution(int n, String inputStr){
        String answer = "";

        for(int i = 0; i < n; i++){
            String tmp = inputStr.substring(i * 7, i * 7 + 7);

            tmp = tmp.replace("#", "1").replace("*", "0");
            int val = Integer.parseInt(tmp, 2);
            answer += String.valueOf((char)val);
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        String inputStr = in.next();

        System.out.println(solution(n, inputStr));
    }
}
