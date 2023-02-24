import java.util.*;

import java.io.*;

public class BOJ4179 {
    static int R;
    static int C;
    static char[][] map;
    static int answer;
    static boolean[][] visited;

    static class Point{
        int x;
        int y;
        int cnt;
        char type;
        Point(int x, int y, int cnt, char type){
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.type=type;
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        answer = Integer.MAX_VALUE;

        for(int i=0;i<R;i++){ 
            map[i] = br.readLine().toCharArray();
        }

        visited = new boolean[R][C];
        bfs();

        if(answer == Integer.MAX_VALUE){
            System.out.println("IMPOSSIBLE");
        }   
        else{
            System.out.println(answer);
        }
        


    }

    private static void bfs() {
        int[] dx ={-1,1,0,0};
        int[] dy = {0,0,-1,1};
        
        Queue<Point> q = new LinkedList<>();
        
        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                if(map[i][j] == 'F'){
                    visited[i][j] = true;
                      q.add(new Point(i,j,0,'F'));
                }
            }
        }

        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                if(map[i][j] == 'J'){
                    visited[i][j] = true;
                      q.add(new Point(i,j,0,'J'));
                }
            }
        }

        while(!q.isEmpty()){
            Point p = q.poll();
            //미로의 가장자리에 접한 공간에서 탈출
            if(p.type=='J'){
                if(p.x==0 || p.x ==R-1 || p.y==0 || p.y==C-1){
                    answer = Math.min(answer,p.cnt+1);
                }
            }
            for(int i=0;i<4;i++){
                int nx = p.x+dx[i];
                int ny = p.y+dy[i];
                
                

                if(nx>=0 && nx<R && ny>=0 && ny<C){
                    if(p.type=='F' && map[nx][ny]=='.'){
                        if(!visited[nx][ny]){
                            visited[nx][ny] = true;
                            q.add(new Point(nx,ny,p.cnt+1,'F'));
                        }
                    }
                    if(p.type=='J' && map[nx][ny]=='.'){
                        if(!visited[nx][ny]){
                            visited[nx][ny] = true;
                            q.add(new Point(nx,ny,p.cnt+1,'J'));
                        }
                    }
                }
            }
        }
    }

}
