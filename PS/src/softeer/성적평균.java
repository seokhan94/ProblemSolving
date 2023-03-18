package softeer;

import jdk.internal.util.xml.impl.Input;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class 성적평균 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        Integer N = Integer.parseInt(input.split(" ")[0]);
        Integer K = Integer.parseInt(input.split(" ")[1]);

        String score = br.readLine();

        int[] scoreList = Arrays.stream(score.split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] sumScoreByStudent = new int[N];

        for(int i = 0; i < N; i++){
            sumScoreByStudent[i] += scoreList[i];

            if(i - 1 >= 0)
                sumScoreByStudent[i] += sumScoreByStudent[i - 1];
        }

        for(int i = 0; i < K; i++){
            input = br.readLine();

            Integer A = Integer.parseInt(input.split(" ")[0]) - 1;
            Integer B = Integer.parseInt(input.split(" ")[1]) - 1;

            Integer rangeSum = (sumScoreByStudent[B] - sumScoreByStudent[A] + scoreList[A]);
            Double average = rangeSum.doubleValue() / (B - A + 1);

            String result = String.format("%.2f", average);

        }
    }
}
