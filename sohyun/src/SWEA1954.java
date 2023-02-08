import java.util.*;
import java.io.*;
public class SWEA1954 {

    //1 2 3
    //4 5 6
    //7 8 9

    //1 2 3
    //8 9 4
    //7 6 5

    //1 2 3 4
    //5 6 7 8
    //9 10 11 12
    //13 14 15 16

    


    static boolean[][] visited;
    static int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int i=0;i<T;i++){
            int N = sc.nextInt();
            //달펭이 배열만들기
            int[][] map = new int[N][N];
            visited = new boolean[N][N];
           
            map[0][0] = 1;
            int x = 0;
            int y = 0;
            int k=0;
            int number = 2;
            while(number<N*N){
               
                
                int nx = x+dir[k%4][0];
                int ny = y+dir[k%4][1];
                
                
               
                if( (nx>=0 && nx<N && ny>=0 && ny<N) && visited[nx][ny]==false){
                    System.out.printf("nx:%d ny:%d\n",nx,ny);
                    System.out.printf("number:%d\n",number);
                    map[nx][ny] = number;
                    visited[nx][ny]=true;
                    x=nx;
                    y=ny;
                    number++;
                    
                    
                }
                else{
                    //원래 갔었다면 
                    k++;
                    nx = x+dir[k%4][0];
                    ny = y+dir[k%4][1];
                    map[nx][ny] = number;
                    visited[nx][ny]=true;
                    x=nx;
                    y=ny;
                    number++;
                }
                
            
                
            }
            System.out.println(Arrays.deepToString(map));
        }
    }
}
