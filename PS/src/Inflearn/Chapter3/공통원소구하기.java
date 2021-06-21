package Inflearn.Chapter3;

import java.util.*;

public class 공통원소구하기 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();

        int N = in.nextInt();
        int[] firstArr = new int[N];
        for(int i = 0; i < N; i++) {
            firstArr[i] = in.nextInt();
            int val = map.getOrDefault(firstArr[i], 0);

            if(val == 1)
                list.add(firstArr[i]);

            map.put(firstArr[i], val + 1);
        }

        int M = in.nextInt();
        int[] secondArr = new int[M];
        for(int i = 0; i < M; i++) {
            secondArr[i] = in.nextInt();
            int val = map.getOrDefault(secondArr[i], 0);

            if(val == 1)
                list.add(secondArr[i]);

            map.put(secondArr[i], val + 1);
        }

        list.sort(null);

        for(int i : list) System.out.print(i + " ");
    }
}
