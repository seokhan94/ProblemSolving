package Inflearn.Array;

import java.util.*;

public class 임시반장정하기 {
    public static int solution(int[][] input){
        int answer = 0;
        int maxCnt = 0;

        for(int i = 0 ; i < input.length; i++){
            int cnt = 0;
            for(int j = 0; j < input.length; j++){
                for(int k = 0; k < 5; k++){
                    if(input[i][k] == input[j][k]) {
                        cnt ++;
                        break;
                    }
                }
            }
            if(maxCnt < cnt){
                maxCnt = cnt;
                answer = i + 1;
            }
        }

        return answer;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();

        int[][] inputArr = new int[N][5];

        for(int i = 0; i < N; i++)
            for(int j = 0; j < 5; j++)
                inputArr[i][j] = in.nextInt();


        System.out.println(solution(inputArr));
    }
}
