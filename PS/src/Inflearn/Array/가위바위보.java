package Inflearn.Array;

import java.util.*;

public class 가위바위보 {
    public static char[] solution(int[][] info){
        char[] answer = new char[info[0].length];

        for(int i = 0; i < info[0].length; i++){
            int val = info[0][i] - info[1][i];

            if(val == 0) answer[i] = 'D';
            else if(val == 1 || val == -2) answer[i] = 'A';
            else answer[i] = 'B';
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();

        int[][] Info = new int[2][N];

        for(int i = 0; i < 2; i++)
            for(int j = 0; j < N; j++)
                Info[i][j] = in.nextInt();

        char[] answer = solution(Info);

        for(char c : answer) System.out.println(c);
    }
}
