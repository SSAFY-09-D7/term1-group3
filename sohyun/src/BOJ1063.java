import java.util.*;
import java.io.*;
public class BOJ1063 {

    
    public static void main(String[] args)throws Exception {
        
        //알파벳은 열 숫자는 행
        // 왼->오 a~h
        // 위->아래 8~1

        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[][] map = new int[9][9];
        //초기 -> 0, king:1,. stone:2
        while(st.hasMoreTokens()){
            //a,1 좌표 
            String king = st.nextToken();
            String stone = st.nextToken();
            
            int kingX = 8-(king.charAt(1)-'0');
            int kingY = king.charAt(0)-'A';

            int stoneX = 8-(stone.charAt(1)-'0');
            int stoneY = stone.charAt(0)-'A';
            map[kingX][kingY]=1;
            map[stoneX][stoneY]=2;
            //움직이는 횟수 
            int N = Integer.parseInt(st.nextToken());
            for(int i=0;i<N;i++){
                String input = br.readLine();
                map = changeMap(input,map,kingX,kingY,stoneX,stoneY);
            }
            //1,2위치 출력
            
            for(int i=0;i<9;i++){
                for(int j=0;j<9;j++){
                    if(map[i][j]==1){
                        //king인 경우
                        //int 0이면 a. 1이면 b...
                        char col = (char)(j+(int)'A');
                        int row = 8-i;
                        StringBuilder sb = new StringBuilder();
                        sb.append(col).append(row);
                        System.out.println(sb);
                    }
                    else if(map[i][j]==2){
                        //stone인경우
                        char col = (char)(j+(int)'A');
                        int row = 8-i;
                        StringBuilder sb = new StringBuilder();
                        sb.append(col).append(row);
                        System.out.println(sb);
                    }
                }
            }
        }
    }

    private static int[][] changeMap(String input, int[][] map, int kingX, int kingY, int stoneX, int stoneY) {
        //돌과 같은 곳으로 이동할 때 돌,킹 둘다 같은 방향으로 이동
        switch(input){
            case "R":
                map = move(map,0,1,kingX,kingY);
                break;
            case "L":
                map = move(map,0,-1,kingX,kingY);
                break;
            case "B":
                map = move(map,1,0,kingX,kingY);
                break;
            case "T":  
                map = move(map,-1,0,kingX,kingY);
                break;
            case "RT":
                map = move(map,-1,1,kingX,kingY);
                break;
            case "LT":
                map = move(map,-1,-1,kingX,kingY);
                break;
            case "RB":
                map = move(map,1,1,kingX,kingY);
                break;
            case "LB":
                map = move(map,1,-1,kingX,kingY);
                break;
        }
        return map;
    }

    private static int[][] move(int[][] map, int dx,int dy,int kingX,int kingY){
        int kx = kingX+dx;
        int ky = kingY+dy;
         //돌이 있는지 확인
        if(kx>=0 && ky<8 && ky>=0 &&ky<8){
            if(map[kx][ky]==2){
                int sx = kx+dx;
                int sy = ky+dy;
                if(sx>=0 && sx<8 && sy>=0 &&sy<8){
                    map[kx][ky]=1;
                    map[kingX][kingY]=0;
                    map[sx][sy] = 2;
                }
            }
            else{
                //돌 없으면
                map[kx][ky]=1;
                map[kingX][kingY]=0;
            }    
        }
        return map;
    }
    
}
