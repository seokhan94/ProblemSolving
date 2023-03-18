package programmers.kakao.RECRUIT_2023;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 이모티콘할인행사 {
    public static void main(String[] args) {
        System.out.println(solution(
                new int[][]{{40, 10000}, {25, 10000}},
                new int[]{7000, 9000}
        ));
        System.out.println(solution(
                new int[][]{{40, 2900}, {23, 10000}, {11, 5200}, {5, 5900}, {40, 3100}, {27, 9200}, {32, 6900}},
                new int[]{1300, 1500, 1600, 4900}
        ));
    }

    static class DiscountEvent{
        private Integer plusService;
        private Integer sellCost;

        public DiscountEvent(Integer plusService, Integer sellCost) {
            this.plusService = plusService;
            this.sellCost = sellCost;
        }

        public Integer getPlusService() {
            return plusService;
        }

        public void setPlusService(Integer plusService) {
            this.plusService = plusService;
        }

        public Integer getSellCost() {
            return sellCost;
        }

        public void setSellCost(Integer sellCost) {
            this.sellCost = sellCost;
        }
    }
    static class UserInfo {
        private Integer rate;
        private Integer cost;

        public UserInfo(Integer rate, Integer cost) {
            this.rate = rate;
            this.cost = cost;
        }

        public Integer getRate() {
            return rate;
        }

        public Integer getCost() {
            return cost;
        }
    }

    public static int[] solution(int[][] users, int[] emoticons){
        int[] discountRate = new int[emoticons.length];
        List<UserInfo> userInfoList = new ArrayList<>();
        DiscountEvent discountEvent = new DiscountEvent(0, 0);

        for(int[] user : users)
            userInfoList.add(new UserInfo(user[0], user[1]));

        calc(discountEvent, userInfoList, emoticons, discountRate, 0);

        int[] answer = {discountEvent.getPlusService(), discountEvent.getSellCost()};
        return answer;
    }

    public static void calc(DiscountEvent discountEvent, List<UserInfo> userInfoList, int[] emotions, int[] discountRate, int index){
        if(index == emotions.length){
            DiscountEvent nowDiscountEvent = new DiscountEvent(0, 0);

            for(UserInfo userInfo : userInfoList){
                int sum = 0;

                for(int i = 0; i < emotions.length; i++){
                    if(discountRate[i] < userInfo.getRate()) continue;

                    sum += (emotions[i] - (emotions[i] * discountRate[i]) / 100);
                }

                if(userInfo.getCost() <= sum)
                    nowDiscountEvent.setPlusService(nowDiscountEvent.getPlusService() + 1);
                else
                    nowDiscountEvent.setSellCost(nowDiscountEvent.getSellCost() + sum);
            }

            if(discountEvent.getPlusService() < nowDiscountEvent.getPlusService()){
                discountEvent.setPlusService(nowDiscountEvent.getPlusService());
                discountEvent.setSellCost(nowDiscountEvent.getSellCost());
            }else if(discountEvent.getPlusService() == nowDiscountEvent.getPlusService()){
                if(discountEvent.getSellCost() < nowDiscountEvent.getSellCost())
                    discountEvent.setSellCost(nowDiscountEvent.getSellCost());
            }
            return;
        }

        for(int i = 10; i <= 40; i += 10){
            discountRate[index] = i;
            calc(discountEvent, userInfoList, emotions, discountRate, index + 1);
        }
    }
}
