package codility;

import java.util.Arrays;
import java.util.List;

public class BinaryGap {
    public static void main(String[] args) {
        System.out.println(solution(1041));
    }

    public static int solution(int N){
        String binaryN = decimalToBinary(N);
        int result = 0;

        int binaryGap = 0;
        for(int i = 0; i < binaryN.length(); i++){
            if(binaryN.charAt(i) == '1'){
                result = Math.max(result, binaryGap);
                binaryGap = 0;
            }else{
                binaryGap++;
            }
        }
        return result;
    }

    private static String decimalToBinary(int n) {
        int decimalVal = n;
        String binaryValue = "";
        while(decimalVal != 0){
            binaryValue = String.valueOf(decimalVal % 2) + binaryValue;
            decimalVal /= 2;
        }
        return binaryValue;
    }


}
