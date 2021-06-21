package Inflearn.Chapter3;

import java.util.Map;
import java.util.Scanner;

public class 최대매출 {
    public static int solution(int[] inputArr, int K){
        int answer = 0;
        int sum = 0;

        for(int i = 0; i < K; i++) sum += inputArr[i];
        answer = sum;

        for(int i = K; i < inputArr.length; i++){
            sum += (inputArr[i] - inputArr[i - K]);
            answer = Math.max(answer, sum);
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();
        int K = in.nextInt();

        int[] inputArr = new int[N];

        for(int i = 0; i < N; i++) {
            inputArr[i] = in.nextInt();
        }

        System.out.println(solution(inputArr, K));
    }
}
