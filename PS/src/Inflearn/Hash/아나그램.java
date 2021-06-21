package Inflearn.Hash;

import java.util.HashMap;
import java.util.Scanner;

public class 아나그램 {
    public static String solution(String str1, String str2){
        String answer = "YES";

        HashMap<Character, Integer> map1 = new HashMap<>();

        for(char c : str1.toCharArray()) map1.put(c, map1.getOrDefault(c, 0) + 1);
        for(char c : str2.toCharArray()) {
            if(!map1.containsKey(c) || map1.get(c) == 0) return "NO";
            map1.put(c, map1.getOrDefault(c, 0) - 1);
        }

//        for(int k : map1.values()){
//            if(k != 0)
//                return "NO";
//        }

        return answer;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String str1 = in.nextLine();
        String str2 = in.nextLine();

        System.out.println(solution(str1, str2));
    }
}
