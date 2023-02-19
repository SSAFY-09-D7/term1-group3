import java.util.*;
import java.io.*;


public class BOJ17406 {
    static int N;
    static int M;
    static int K;
    static int[][] map;
    static int[][] rotateArr;
    static boolean[] arrVisit;
    static int answer = Integer.MAX_VALUE;
    static int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
       

        map = new int[N][M];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        rotateArr = new int[K][3];
        arrVisit = new boolean[K];
        for(int i=0;i<K;i++){
            //회전 연산 정보 주어짐
            st = new StringTokenizer(br.readLine());
            rotateArr[i][0] = Integer.parseInt(st.nextToken());
            rotateArr[i][1] = Integer.parseInt(st.nextToken());
            rotateArr[i][2] = Integer.parseInt(st.nextToken());

        }

        // 어떤거 먼저 회전할지 0~K-1까지 고르는 함수 : 순열
        makePermu(K,0, new int[K],arrVisit);
        //고른뒤, rotateArr 함수 수행
        // 수행 후, Arr에서 각 행에 있는 모든 수의 합 중 최소값 찾기
        System.out.println(answer);

    }

    private static void makePermu(int r, int current,int[] temp,boolean[] arrVisit) 
    {
        //r : 뽑고자 하는 개수
        //current : 현재 뽑은 개수
        if(current == r){
            int[][] copyMap = new int[N][M];
            for(int m=0;m<N;m++){
                for(int j=0;j<M;j++){
                    copyMap[m][j] = map[m][j];
                }
            }
            rotateArr(temp,copyMap);
        }
        else{
            for(int i=0;i<K;i++){
                if(!arrVisit[i]){
                    arrVisit[i] = true;
                    temp[current] = i;
                    makePermu(r, current+1, temp, arrVisit);
                    arrVisit[i] = false;
                }
            }
        }
    }

    private static void rotateArr(int[] temp, int[][] copyMap) {

        for(int i=0;i<temp.length;i++){
            int[] nowRotate =rotateArr[temp[i]];
            int r = nowRotate[0]-1;
            int c = nowRotate[1]-1;
            int s = nowRotate[2];


            for (int rr = 1; rr <= s; rr++) {
                int tempSave = copyMap[r - rr][c - rr];
                int row = r - rr;
                int col = c - rr;
                int startx = r - rr;
                int starty = c - rr;
                int dirr = 0;

                while (dirr != 4) {
                    copyMap[startx][starty] = copyMap[startx + dir[dirr][0]][starty + dir[dirr][1]];
                    startx = startx + dir[dirr][0];
                    starty = starty + dir[dirr][1];

                    if (startx >= r + rr && dirr == 0) {
                        dirr++;
                    } else if (starty >= c + rr && dirr == 1) {
                        dirr++;
                    } else if (startx <= r - rr && dirr == 2) {
                        dirr++;
                    } else if (starty <= c - rr && dirr == 3) {
                        dirr++;
                    }

                }
                copyMap[row][col + 1] = tempSave;

            }
            
            
            
        }
        answer = Math.min(answer, calArr(copyMap));
    }

    private static int calArr(int[][] copyMap) {
        int minRow = Integer.MAX_VALUE;
        for(int i=0;i<N;i++){
            int sum = 0;
            for(int j=0;j<M;j++){
                sum+=copyMap[i][j];
            }
            minRow = Math.min(minRow,sum);
        }
        return minRow;
    }
}
