import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.FileInputStream;


public class Maze {
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("sohyun/input/Maze.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        for(int testcase=1;testcase<=TC;testcase++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            //미로의 좌표는 1,1 부터 시작
            //좌표=0 으로 초기화, jumper는 -1로 초기화
            int[][] maze = new int[N+1][N+1];
            int startRow = Integer.parseInt(st.nextToken());
            int startCol = Integer.parseInt(st.nextToken());
            int jumperCnt = Integer.parseInt(st.nextToken());

            // System.out.printf("%d %d %d %d\n",N,startRow, startCol, jumperCnt);
            st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                int jumpRow = Integer.parseInt(st.nextToken());
                int jumpCol = Integer.parseInt(st.nextToken());
                maze[jumpRow][jumpCol] = -1;
            }
            // System.out.println(Arrays.deepToString(maze));


            st = new StringTokenizer(br.readLine());
            //방향지시 개수(0~50)
            int dirCnt = Integer.parseInt(st.nextToken());
            int[][] directMap = new int[dirCnt][2];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < dirCnt; i++) {
                //방향, 이동칸수
                int direction = Integer.parseInt(st.nextToken());
                int moveCnt = Integer.parseInt(st.nextToken());
                directMap[i][0] = direction;
                directMap[i][1] = moveCnt;
                // System.out.printf("방향:%d, 이동칸수:%d\n",direction,moveCnt);
            }
            // System.out.println(Arrays.deepToString(directMap));
            
            for (int m = 0; m < dirCnt; m++) {
                int direction = directMap[m][0];
                int moveCnt = directMap[m][1];
                int nx = startRow;
                int ny = startCol;
                System.out.printf("현재위치:%d, %d\n", nx, ny);
                if (direction == 1) {
                    //북
                    for (int cnt = 0; cnt < moveCnt; cnt++) {
                        nx = nx - 1;
                        if (nx < 1 || maze[nx][ny] == -1) {
                            //경계 넘어가거나 jumper에 도착하면 0,0
                            startRow = 0;
                            startCol = 0;
                            break;
                        } else {
                            startRow = nx;
                        }
                    }
                    
                } else if (direction == 2) {
                    //동
                    for (int cnt = 0; cnt < moveCnt; cnt++) {
                        ny = ny + 1;
                        if (ny > N || maze[nx][ny] == -1) {
                            //경계 넘어가거나 jumper에 도착하면 0,0
                            startRow = 0;
                            startCol = 0;
                            break;
                        } else {
                            startCol = ny;
                        }
                    }
                    
                } else if (direction == 3) {
                    //남
                    for (int cnt = 0; cnt < moveCnt; cnt++) {
                        nx = nx + 1;
                        if (nx > N || maze[nx][ny] == -1) {
                            //경계 넘어가거나 jumper에 도착하면 0,0
                            startRow = 0;
                            startCol = 0;
                            break;
                        } else {
                            startRow = nx;
                        }
                    }
                   

                } else if (direction == 4) {
                    //서
                    for (int cnt = 0; cnt < moveCnt; cnt++) {
                        ny = ny - 1;
                        if (ny < 1 || maze[nx][ny] == -1) {
                            //경계 넘어가거나 jumper에 도착하면 0,0
                            startRow = 0;
                            startCol = 0;
                            break;
                        } else {
                            startCol = ny;
                        }
                    }

                }
                if (startCol == 0 || startRow == 0)
                    break;
            }
            
            System.out.printf("#%d %d %d\n", testcase, startRow, startCol);
;        }
    }
}
