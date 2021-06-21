package Inflearn.Array;

import java.util.*;

public class 격자판최대합 {
    public static int solution(int[][] input){
        int answer = 0;

        int[][] inputTmp = new int[input.length + 1][input.length + 1];

        int rowMax = 0;
        int colMax = 0;
        int diagonalSum = 0;
        int reverseDiagonalSum = 0;

        for(int i = 0; i < input.length; i++)
            for(int j = 0; j < input.length; j++)
            {
                // 행 합
                inputTmp[i][input.length] += input[i][j];
                // 열 합
                inputTmp[input.length][j] += input[i][j];

                rowMax = Math.max(rowMax, inputTmp[i][input.length]);
                colMax = Math.max(colMax, inputTmp[input.length][j]);

                // 대각선
                if(i == j) diagonalSum += input[i][j];
                // 반대각선
                if(i + j == input.length - 1) reverseDiagonalSum += input[i][j];

                answer = Math.max(answer, Math.max(rowMax, Math.max(colMax, Math.max(diagonalSum, reverseDiagonalSum))));
            }

        return answer;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();

        int[][] inputArr = new int[N][N];

        for(int i = 0; i < N; i++)
            for(int j = 0; j < N; j++)
                inputArr[i][j] = in.nextInt();

        System.out.println(solution(inputArr));
    }
}
