package programmers.kakao.RECRUIT_2018;

import java.util.ArrayList;
import java.util.List;

public class Tertiary_방금그곡 {
    public static void main(String[] args) {
        System.out.println(solution("ABCDEFG", new String[]{"12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"}));
        System.out.println(solution("CC#BCC#BCC#BCC#B", new String[]{"03:00,03:30,FOO,CC#B", "04:00,04:08,BAR,CC#BCC#BCC#B"}));
        System.out.println(solution("ABC", new String[]{"12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"}));
    }

    static class MusicInfo{
        private String startTime;
        private String endTime;
        private String title;
        private String eum;

        private String fullEum;

        private Integer playtime;

        public MusicInfo(String startTime, String endTime, String title, String eum) {
            this.startTime = startTime;
            this.endTime = endTime;
            this.title = title;
            this.eum = eum;
            this.fullEum = calcFullEum(startTime,endTime, eum);
            this.playtime = calcTotalTime(startTime, endTime);
        }

        public String getStartTime() {
            return startTime;
        }


        public String getEndTime() {
            return endTime;
        }


        public String getTitle() {
            return title;
        }

        public String getEum() {
            return eum;
        }

        public String getFullEum() {
            return fullEum;
        }

        public Integer getPlaytime() {
            return playtime;
        }

        public Integer calcTotalTime(String startTime, String endTime){
            Integer diffHour = Integer.parseInt(endTime.split(":")[0]) - Integer.parseInt(startTime.split(":")[0]);
            Integer diffMinute = Integer.parseInt(endTime.split(":")[1]) - Integer.parseInt(startTime.split(":")[1]);

            if(diffMinute < 0){
                diffHour = diffHour - 1;
                diffMinute = 60 + diffMinute;
            }

            Integer totalMinute = diffHour * 60 + diffMinute;

            return totalMinute;
        }
        public String calcFullEum(String startTime, String endTime, String eum){
            String fullEum = "";

            Integer totalMinute = calcTotalTime(startTime, endTime);

            if(eum.length() == totalMinute) return eum;

            if(eum.length() > totalMinute) return eum.substring(0, totalMinute);
            else {
                for(int i = 0; i < (totalMinute / eum.length()); i++){
                    fullEum += eum;
                }
                fullEum += eum.substring(0, totalMinute % eum.length());
            }

            return fullEum;
        }
    }

    public static String changeEum(String eum){
        String changeEum = "";

        for(int i = 0 ; i < eum.length(); i++){
            if(eum.charAt(i) == '#') continue;

            if(i + 1 < eum.length() && eum.charAt(i + 1) == '#'){
                changeEum += String.valueOf((char)(eum.charAt(i) + 6));
            }else{
                changeEum += String.valueOf(eum.charAt(i));
            }
        }

        return changeEum;
    }

    public static String solution(String m, String[] musicinfos){
        String answer = "(None)";

        m = changeEum(m);
        List<MusicInfo> musicInfoList = new ArrayList<>();

        for(String musicInfo: musicinfos){
            String[] splitMusicInfo = musicInfo.split(",");

            String startTime = splitMusicInfo[0];
            String endTime = splitMusicInfo[1];
            String title = splitMusicInfo[2];
            String eum = splitMusicInfo[3];

            musicInfoList.add(new MusicInfo(startTime, endTime, title, changeEum(eum)));
        }

        int playTime = 0;

        for(MusicInfo musicInfo : musicInfoList){
            for(int i = 0; i < musicInfo.getFullEum().length(); i++){
                if(musicInfo.getFullEum().contains(m)
                        && playTime < musicInfo.getPlaytime()
                ){
                    playTime = musicInfo.getPlaytime();
                    answer = musicInfo.getTitle();
                }
            }
        }

        return answer;
    }
}
