package Inflearn.String;

import java.util.Scanner;

public class 문자찾기 {
    public static int Solution(String input1, String input2){

        int cnt = 0;
        String lowInput = input1.toLowerCase();
        char in2 = input2.toLowerCase().charAt(0);

//        for(int i = 0; i < lowInput.length(); i++)
//            if(lowInput.charAt(i) == in2) cnt++;

        for(char c : lowInput.toCharArray())
            if(c == in2) cnt++;


        return cnt;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String input1 = in.nextLine();
        String input2 = in.nextLine();

        System.out.println(Solution(input1, input2));
    }
}
