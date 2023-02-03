import java.util.*;
import java.io.*;
public class BOJ1063 {

    public static int kingX;
    public static int kingY;
    public static int stoneX;
    public static int stoneY;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[][] map = new int[8][8];

        while (st.hasMoreTokens()) {
            String king = st.nextToken();
            String stone = st.nextToken();

            kingX = 8 - (king.charAt(1) - '0');
            kingY = (int) king.charAt(0) - (int) 'A';

            stoneX = 8 - (stone.charAt(1) - '0');
            stoneY = (int) stone.charAt(0) - (int) 'A';

            map[kingX][kingY] = 1;
            map[stoneX][stoneY] = 2;

            //움직이는 횟수 
            int N = Integer.parseInt(st.nextToken());

            for (int i = 0; i < N; i++) {
                String input = br.readLine();
                map = changeMap(input, map);
            }

            //정답 출력
            printAnswer();
           

        }
    }
    
    private static void printAnswer() {
        StringBuilder sb = new StringBuilder();

        char kingCol = (char) ((int) 'A' + kingY);
        int kingRow = 8 - kingX;
        sb.append(kingCol).append(kingRow);

        char stoneCol = (char) ((int) 'A' + stoneY);
        int stoneRow = 8 - stoneX;
        sb.append("\n").append(stoneCol).append(stoneRow);
        System.out.println(sb);
    }

    private static int[][] changeMap(String input, int[][] map) {
        //돌과 같은 곳으로 이동할 때 돌,킹 둘다 같은 방향으로 이동
        switch(input){
            case "R":
                map = move(map,0,1);
                break;
            case "L":
                map = move(map,0,-1);
                break;
            case "B":
                map = move(map,1,0);
                break;
            case "T":  
                map = move(map,-1,0);
                break;
            case "RT":
                map = move(map,-1,1);
                break;
            case "LT":
                map = move(map,-1,-1);
                break;
            case "RB":
                map = move(map,1,1);
                break;
            case "LB":
                map = move(map,1,-1);
                break;
        }
        return map;
    }

    private static int[][] move(int[][] map, int dx,int dy){
        int kx = kingX+dx;
        int ky = kingY + dy;
        
        if(kx>=0 && kx<8 && ky>=0 &&ky<8){
            if(map[kx][ky]==2){
                int sx = kx+dx;
                int sy = ky+dy;
                if(sx>=0 && sx<8 && sy>=0 &&sy<8){
                    map[kx][ky]=1;
                    map[kingX][kingY]=0;
                    map[sx][sy] = 2;

                    kingX = kx;
                    kingY = ky;
                    stoneX = sx;
                    stoneY = sy;
                    
                }
            }
            else {
                
                map[kx][ky]=1;
                map[kingX][kingY] = 0;
                kingX = kx;
                kingY = ky;
            }    
        }
        return map;
    }
    
}
