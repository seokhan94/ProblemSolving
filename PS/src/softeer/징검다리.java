package softeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 징검다리 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer N = Integer.parseInt(br.readLine());

        int[] height = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[] maxStone = new int[height.length];

        int result = 0;

        for(int i = 0; i < height.length; i++)
            result = Math.max(result, calMaxStone(i, height, maxStone));

        System.out.println(result);
    }

    static int calMaxStone(int index, int[] height, int[] maxStone){
        if(maxStone[index] != 0)
            return maxStone[index];

        maxStone[index] = 1;

        for(int i = index + 1; i < maxStone.length; i++){
            if(height[index] < height[i]){
                maxStone[index] = Math.max(maxStone[index], calMaxStone(i, height, maxStone) + 1);
            }
        }

        return maxStone[index];
    }
}
