package Inflearn.Array;

import java.util.Scanner;

public class 봉우리 {

    public static int solution(int N, int[][] input){
        int answer = 0;

        for(int i = 1; i <= N; i++)
            for(int j = 1; j <=N; j++)
            {
                int k = input[i][j] ;

                if(input[i-1][j] < k && input[i+1][j] < k && input[i][j-1] < k && input[i][j+1] < k)
                    answer++;
            }

        return answer;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();

        int[][] inputArr = new int[N + 2][N + 2];

        for(int i = 1; i <= N; i++)
            for(int j = 1; j <= N; j++)
                inputArr[i][j] = in.nextInt();
        System.out.println(solution(N, inputArr));
    }
}
