package Inflearn.StackQueue;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 공주구하기 {
    public static int solution(int N, int K){
        int answer = 0;

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1; i <= N; i++) queue.add(i);

        int cnt = 0;
        while(queue.size() != 1){
            int k = queue.poll();

            cnt = (cnt + 1) % K;

            if(cnt == 0) continue;

            queue.add(k);
        }

        answer = queue.poll();
        return answer;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();
        int K = in.nextInt();

        System.out.println(solution(N, K));
    }
}
