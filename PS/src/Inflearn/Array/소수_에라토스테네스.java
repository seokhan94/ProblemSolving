package Inflearn.Array;

import java.util.*;

public class 소수_에라토스테네스 {
    public static int solution(int N){
        int answer = 0;

        boolean[] isPrime = new boolean[N + 1];

        for(int i = 2; i <= N; i++){
            if(!isPrime[i]) {
                answer += 1;
                for (int j = i + i; j <= N; j = j + i) {
                    isPrime[j] = true;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();

        System.out.println(solution(N));
    }
}
