
package w11;
  
import java.util.*;

class Solution {
    int M, N;
    char[][] map;
    boolean[][] check;
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        M = m;
        N = n;
        map = new char[m][n];
        check = new boolean[m][n];
        
        for (int i = 0; i < m; i++)
            map[i] = board[i].toCharArray();
        
        while (check() != 0)
            bomb();
        
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (isBlock(map[i][j])) answer++;
            }
        }
        
        return m*n - answer;
    }
    
    private int check() {
        int cnt = 0;
        check = new boolean[M][N];
        for (int i = 0; i < M-1; i++) {
            for (int j = 0; j < N-1; j++) {
                if (isBoxStart(i,j)) {
                    cnt++;
                    check[i][j] = check[i][j+1] = check[i+1][j] = check[i+1][j+1] = true;
                }
            }
        }
        return cnt;
    }
    
    private boolean isBoxStart(int r, int c) {
        if (map[r][c] == map[r][c+1] && map[r][c] == map[r][c+1] && map[r][c] == map[r+1][c] && map[r][c] == map[r+1][c+1] && isBlock(map[r][c]))
            return true;
        return false;
    }
    
    private boolean isBlock(char c) {
        return 'A' <= c && 'z' >= c;
    }
    
    private void bomb() {
        char[][] newMap = new char[M][N];
        Stack<Character> s = new Stack();
        for (int j = 0; j < N; j++) {
            for (int i = 0; i < M; i++) {
                if (!check[i][j]) s.add(map[i][j]);
            }
            
            int ii = M-1;
            while(!s.isEmpty())
                newMap[ii--][j] = s.pop();
        }
        
        map = newMap;
    }
}
