package programmers;

import java.util.*;


class 프린터 {
    static class Printer{
        int index;
        int priority;

        public Printer(int index, int priority){
            this.index = index;
            this.priority = priority;
        }
    }

    public static int solution(int[] priorities, int location) {
        int answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        Deque<Printer> dq = new ArrayDeque<>();

        for(int i = 0;  i < priorities.length; i++){
            pq.add(priorities[i]);
            Printer printer = new Printer(i, priorities[i]);
            dq.addLast(printer);
        }


        while(!pq.isEmpty()){
            int priority = pq.poll();

            Printer printer = dq.pop();

            if(printer.priority < priority)
            {
                pq.add(priority);
                dq.addLast(printer);
                continue;
            }

            answer++;

            if(printer.index == location)
                return answer;
        }

        return answer;
    }

}