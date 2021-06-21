package Inflearn.Hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class 매출액의종류 {
    public static int[] solution(int[] input, int N, int K){
        int lt = 0, rt = lt + K - 1;

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < K; i++)
            map.put(input[i], map.getOrDefault(input[i], 0) + 1);

        List<Integer> list = new ArrayList<>();

        while(rt < N){
            list.add(map.size());

            map.put(input[lt], map.get(input[lt]) - 1);
            if(map.get(input[lt]) == 0) map.remove(input[lt]);

            lt++;
            rt++;

            if(rt >= N) break;

            map.put(input[rt], map.getOrDefault(input[rt], 0) + 1);
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();
        int K = in.nextInt();

        int[] inputArr = new int[N];

        for(int i = 0; i < N; i++)
            inputArr[i] = in.nextInt();

        int[] answer = solution(inputArr, N, K);

        for(int k : answer) System.out.print(k + " ");
    }
}
