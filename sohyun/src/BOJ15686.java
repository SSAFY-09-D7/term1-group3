import java.util.*;
import java.io.*;

public class BOJ15686 {
    static List<int[]> chicken;
    static List<int[]> home;
    static int[][] map;
    static int answer;
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        answer= Integer.MAX_VALUE;
        map = new int[N][N];
        home = new ArrayList<>();
        chicken = new ArrayList<>();

        for(int i=0;i<N;i++){
            st=  new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]==2){
                    chicken.add(new int[]{i,j});
                }
                else if(map[i][j]==1){
                    home.add(new int[]{i,j});
                }
            }
        }

        int[] index = new int[chicken.size()];

        for(int i=0;i<index.length;i++){
            index[i] = i;
        }


        for(int r=1;r<=M;r++){
            combination(r,0,new int[r],0,index);
        }

        System.out.println(answer);

    }
    private static void combination(int r, int current, int[] temp, int start,int[] index) {
        if(current==r){
            answer = Math.min(calc(temp),answer);
            return;
        }
        for(int i=start;i<chicken.size();i++){
            temp[current] = index[i];
            combination(r,current+1,temp,i+1,index);
        }
    }

    private static int calc(int[] temp){
        int sum = 0;
        for(int h=0;h<home.size();h++){
            int chickenLen = Integer.MAX_VALUE;
            int[] nowHome = home.get(h);
            for(int i=0;i<temp.length;i++){
                int[] nowChicken  = chicken.get(temp[i]);
                chickenLen = Math.min(chickenLen,
                Math.abs(nowHome[0]-nowChicken[0])+Math.abs(nowHome[1]-nowChicken[1])
                );
            }
            sum+=chickenLen;
            
        }
        return sum;
    }
    
    
}
