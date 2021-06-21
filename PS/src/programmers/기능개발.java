package programmers;

import java.util.*;

public class 기능개발 {
    public int[] solution(int[] progresses, int[] speeds){
        int[] answers = {};

        Queue<Integer> q = new LinkedList<>();

        for(int i = 0; i < progresses.length; i++){
            int share = (100 - progresses[i]) / speeds[i];
            int remain = (100 - progresses[i]) % speeds[i];

            q.add(share + ((remain > 0) ? 1 : 0));
        }

        List<Integer> list = new ArrayList<>();

        while(!q.isEmpty()){
            int front = q.poll();
            int cnt = 1;

            while(!q.isEmpty()){
                int next = q.peek();
                if(next > front) break;

                q.remove();
                cnt++;
            }

            list.add(cnt);
        }

        answers = list.stream().mapToInt(Integer::intValue).toArray();

//        for(int i = 0; i < list.size(); i++)
//            answers[i] = list.get(i);

        return answers;
    }
}
