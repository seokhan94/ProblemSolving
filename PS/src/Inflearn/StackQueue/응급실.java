package Inflearn.StackQueue;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class 응급실 {
    static class Info implements Comparable<Info> {
        int priority;
        int index;

        public Info(int priority, int index) {
            this.priority = priority;
            this.index = index;
        }

        @Override
        public int compareTo(Info o) {
            if(this.priority < o.priority) return 1;
            else if(this.priority > o.priority) return -1;
            else {
                if(this.index > o.index) return 1;
                else return -1;
            }
        }
    }

    public static int solution(int[] priority, int M){
        int answer = 0;

        PriorityQueue<Info> priorityQueue = new PriorityQueue<>();

        for(int i = 0; i < priority.length; i++){
            Info info = new Info(priority[i], i);
            priorityQueue.add(info);
        }

        while(!priorityQueue.isEmpty()){
            Info info = priorityQueue.poll();
            answer++;

            if(info.index == M) break;
        }

        return answer;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();
        int M = in.nextInt();

        int[] priority = new int[N];

        for(int i = 0; i < N; i++)
            priority[i] = in.nextInt();

        System.out.println(solution(priority, M));
    }
}
