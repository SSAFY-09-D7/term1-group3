class Solution {
    static char[][] board;
    static boolean[][] notSafety;
    static int[][] ds = {{0,1}, {1,0}, {0,-1}, {-1,0}};
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        
        for (int i = 0; i < places.length; i++) {
            board = new char[5][5];
            for (int j = 0; j < 5; j++)
                board[j] = places[i][j].toCharArray();
            answer[i] = getIsRight();
        }
            
        return answer;
    }
    
    private int getIsRight() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++)
                if (board[i][j] == 'P' && !checkIsSafe(i, j)) return 0;
        }
        
        return 1;
    }
    
    private boolean checkIsSafe (int r, int c) {
        for (int i = 0; i < 4; i++) {
            int nr = r + ds[i][0];
            int nc = c + ds[i][1];
            
            if (nr < 0 || nr >= 5 || nc < 0 || nc >= 5 || board[nr][nc] == 'X') continue;
            if (board[nr][nc] == 'P') return false;
            
            for (int j = 0; j < 4; j++) {
                if (j == (i+2)%4) continue;
                int nnr = nr + ds[j][0];
                int nnc = nc + ds[j][1];
                
                if (nnr < 0 || nnr >= 5 || nnc < 0 || nnc >= 5 || board[nnr][nnc] == 'X') continue;
                if (board[nnr][nnc] == 'P') return false;   
            }
        }
        
        return true;
    }

}
