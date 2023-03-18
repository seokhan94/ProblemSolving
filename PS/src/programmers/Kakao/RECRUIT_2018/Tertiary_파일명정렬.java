package programmers.kakao.RECRUIT_2018;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Tertiary_파일명정렬 {

    static class File implements Comparable<File>{
        String header;
        String number;
        String tail;

        public File(String header, String number, String tail) {
            this.header = header;
            this.number = number;
            this.tail = tail;
        }

        @Override
        public int compareTo(File o) {
            String header1 = this.header.toUpperCase();
            String header2 = o.header.toUpperCase();

            int compareValue = header1.compareTo(header2);

            if(compareValue != 0) return compareValue;

            int number1 = Integer.parseInt(this.number);
            int number2 = Integer.parseInt(o.number);

            return number1 - number2;
        }
    }

    public static void main(String[] args) {
        System.out.println(solution(new String[]{"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"}));
        System.out.println(solution(new String[]{"F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"}));
    }

    public static String[] solution(String[] files){
        String[] answer = {};

        List<File> list = new ArrayList<>();

        for (String file : files){
            char[] fileToChars = file.toCharArray();

            int index = 0;
            String header = "";
            String number = "";
            String tail = "";

            // Header
            while (index < file.length() && !(fileToChars[index] >= '0' && fileToChars[index] <='9'))
                header += fileToChars[index++];
            // Number
            while (index < file.length() && fileToChars[index] >= '0' && fileToChars[index] <= '9')
                number += fileToChars[index++];
            // Tail
            while (index < file.length())
                tail += fileToChars[index++];


            list.add(new File(header, number, tail));
        }

        Collections.sort(list);

        answer = list.stream().map(file -> file.header + file.number + file.tail).toArray(String[]::new);

        return answer;
    }
}
