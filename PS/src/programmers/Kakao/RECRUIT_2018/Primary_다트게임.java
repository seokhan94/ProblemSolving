package programmers.Kakao.RECRUIT_2018;

public class Primary_다트게임 {
    public static void main(String[] args) {
        int solution = solution("1S*2T*3S");
        System.out.println(solution);
    }

    public static int solution(String dartResult){
        int answer = 0;

        int gameSet = 0;
        int startIndex = 0;
        int prevScore = 0;

        while (gameSet < 3){
            int score = 0;

            while(startIndex < dartResult.length()
                    && dartResult.charAt(startIndex) >= '0'
                    &&  dartResult.charAt(startIndex) <= '9'){
                score = score * 10 + (dartResult.charAt(startIndex) - '0');
                startIndex++;
            }

            char bonus = dartResult.charAt(startIndex);
            int bonusValue = (bonus == 'S' ? 1 : (bonus == 'D' ? 2 : 3));
            char option = ' ';

            if(dartResult.length() > startIndex + 1){
                char c = dartResult.charAt(startIndex + 1);
                if(c == '*' || c == '#')
                    option = c;
            }

            double pow = Math.pow(score, bonusValue);
            switch (option){
                case ' ':
                    prevScore = (int) pow;
                    answer += (int) pow;
                    break;
                case '*':
                    answer += prevScore;
                    answer += ((int) pow * 2);
                    prevScore = (int)pow * 2;
                    break;
                case '#':
                    prevScore = -(int)pow;
                    answer -= (int) pow;
                    break;
                default:
                    break;
            }


            startIndex = startIndex + (option == ' ' ? 1 : 2);
            gameSet++;
        }

        return answer;
    }
}
