package softeer;

import sun.rmi.runtime.Log;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 수퍼바이러스 {
    static final int MOD_VAL = 1000000007;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        Long K = Long.parseLong(input.split(" ")[0]);
        Long P = Long.parseLong(input.split(" ")[1]);
        Long N = Long.parseLong(input.split(" ")[2]);

        Long result = K * cal(P, 10*N);

        System.out.println(result % MOD_VAL);
    }

    static Long cal(Long P, Long N){
        if(N == 1) return P;

        Long val = cal(P, N / 2);
        val = val * val % MOD_VAL;

        return (N % 2 == 0) ? val : (val * P) % MOD_VAL;
    }
}
