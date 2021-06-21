package Inflearn.Hash;

import java.util.HashMap;
import java.util.Scanner;

public class 모든아나그램찾기 {
    public static int solution(String str1, String str2){
        int answer = 0;

        int K = str2.length();
        int lt = 0, rt = 0;

        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();

        for(char c : str2.toCharArray()) map1.put(c, map1.getOrDefault(c, 0) + 1);

        while(lt <= rt && rt <= str1.length()){
            if(rt - lt < K) {
                map2.put(str1.charAt(rt), map2.getOrDefault(str1.charAt(rt), 0) + 1);
                rt++;
                continue;
            }

//            boolean flag = true;
//
//            for(char c : map1.keySet()){
//                if(map1.get(c) != map2.getOrDefault(c, 0)){
//                    flag = false;
//                    break;
//                }
//            }
//
//            if(flag) answer++;

            if(map1.equals(map2)) answer++;

            if(rt >= str1.length()) break;

            map2.put(str1.charAt(lt), map2.get(str1.charAt(lt)) - 1);
            if(map2.get(str1.charAt(lt)) == 0) map2.remove(str1.charAt(lt));
            map2.put(str1.charAt(rt), map2.getOrDefault(str1.charAt(rt), 0) + 1);

            lt++;
            rt++;
        }

        return answer;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String str1 = in.nextLine();
        String str2 = in.nextLine();

        System.out.println(solution(str1,str2));
    }
}
