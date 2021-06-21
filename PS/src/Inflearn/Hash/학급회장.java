package Inflearn.Hash;

import java.util.HashMap;
import java.util.Scanner;

public class 학급회장 {
    public static char solution(String str){
        char answer = 'a';
        int maxCnt = 0;

        HashMap<Character, Integer> map = new HashMap<>();

//        for(char c : str.toCharArray()){
//            int k = map.getOrDefault(c, 0);
//            k++;
//            if(maxCnt < k){
//                maxCnt = k;
//                answer = c;
//            }
//            map.put(c, k);
//        }

        // System.out.println(map.containsKey('C'));
        // System.out.println(map.size());
        // System.out.println(map.remove('A')); -> A라는 key의 value값을 리턴
        for(char c : str.toCharArray())
            map.put(c, map.getOrDefault(c, 0) + 1);
        for(char c : map.keySet()){
            if(maxCnt < map.get(c))
            {
                maxCnt = map.get(c);
                answer = c;
            }
        }

        return answer;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();
        String str = in.next();

        System.out.println(solution(str));
    }
}
