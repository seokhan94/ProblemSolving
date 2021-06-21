package Inflearn.Chapter3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class 두배열합치기 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();
        int[] firstArr = new int[N];
        for(int i = 0; i < N; i++) {
            firstArr[i] = in.nextInt();
        }
        int M = in.nextInt();
        int[] secondArr = new int[M];
        for(int i = 0; i < M; i++) {
            secondArr[i] = in.nextInt();
        }

        int[] answer = new int[N+M];

        int p1 = 0, p2 = 0;
        int cnt = 0;
        while(p1 < N && p2 < M){
            if(p1 == N) answer[cnt++] = secondArr[p2++];
            else if(p2 == N) answer[cnt++] = firstArr[p1++];
            else if(firstArr[p1] < secondArr[p2])
                answer[cnt++] = firstArr[p1++];
            else
                answer[cnt++] = secondArr[p2++];
        }

        for(int i : answer) System.out.print(i + " ");
    }
}
