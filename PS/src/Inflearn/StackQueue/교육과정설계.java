package Inflearn.StackQueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 교육과정설계 {
    public static String solution(String requiredSubject, String subject){
        String answer = "YES";

//        String requiredSubjectList = "";
//
//        for(char c : subject.toCharArray()){
//            if(requiredSubject.contains(String.valueOf(c)))
//                requiredSubjectList += c;
//        }
//
//        if(!requiredSubject.equals(requiredSubjectList)) answer="NO";

        Queue<Character> queue = new LinkedList<>();
        for(char c : requiredSubject.toCharArray()) queue.offer(c);
        for(char c : subject.toCharArray()) {
            if(queue.contains(c)){
                if(c != queue.poll()) return "NO";
            }
        }

        if(!queue.isEmpty()) return "NO";

        return answer;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String requiredSubject = in.nextLine();
        String subject = in.nextLine();

        System.out.println(solution(requiredSubject, subject));
    }
}
