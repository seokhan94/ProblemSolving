package programmers.kakao.RECRUIT_2018;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Tertiary_압축 {
    static class DicInfo{
        int index;
        String word;

        public DicInfo(int index, String word) {
            this.index = index;
            this.word = word;
        }
    }
    public static void main(String[] args) {
        int[] result = solution("ABABABABABABABAB");

        for(int i = 0; i < result.length; i++)
            System.out.println(result[i]);
    }

    public static int[] solution(String msg){
        int[] answer = {};

        Map<String, DicInfo> map = new HashMap<>();

        for(char c = 'A'; c <= 'Z'; c++)
            map.put(String.valueOf(c), new DicInfo(map.size() + 1, String.valueOf(c)));

        int inputIndex = 0;

        List<Integer> resultList = new ArrayList<>();

        while (inputIndex < msg.length()){
            String inputString = "" + msg.charAt(inputIndex);
            int resultValue = 0;

            while (map.containsKey(inputString) && inputIndex + 1 <= msg.length()){
                resultValue = map.get(inputString).index;
                if(inputIndex + 1 < msg.length())
                    inputString += msg.charAt(inputIndex + 1);
                inputIndex++;
            }

            resultList.add(resultValue);
            map.put(inputString, new DicInfo(map.size() + 1, inputString));
        }

        answer = resultList.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
}
