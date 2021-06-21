package Inflearn.Chapter3;

import java.util.Scanner;

public class 연속된자연수의합 {
    public static int solution(int N){
        int answer = 0;

        int lt = 1, rt = 1;
        long sum = 0;

        while(lt <= rt && rt < N){
            if(sum < N){
                sum += rt;
                rt++;
                if(sum == N) answer++;
            }else{
                sum -= lt;
                lt ++;
                if(sum == N) answer++;
            }
        }

        return answer;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();

        System.out.print(solution(N));
    }
}
