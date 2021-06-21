package Inflearn.String;

import java.util.*;

public class 유요한팰린드롬 {

    public static String solution(String input){
        String answer = "YES";

        input = input.toLowerCase().replaceAll("[^a-z]", "");

       String tmp = new StringBuilder(input).reverse().toString();

       if(!input.equals(tmp)) answer = "NO";

        return answer;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String input = in.nextLine();

        System.out.println(solution(input));

    }
}
