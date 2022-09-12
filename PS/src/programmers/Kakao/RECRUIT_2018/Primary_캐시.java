package programmers.Kakao.RECRUIT_2018;

import java.util.LinkedList;

public class Primary_캐시 {

    public static void main(String[] args) {
        int solution = solution(0, new String[]{"LA", "LA"});
        System.out.println(solution);
    }

    public static int solution(int cacheSize, String[] cities){
        int answer = 0;

        LinkedList<String> list = new LinkedList<>();


        for(int i = 0; i < cities.length; i++){
            String city = cities[i].toLowerCase();

            if(list.indexOf(city) > -1){{
                list.remove(list.indexOf(city));
                list.addLast(city);
                answer+=1;
            }}else{
                if(cacheSize != 0 && list.size() == cacheSize)
                    list.removeFirst();

                if(list.size() < cacheSize)
                    list.addLast(city);
                answer+=5;
            }
        }
        return answer;
    }

}
