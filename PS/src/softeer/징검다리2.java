package softeer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

public class 징검다리2 {
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] height = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        List<Integer> LIS = new ArrayList<>();

        makeLIS(height, LIS);
    }

    static void makeLIS(int[] height, List<Integer> LIS){
        for(int i = 0; i < height.length; i++){
            int nowIndex = i;
            int nowNum = height[i];


        }
    }

}
