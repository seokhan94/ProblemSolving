package Inflearn.String;

import java.util.*;

public class 단어뒤집기 {

    public static String[] solution(String[] input){
        List<String> list = new ArrayList<>();

        for(String i : input){
//            String tmp = "";
//            for(int j = i.length() - 1; j >=0; j--)
//                tmp += i.charAt(j);
//            list.add(tmp);

            String tmp = new StringBuilder(i).reverse().toString();
            list.add(tmp);
        }

        String[] answer = new String[list.size()];
        for(int i = 0 ; i < list.size(); i++)
            answer[i] = list.get(i);

        return answer;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();

        String[] str = new String[N];

        for(int i = 0 ; i < N; i++){
            str[i] = in.next();
        }

        String[] answer = solution(str);

        for(String ans : answer){
            System.out.println(ans);
        }
    }
}
