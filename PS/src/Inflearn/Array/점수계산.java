package Inflearn.Array;

import java.util.*;

public class 점수계산 {

    public static int solution(int[] input){
        int answer = 0;

        int plusScore = 0;

        for(int i = 0; i < input.length; i++){
            if(input[i] == 0) plusScore = 0;
            else answer += (++plusScore);
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();
        int[] inputArr = new int[N];

        for(int i = 0; i < N; i++)
            inputArr[i] = in.nextInt();

        System.out.println(solution(inputArr));
    }
}
