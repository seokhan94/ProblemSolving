package programmers.kakao.RECRUIT_2023;

import java.util.ArrayList;
import java.util.List;

public class 개인정보수집유효기간 {
    static class Date{
        int year;
        int month;
        int day;

        public Date(int year, int month, int day) {
            this.year = year;
            this.month = month;
            this.day = day;
        }

        public Date(String date) {
            this(Integer.parseInt(date.split("\\.")[0]), Integer.parseInt(date.split("\\.")[1]), Integer.parseInt(date.split("\\.")[2]));
        }

        public Boolean enable(Date nowDate){
            if(this.year < nowDate.year)
                return false;
            else {
                if(this.year > nowDate.year) return true;

                if(this.month < nowDate.month) return false;
                else{
                    if(this.month > nowDate.month) return true;
                    else{
                        if(this.day < nowDate.day) return false;
                        else return true;
                    }
                }
            }

        }
    }
    public static void main(String[] args) {
        System.out.println(solution("2022.05.19", new String[]{"A 6", "B 12", "C 3"}, new String[]{"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"}));
        System.out.println(solution("2020.01.01", new String[]{"Z 3", "D 5"}, new String[]{"2019.01.01 D", "2019.11.15 Z", "2019.08.02 D", "2019.07.01 D", "2018.12.28 Z"}));
    }

    public static int[] solution(String today, String[] terms, String[] privacies){
        int[] answer = {};

        Date todayDate = new Date(today);

        int[] ranges = new int[27];

        for(String term : terms){
            int type = (term.split(" ")[0].charAt(0) - 'A');
            int range = Integer.parseInt(term.split(" ")[1]);
            ranges[type] = range;
        }

        List<Integer> answerList = new ArrayList<>();
        for(int i = 0; i < privacies.length; i++){
            String privacy = privacies[i];
            String date = privacy.split(" ")[0];
            int type = (privacy.split(" ")[1].charAt(0) - 'A');

            Date privacyDate = new Date(date);
            int range = ranges[type];

            int plusMonth = (privacyDate.month + range);
            int keepMonth = plusMonth % 12;
            int keepYear = privacyDate.year + (plusMonth / 12);
            int keepDay = 0;

            if(keepMonth == 0){
                keepMonth = 12;
                keepYear = keepYear - 1;
            }

            if(privacyDate.day - 1 == 0){
                keepDay = 28;
                if(keepMonth - 1 == -1){
                    keepMonth = 12;
                    keepYear -=1;
                }else{
                    keepMonth = keepMonth - 1;
                }
            }else{
                keepDay = privacyDate.day - 1;
            }


            Date keepEnableDate = new Date(keepYear, keepMonth, keepDay);
            Boolean enable = keepEnableDate.enable(todayDate);
            if(!enable)
                answerList.add(i+1);
        }

        answer = answerList.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
}
