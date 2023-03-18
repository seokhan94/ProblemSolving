package programmers.lv_2;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.*;

public class 위장 {
    public int solution(String[][] clothes) {
        int answer = 1;

        Map<String, Integer> map = new HashMap<String, Integer>();

        for(int i = 0; i < clothes.length; i++){
            String kind = clothes[i][1];

            map.put(kind, map.getOrDefault(kind, 0) + 1);
        }

        for(int i : map.values()){
            answer *= (i + 1);
        }

        return answer - 1;
    }
}
