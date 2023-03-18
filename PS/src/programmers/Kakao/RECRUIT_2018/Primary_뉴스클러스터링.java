package programmers.kakao.RECRUIT_2018;

import java.util.ArrayList;
import java.util.List;

public class Primary_뉴스클러스터링 {
    public static void main(String[] args) {
        int solution = solution("E=M*C^2", "e=m*c^2");
        System.out.println(solution);
    }

    public static int solution(String str1, String str2){
        int answer = 0;

        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        List<String> firstList = new ArrayList<>();
        List<String> secondList = new ArrayList<>();

        for(int i = 0; i < str1.length() - 1; i++){
            if(!(checkAlpha(str1.charAt(i)) && checkAlpha(str1.charAt(i + 1))))
                continue;
            firstList.add(String.valueOf(str1.charAt(i)) + String.valueOf(str1.charAt(i + 1)));
        }
        for(int i = 0; i < str2.length() - 1; i ++){
            if(!(checkAlpha(str2.charAt(i)) && checkAlpha(str2.charAt(i + 1))))
                continue;;
            secondList.add(String.valueOf(str2.charAt(i)) + String.valueOf(str2.charAt(i + 1)));
        }

        if(firstList.size() == 0 && secondList.size() == 0)
            return 1 * 65536;

        int sumLength = firstList.size() + secondList.size();
        int andLength = 0;

        for (String s : firstList){
            if(secondList.indexOf(s) > -1){
                secondList.remove(secondList.indexOf(s));
                andLength++;
                sumLength--;
            }
        }

        answer = (andLength * 65536 / sumLength);

        return answer;
    }

    public static boolean checkAlpha(char c){
        if(c >= 'a' && c <= 'z') return true;
        return false;
    }
}
