package programmers.Kakao.RECRUIT_2018;

import java.util.ArrayList;
import java.util.List;

public class Primary_프렌즈4블록 {
    public static void main(String[] args) {
        int solution = solution(4, 5, new String[]{"CCBDE", "AAADE", "AAABF", "CCBBF"});
        System.out.println(solution);
    }

    static class ErasePosition {
        int m;
        int n;

        public ErasePosition(int m, int n) {
            this.m = m;
            this.n = n;
        }
    }

    public static int solution(int m, int n, String[] board){
        int answer = 0;

        while (true){
            List<ErasePosition> list = new ArrayList<>();

            // Search 4 Blocks
            for(int i = 0; i < m; i++)
                for(int j =0; j < n; j++)
                    if(i + 1 < m && j + 1 < n)
                        if(board[i].charAt(j) != ' '
                            && board[i].charAt(j) == board[i + 1].charAt(j)
                            && board[i].charAt(j) == board[i].charAt(j+1)
                            && board[i].charAt(j) == board[i+1].charAt(j+1)){
                            list.add(new ErasePosition(i, j));
                            list.add(new ErasePosition(i + 1, j));
                            list.add(new ErasePosition(i, j + 1));
                            list.add(new ErasePosition(i + 1, j + 1));
                        }

            // Erase Block
            if(list.isEmpty())
                break;

            for(ErasePosition erasePosition : list){
                char[] row = board[erasePosition.m].toCharArray();
                row[erasePosition.n] = ' ';
                board[erasePosition.m] = String.valueOf(row);
            }

            // Fill Empty space
            for(int i = m - 1; i >= 0; i--)
                for(int j = 0; j < n; j ++){
                    if(board[i].charAt(j) == ' '){
                        int highRow = i - 1;
                        while(highRow >= 0 && board[highRow].charAt(j) == ' ') highRow--;

                        if(highRow < 0) continue;

                        char[] low = board[i].toCharArray();
                        char[] high = board[highRow].toCharArray();

                        low[j] = high[j];
                        high[j] = ' ';

                        board[i] = String.valueOf(low);
                        board[highRow] = String.valueOf(high);
                    }
                }
        }

        for(int i = 0; i < m; i++)
            for(int j =0; j < n; j++)
                if(board[i].charAt(j) == ' ')
                    answer++;

        return answer;
    }
}
