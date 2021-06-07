package programmers;


import java.util.*;

public class 베스트앨범 {
    public int[] solution(String[] genres, int[] plays){
        int[] answer = {};

        Map<String, Integer> map = new HashMap<String, Integer>();
        Map<String, Map<Integer, Integer>> list_map = new HashMap<String, Map<Integer, Integer>>();

        ArrayList<Map<Integer, Integer>> ll = new ArrayList<Map<Integer, Integer>>();

        for(int i = 0; i < genres.length; i++){
            map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);

            Map<Integer, Integer> tmp = list_map.get(genres[i]);
            if(tmp == null)
                tmp = new HashMap<Integer, Integer>();

            tmp.put(i, plays[i]);
            list_map.put(genres[i], tmp);
        }

        List<Map.Entry<String, Integer>> map_entry = new ArrayList<Map.Entry<String, Integer>>(map.entrySet());

        Collections.sort(map_entry, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });

        int cnt = 0;

        List<Integer> ans_list = new ArrayList<Integer>();

        for(Map.Entry<String, Integer> entry: map_entry){
            Map<Integer, Integer> play_cnt = list_map.get(entry.getKey());

            List<Map.Entry<Integer, Integer>> play_cnt_entry = new ArrayList<Map.Entry<Integer, Integer>>(play_cnt.entrySet());

            Collections.sort(play_cnt_entry, new Comparator<Map.Entry<Integer, Integer>>() {
                @Override
                public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                    return o2.getValue().compareTo(o1.getValue());
                }
            });

            for(int i = 0; i < play_cnt_entry.size(); i++){
                if(i > 1) break;

                ans_list.add(play_cnt_entry.get(i).getKey());
//                a[cnt++] = play_cnt_entry.get(i).getKey();
            }
        }

        answer = new int[ans_list.size()];

        for(int i : ans_list)
            answer[cnt++] = i;
        return answer;
    }
}
