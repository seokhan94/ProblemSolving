package Inflearn.String;

import java.util.*;

public class 숫자만출력 {

    public static int solution(String input){
        int answer = 0;

        input = input.toLowerCase().replaceAll("[a-z]", "");

        answer = Integer.parseInt(input);

        return answer;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String input = in.nextLine();

        System.out.println(solution(input));
    }
}
