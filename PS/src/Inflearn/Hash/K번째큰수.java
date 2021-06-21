package Inflearn.Hash;

import java.util.*;

public class K번째큰수 {
    // TreeSet : 중복제거, 정렬까지
//    public static Set<Integer> set = new TreeSet<>();
    // 역순으로 정렬
    public static TreeSet<Integer> set = new TreeSet<>(Collections.reverseOrder());

    public static void combination(int[] input, boolean[] check, int cnt, int sum, int index){
        if(cnt == 3){
            set.add(sum);
            return;
        }

        for(int i = index; i < input.length; i++){
            if(check[i]) continue;

            check[i] = true;
            combination(input, check, cnt + 1, sum + input[i], i + 1);
            check[i] = false;
        }
    }

    public static int solution(int[] input, int K){
        int answer = 0;

        boolean[] check = new boolean[input.length];

        combination(input, check, 0, 0, 0);

//        System.out.println(set.last());

        if(set.size() < K) return -1;
//        int cnt = 0;
//        K = set.size() - K;
//        for(int k : set){
////            System.out.println(k);
//            if(cnt == K) {
//                answer = k;
//                break;
//            }
//            cnt++;
//        }

        int cnt = 1;
        for(int k : set){
            if(cnt == K)
            {
                answer = k;
                break;
            }
            cnt++;
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();
        int K = in.nextInt();

        int[] inputArr = new int[N];

        for(int i = 0; i < N; i++)
            inputArr[i] = in.nextInt();

        System.out.println(solution(inputArr, K));
    }
}
