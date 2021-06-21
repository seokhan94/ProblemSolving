package Inflearn.Array;

import java.util.*;

public class 보이는학생 {

    public static int solution(int[] inputArr){
        int answer = 0;

        int maxHeight = -1;

        for(int k : inputArr){
            if(maxHeight < k){
                maxHeight = k ;
                answer++;
            }
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
