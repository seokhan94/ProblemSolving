package Inflearn.StackQueue;

import java.util.Scanner;
import java.util.Stack;

public class 크레인인형뽑기 {
    public static int solution(int[][] inputArr, int[] orderArr){
        int answer = 0;

        Stack<Integer> stack = new Stack<>();

        for(int index : orderArr){
            int row = 0;

            while(row < inputArr.length && inputArr[row][index] == 0) row++;

            if(row == inputArr.length) continue;

            if(stack.isEmpty()){
                stack.push(inputArr[row][index]);
                inputArr[row][index] = 0;
                continue;
            }else{
                int k = stack.peek();
                if(k == inputArr[row][index]) {
                    answer++;
                    stack.pop();
                }else{
                    stack.push(inputArr[row][index]);
                }

                inputArr[row][index] = 0;
            }
        }

        return answer * 2;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();

        int[][] inputArr = new int[N][N];

        for(int i = 0; i < N; i++)
            for(int j = 0; j < N; j++)
                inputArr[i][j] = in.nextInt();

        int M = in.nextInt();

        int[] orderArr = new int[M];

        for(int i = 0; i < M; i++)
            orderArr[i] = in.nextInt() - 1;

        System.out.println(solution(inputArr, orderArr));
    }
}
