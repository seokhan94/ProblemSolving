package programmers.kakao.RECRUIT_2018;

public class Tertiary_n진수게임 {
    public static void main(String[] args) {
        System.out.println(solution(2,4,2,1));
        System.out.println(solution(16,16,2,1));
        System.out.println(solution(16,16,2,2));
    }

    public static String solution(int n, int t, int m, int p){
        String answer = "";

        int nowNumber = 0;
        String totalNumber = "";

        int nowTurn = 0;
        while(nowTurn != t){
            while (totalNumber.length() < nowTurn * m + p)
                totalNumber += makeNotation(n, nowNumber++, 0);

            answer += totalNumber.charAt(nowTurn * m + p - 1);
            nowTurn++;
        }


        return answer;
    }

    public static String makeNotation(int n, int number, int depth){
        if(number == 0)
            return (depth == 0) ? "0" : "";

        int share = number / n;
        int remainder = number % n;

        return makeNotation(n, share, depth + 1) + Integer.toHexString(remainder).toUpperCase();
    }
}
