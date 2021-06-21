package Inflearn.Chapter3;

import java.util.Scanner;

public class 최대길연속부분수열 {
    public static int solution(int[] input, int K){
        int answer = 0;

        int lt = 0, rt = 0;
        int changCnt = 0;

        while(lt <= rt && rt < input.length){
            if(input[rt] == 1) {
                answer = Math.max(answer, rt - lt + 1);
                rt ++;
            }else{
                changCnt++;
                if(changCnt > K) {
                    while (input[lt] != 0) lt++;
                    lt++;
                    changCnt--;
                }
                rt++;
                answer = Math.max(answer, rt - lt + 1);
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();
        int K = in.nextInt();

        int[] inputArr = new int[N];

        for(int i = 0; i < N; i++)
            inputArr[i] = in.nextInt();

        System.out.println(solution(inputArr, K));
    }
}
