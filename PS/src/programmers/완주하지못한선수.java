package programmers;

import java.util.HashMap;
import java.util.Map;

public class 완주하지못한선수 {
    public String solution(String[] participant, String[] completion){
        Map<String, Integer> map = new HashMap<String, Integer>();

        for(String c : completion) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for(String p : participant){
            if(!map.containsKey(p)) return p;
            if(map.get(p) == 0) return p;

            map.put(p, map.get(p) - 1);
        }

        return "";
    }
}
