import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Jump {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("sohyun/input/JumpInput.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());

        
        for(int testcase=1;testcase<=TC;testcase++)
        {
            int prizeSum = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());


            int[][] map = new int[y][x];
            for(int row=0;row<y;row++)
            {
                st = new StringTokenizer(br.readLine());
                for (int col = 0; col < x; col++) {
                    map[row][col] = Integer.parseInt(st.nextToken());
                }
            }

            // System.out.println("map출력");
            // System.out.println(Arrays.deepToString(map));

            //참가자 수만큼 시작 행,열,횟수
            int[][] parti = new int[n][3];
            for(int i=0;i<n;i++)
            {
                //시작행
                st = new StringTokenizer(br.readLine());
                int start_r = Integer.parseInt(st.nextToken());
                int start_c = Integer.parseInt(st.nextToken());
                int jump = Integer.parseInt(st.nextToken());

                parti[i][0] = start_r;
                parti[i][1] = start_c;
                parti[i][2] = jump;

            }

            // System.out.println("참가자 출력");
            // System.out.println(Arrays.deepToString(parti));

            //함정의 수, 함정의 좌표 주어짐
            st = new StringTokenizer(br.readLine());
            int fake_cnt = Integer.parseInt(st.nextToken());
            while(st.hasMoreTokens())
            {
                int f_y = Integer.parseInt(st.nextToken());
                int f_x = Integer.parseInt(st.nextToken());

                //함정은 0으로 바꾸기
                map[f_y-1][f_x-1] = 0;
            }

            // System.out.println("함정으로 바꾼 뒤 map출력");
            // System.out.println(Arrays.deepToString(map));
            
            //참가자 순서대로 좌표 분석,
            for(int cnt=0;cnt<n;cnt++)
            {
                int jumpCnt = parti[cnt][2];
                int num = map[parti[cnt][0]-1][parti[cnt][1]-1];
                int n_x = parti[cnt][0]-1;
                int n_y = parti[cnt][1]-1;
                prizeSum -=1000;
                boolean fail = false;
                int lastX = 0;
                int lastY = 0;
                while (jumpCnt>0) {
                    int dx = n_x;
                    int dy = n_y;
                    num = map[dx][dy];
                    int dir = num / 10;
                    int jumpLen = num % 10;

                    switch (dir) {
                        case 1:
                            //동
                            dx = n_x;
                            dy = n_y + jumpLen;
                            if (dy < x) {
                                if (map[dx][dy] == 0) {
                                    //함정에 빠짐
                                    fail = true;
                                } else
                                    n_y = n_y + jumpLen;
                            } else {
                                //경계 넘어감
                                fail = true;
                            }
                            break;
                        case 2:
                            //남
                            dx = n_x + jumpLen;
                            dy = n_y;
                            if (dx < y) {
                                if (map[dx][dy] == 0) {
                                    //함정에 빠짐
                                    fail = true;
                                } else
                                    n_x = n_x + jumpLen;
                            } else {
                                //경계 넘어감
                                fail = true;
                            }
                            break;
                        case 3:
                            //서
                            dx = n_x;
                            dy = n_y - jumpLen;
                            if (dy >= 0) {
                                if (map[dx][dy] == 0) {
                                    //함정에 빠짐
                                    fail = true;
                                } else
                                    n_y = n_y - jumpLen;
                            } else {
                                //경계 넘어감
                                fail = true;
                            }

                           
                            break;
                        case 4:
                            //북
                            dx = n_x - jumpLen;
                            dy = n_y;
                            if (dx >= 0) {
                                if (map[dx][dy] == 0) {
                                    //함정에 빠짐
                                    fail = true;
                                } else
                                    n_x = n_x - jumpLen;
                            } else {
                                //경계 넘어감
                                fail = true;
                            }
                            break;
                    }
                    if (fail == true) {
                        //jump 중단, 상금-1000
                        break;
                    } else {
                        lastX = n_x;
                        lastY = n_y;
                        jumpCnt--;
                    }
                    
                }
                //마지막 좌표 숫자 *100 해서 더하기
                if (!fail) {
                    int lastNum = map[lastX][lastY];
                    prizeSum += lastNum * 100;
                }
            }
            System.out.printf("# %d %d\n",testcase,prizeSum);
            

        }
    }
}