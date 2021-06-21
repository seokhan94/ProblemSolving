package Inflearn.String;

import java.util.*;

public class 가장짧은문자거리 {
    public static int[] solution(String str, char c){
        int[] dist = new int[str.length()];

//        for(int i = 0; i < str.length(); i++){
//            if(str.charAt(i) == c) continue;
//
//            String leftStr = new StringBuilder(str.substring(0, i)).reverse().toString();
//            String rightStr = str.substring(i + 1);
//
//            int leftDist = (leftStr.indexOf(c) != -1) ? leftStr.indexOf(c) + 1: 9999;
//            int rightDist = (rightStr.indexOf(c) != -1) ? rightStr.indexOf(c) + 1: 9999;
//
//            dist[i] = Math.min(leftDist, rightDist);
//        }

        int p = 1000;
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == c){
                p = 0;
                dist[i] = p;
            }else{
                p++;
                dist[i] = p;
            }
        }

        p = 1000;
        for(int i = str.length() - 1; i >=0; i--){
            if(str.charAt(i) == c){
                p = 0;
                dist[i] = p;
            }else{
                p ++;
                dist[i] = Math.min(dist[i], p);
            }
        }

        return dist;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String inputStr = in.next();
        char inputChar = in.next().charAt(0);

        int[] answer = solution(inputStr, inputChar);

        for(int i = 0; i < answer.length; i++)
            System.out.print(answer[i] + " ");
    }
}
