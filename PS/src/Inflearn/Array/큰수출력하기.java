package Inflearn.Array;

import java.util.*;

public class 큰수출력하기 {
    public static int[] solution(int[] input){
        List<Integer> list = new ArrayList<>();

        int prev = -1;
        for(int i = 0; i < input.length; i++){
            if(prev < input[i])
                list.add(input[i]);
            prev = input[i];
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();
        int[] input = new int[N];

        for(int i = 0 ; i < N; i++)
            input[i] = in.nextInt();

        input = solution(input);

        for(int k : input)
            System.out.print(k + " ");
    }
}
