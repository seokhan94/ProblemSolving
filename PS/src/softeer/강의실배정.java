package softeer;

import java.io.*;
import java.util.*;

public class 강의실배정 {

    static class Course implements Comparable<Course>{
        int startTime;
        int endTime;

        public Course(int startTime, int endTime){
            this.startTime = startTime;
            this.endTime = endTime;
        }

        @Override
        public int compareTo(Course o) {
            if(this.endTime == o.endTime){
                return this.startTime - o.startTime;
            }
            return this.endTime - o.endTime;
        }
    }

    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer N = Integer.parseInt(br.readLine());

        List<Course> courses = new ArrayList<>();

        for(int i = 0; i<N; i++){
            String time = br.readLine();
            int startTime = Integer.parseInt(time.split(" ")[0]);
            int endTime = Integer.parseInt(time.split(" ")[1]);

            courses.add(new Course(startTime, endTime));
        }

        Collections.sort(courses);

        int answer = 0;
        int now = 0;

        for(Course c : courses){
            if(now <= c.startTime)
            {
                answer++;
                now = c.endTime;
            }
        }

        System.out.println(answer);
    }


}
