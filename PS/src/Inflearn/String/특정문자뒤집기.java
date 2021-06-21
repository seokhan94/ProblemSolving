package Inflearn.String;

import java.util.*;

public class 특정문자뒤집기 {

    public static String solution(String input){
        String answer = "";

        char[] chars = input.toCharArray();

        int left = 0, right = chars.length - 1;

        while(left < right){
            if(!Character.isAlphabetic(chars[left])) left++;
            else if(!Character.isAlphabetic(chars[right])) right--;
            else {
                char tmp = chars[left];
                chars[left] = chars[right];
                chars[right] = tmp;
                left++;
                right--;
            }
        }
        answer = String.valueOf(chars);

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();

        System.out.println(solution(input));
    }
}
