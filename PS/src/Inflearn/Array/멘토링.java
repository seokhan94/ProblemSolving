package Inflearn.Array;

import java.util.Scanner;

public class 멘토링 {
    public static int solution(int N, int M, int[][] inputRank){
        int answer = 0;

        for(int k = 0; k < N; k++){
            int cnt = 0;
            boolean[] checkRank = new boolean[N];
            checkRank[k] = true;

            // 매 시험
            for(int i = 0; i < M; i++){
                // i번째 시험 k의 등수
                int rank = inputRank[i][k];

                for(int j = 0; j < N; j++)
                    if(rank > inputRank[i][j])
                        checkRank[j] = true;
            }

            for(int i = 0; i < N; i++)
                if(!checkRank[i])
                    answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();
        int M = in.nextInt();

        int inputRank[][] = new int[M][N];

        for(int i = 0; i < M; i++)
            for(int j = 0; j < N; j++) {
                int k = in.nextInt();
                // i 번째 시험에서 k가 j등수를 함.
                inputRank[i][k - 1] = j;
            }

        System.out.println(solution(N, M, inputRank));
    }
}
