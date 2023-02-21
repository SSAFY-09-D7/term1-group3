import java.util.*;
import java.io.*;

public class BOJ1926 {
    static int[][] map;
    static boolean[][] visited;
    static int N;
    static int M;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int answer = 0;
    static class Point{
        int x;
        int y;
        Point(int x,int y){
            this.x = x;
            this.y = y;

        }
    }

    public static void main(String[] args)throws Exception {
        //그림 개수, 그림 중 가장 넓은 것의 넓이
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int [N][M];
        visited = new boolean[N][M];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int cnt = 0;
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(map[i][j]==1 && visited[i][j]==false){
                    bfs(i,j);
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
        System.out.println(answer);

    }    
    private static void bfs(int i, int j){

        Queue<Point> q = new LinkedList<>();
        q.add(new Point(i,j));
        visited[i][j] = true;
        int area = 1;
        while(!q.isEmpty()){
            Point p = q.poll();
            for(int d=0;d<4;d++){
                int nx = p.x+dx[d];
                int ny = p.y+dy[d];
                if(nx>=0 && nx<N && ny>=0 && ny<M){
                    if(map[nx][ny]==1 && visited[nx][ny] == false){
                        visited[nx][ny] = true;
                        q.add(new Point(nx,ny));
                        area++;
                    }
                }
            }
        }
        answer=Math.max(answer,area);
    }
}
