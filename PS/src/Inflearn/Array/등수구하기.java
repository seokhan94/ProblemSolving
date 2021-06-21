package Inflearn.Array;

import java.util.*;

public class 등수구하기 {

    public static int[] solution(int[] input){
        int[] sortInput = Arrays.stream(input).toArray();
        Arrays.sort(sortInput);

        int[] answer = new int[input.length];

        int maxVal = sortInput[sortInput.length - 1];

        int rank = 1;
        int cnt = 0;

        for(int i = sortInput.length - 1; i>=0; i--){
            for(int j = 0; j < input.length; j++){
                if(answer[j] == 0 && input[j] == sortInput[i]){
                    if(maxVal != sortInput[i]){
                        maxVal = sortInput[i];
                        rank = rank + cnt;
                        cnt = 1;
                        answer[j] = rank;
                    }else{
                        cnt++;
                        answer[j] = rank;
                    }
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();
        int[] inputArr = new int[N];

        for(int i=0; i < N; i++)
            inputArr[i] = in.nextInt();

        for(int ans : solution(inputArr)) System.out.print(ans + " ");
    }
}
