package codility;

import java.util.HashSet;
import java.util.Set;

public class OddOccurrencesInArray {
    public static void main(String[] args) {
        int[] A = new int[]{9,3,9,3,9,7,9};
        System.out.println(solution(A));
    }

    private static int solution(int[] A) {
        Set<Integer> set = new HashSet<>();

        for(int i = 0; i < A.length; i++){
            if(set.contains(A[i]))
                set.remove(A[i]);
            else
                set.add(A[i]);
        }

        return set.stream().findFirst().orElse(0);
    }

}
