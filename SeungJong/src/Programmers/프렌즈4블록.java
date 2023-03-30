package Programmers;

/*
1. 반복문 안에 같은 모양의 타일이 정사각형으로 있는지 확인하고 그 위치를 저장하는 변수
2. 변수에 저장된 값들을 지우고
3. 공중에 떠있는 변수들을 스택에 담아서 아래로 내린다
4. 저장되는 변수가 없으면 종료
*/
import java.util.*;
public class 프렌즈4블록 {
    static char[][] map;
    static int Ans;
    public int solution(int m, int n, String[] board) {
        map = new char[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                map[i][j] = board[i].charAt(j);
            }
        }
        while(true){
            ArrayList<Point> list = check(m, n);
            if(list.size()==0) break;
            removeMap(list);         
        }
        int answer = Ans;
        return answer;
    }
    private static void removeMap(ArrayList<Point> list){
        for(int i=0; i<list.size(); i++){
            int r = list.get(i).r;
            int c = list.get(i).c;
            if(map[r][c] != '0'){
                map[r][c] = '0';
                Ans++;
            }
        }
        downBlock();
    }
    private static void downBlock(){
        Stack<Character> stack = new Stack<Character>();
        for(int j=0; j<map[0].length; j++){
            for(int i=0; i<map.length; i++){
                if(map[i][j] != '0'){
                    stack.push(map[i][j]);
                    map[i][j] = '0';
                }
            }
            int row = map.length-1;
            while(!stack.isEmpty()){
                map[row--][j] = stack.pop();
            }
        }
    }
    private static ArrayList<Point> check(int r, int c){
        ArrayList<Point> list = new ArrayList<Point>();
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                if(map[i][j] =='0') continue;
                boolean flag = true;
                for(int k=0; k<3; k++){
                    int nr = i + dr[k];
                    int nc = j + dc[k];
                    if(nr<0 || nc<0 || nr>= r || nc>= c || map[i][j] != map[nr][nc]){
                        flag = false;
                        break;
                    }
                }
                if(flag) {
                    list.add(new Point(i, j));
                    for(int k=0; k<3; k++){
                        int nr = i + dr[k];
                        int nc = j + dc[k];
                        list.add(new Point(nr, nc));
                    }
                }
            }
        }
        return list;
    }
    private static class Point{
        int r, c;
        Point(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
    static int[] dr = {0, 1, 1};
    static int[] dc = {1, 1, 0};
}