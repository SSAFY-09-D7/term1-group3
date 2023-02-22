import java.util.*;
import java.io.*;

public class BOJ1303 {
    static int N;
    static int M;
    static int WP;  //내병사 답
    static int BP;  //적군병사 답

    static boolean[][] visited;
    static char[][] map;
    static List<Point> Wmap;
    static List<Point> Bmap;
    static int WAnswer = 0 ;
    static int BAnswer = 0;

    static class Point{
        int x;
        int y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    public static void main(String[] args)throws Exception {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[M][N];


        visited = new boolean[M][N];

        
        
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            map[i] = st.nextToken().toCharArray();
        }

        for(int i=0;i<M;i++){
            for(int j=0;j<N;j++){
                if(map[i][j]=='W' && visited[i][j]==false){
                    WP = 1;
                    dfs(i,j,'W');
                    WAnswer+=WP*WP;

                }
                if(map[i][j]=='B' && visited[i][j]==false){
                    BP = 1;
                    dfs(i,j,'B');
                    BAnswer+=BP*BP;
                }
            }
        }

        System.out.println(WAnswer);
        System.out.println(BAnswer);

        
    }

    private static void dfs(int i, int j, char c) {

        if(map[i][j]!=c || visited[i][j]){
            return;
        }


        visited[i][j] = true;

        for(int d=0;d<4;d++){
            int nx = i+dx[d];
            int ny = j+dy[d];
            if(nx>=0 &&nx<M && ny>=0 &&ny<N){
                if(map[nx][ny]==c && !visited[nx][ny]){
                    dfs(nx,ny,c);
                    if(c=='W') WP++;
                    else BP++;
                }
            }
        }
    }
}
