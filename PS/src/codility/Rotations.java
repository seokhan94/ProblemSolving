package codility;

import java.util.Arrays;

public class Rotations {
    public static void main(String[] args) {
        int[] A = new int[]{};
        int K = 100;

        int[] result = solution(A, K);

        for (int i : result)
            System.out.print(i + " ");
    }

    private static int[] solution(int[] A, int K) {
        if(A.length == 0)
            return A;

        int[] result = new int[A.length];

        int standard = A.length - (K % A.length);

        for(int i = 0; i < A.length; i++){
            if(i < standard){
                result[i + (A.length - standard)] = A[i];
            }else{
                result[i - standard] = A[i];
            }
        }

        return result;
    }

}
