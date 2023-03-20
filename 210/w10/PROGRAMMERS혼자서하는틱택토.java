class Solution {
    public int solution(String[] board) {
        int oCnt = 0, xCnt = 0, oTCnt = 0, xTCnt = 0;
        char[][] b = new char[3][3];
        
        for (int i = 0; i < 3; i++) {
            b[i] = board[i].toCharArray();
        }
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (b[i][j] == 'O') oCnt++;
                else if (b[i][j] == 'X') xCnt++;
            }
        }
        
        if (xCnt > oCnt || oCnt - xCnt > 1) return 0;
        
        for (int i = 0; i < 3; i++) {
            if (b[0][i] != '.' && b[0][i] == b[1][i] && b[0][i] == b[2][i]) {
                if (b[0][i] == 'O' && oCnt - xCnt != 1) return 0; 
                else if (b[0][i] == 'X' && oCnt != xCnt) return 0;
            }
            
            if (b[i][0] != '.' && b[i][0] == b[i][1] && b[i][0] == b[i][2]) {
                if (b[i][0] == 'O' && oCnt - xCnt != 1) return 0; 
                else if (b[i][0] == 'X' && oCnt != xCnt) return 0;
            }
        }
        
        if (b[0][0] != '.' && b[0][0] == b[1][1] && b[0][0] == b[2][2]) {
            if (b[0][0] == 'O' && oCnt - xCnt != 1) return 0; 
            else if (b[0][0] == 'X' && oCnt != xCnt) return 0;
        }
        
        if (b[0][2] != '.' && b[0][2] == b[1][1] && b[0][2] == b[2][0]) {
            if (b[0][2] == 'O' && oCnt - xCnt != 1) return 0; 
            else if (b[0][2] == 'X' && oCnt != xCnt) return 0;
        }
        
        return 1;
    }
}
