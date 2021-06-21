package Inflearn.Chapter3;

import java.util.Scanner;

public class 연속부분수열 {
    public static int solution(int[] input, int M){
        int answer = 0;

        int lt = 0, rt = 0;
        long sum = 0;

        while(lt <= rt && rt < input.length){
            if(sum < M){
                sum += input[rt];
                rt++;
                if(sum == M) answer++;
            }else{
                sum -= input[lt];
                lt++;
                if(sum == M) answer++;
            }
        }

        return answer;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();
        int M = in.nextInt();

        int[] inputArr = new int[N];

        for(int i = 0; i < N; i++)
            inputArr[i] = in.nextInt();

        System.out.println(solution(inputArr, M));
    }
}
