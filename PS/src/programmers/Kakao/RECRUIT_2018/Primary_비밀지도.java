package programmers.kakao.RECRUIT_2018;

public class Primary_비밀지도 {
    public static void main(String[] args) {
        String[] answer = solution(5, new int[]{9, 20, 28, 18, 11}, new int[]{30, 1, 21, 17, 28});
        System.out.println(answer);
    }

    public static String[] solution(int n, int[] arr1, int[] arr2){
        String[] answer = {};

        answer = new String[n];

        for(int i = 0; i < n; i++){
            String firstMap = makeBinary(arr1[i], n - 1);
            String secondMap = makeBinary(arr2[i], n - 1);

//            answer[i] = "";

            for(int j = 0; j < n; j ++){
                char firstMapValue = firstMap.charAt(j);
                char secondMapValue = secondMap.charAt(j);
                answer[i] += (firstMapValue != '1' && firstMapValue == secondMapValue) ? ' ' : '#';
            }
        }

        return answer;
    }

    public static String makeBinary(int value, int depth){
        int share = value / 2;
        int remainder = value % 2;

        if(share != 0){
            return (makeBinary(share, depth - 1) + String.valueOf(remainder));
        }else{
            return (depth == 0) ? String.valueOf(remainder) : makeBinary(share, depth - 1) + String.valueOf(remainder);
        }
    }
}