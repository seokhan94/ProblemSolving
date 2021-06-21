package Inflearn.Array;

import java.util.*;

public class 피보나수열 {
    public static int[] solution(int N){
        int[] answer = new int[N];

        answer[0] = 1;
        answer[1] = 1;

        for(int i = 2; i < N; i++){
            answer[i] = answer[i - 1] + answer[i - 2];
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();

        int[] answer = solution(N);

        for(int ans : answer)
            System.out.print(ans + " ");
    }
}
