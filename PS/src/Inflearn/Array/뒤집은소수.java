package Inflearn.Array;

import java.util.*;

public class 뒤집은소수 {

    public static int[] isPrimeCheck(){
        int[] isPrime = new int[100000];
        isPrime[1] = 1;

        for(int i = 2; i < 100000; i++){
            if(isPrime[i] == 0){
                for(int j = i + i; j < 100000; j = j + i)
                    isPrime[j] = 1;
            }
        }

        return isPrime;
    }

    public static int[] solution(int[] input){
        int[] isPrime = isPrimeCheck();

        List<Integer> answer = new ArrayList<>();

        for(int val : input){
            int tmp = val;

            int reverseVal = 0;

            while(tmp != 0){
                reverseVal *=10;
                reverseVal += (tmp % 10);
                tmp /= 10;
            }

            if(isPrime[reverseVal] == 0) answer.add(reverseVal);
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();

        int[] inputArr = new int[N];

        for(int i = 0; i < N; i++)
            inputArr[i] = in.nextInt();

        int[] answer = solution(inputArr);

        for(int ans : answer) System.out.print(ans + " ");
    }
}
