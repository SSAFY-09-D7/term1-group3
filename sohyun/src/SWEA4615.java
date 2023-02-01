import java.util.*;

public class SWEA4615 {
    public static void main(String[] args) {
        
        //보드 : 4*4, 6*6. 8*8
        //B : 흑돌, W : 백돌
        //흑백이 번갈아가며 돌을 놓는다
        //돌을 넣을 수 있는 공간 :자신이 놓을 돌과 , 
        //자신의 돌 사이에 상대편의 돌이 있을 경우에만 그곳에 돌을 놓을 수 있다.
        //사이란, 가로/세로/대각선을 의미
        //돌을 놓을 곳이 없으면 상대편 플레이어가 돌을 놓는다
        // 빈 곳이 없거나, 양플레이어 모두 돌을 놓을 곳이 없으면 게임이 끝남
        // 보드에 있는 돌의 개수가 많은 플레이어가 승리

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        //상,하,좌,우,위대각왼,위대각오,아래왼,아래오
        int[] dx = {-1,1,0,0,-1,-1,1,1};
        int[] dy = {0,0,-1,1,-1,1,-1,1};
        for(int testcase=1;testcase<=T;testcase++){
            int N = sc.nextInt(); // N*N 보드
            int[][] map = new int[N][N];        //첨에 0 , 

            int M = sc.nextInt();   // 플레이어가 돌을 놓는 횟수
            boolean gameOver = false;   //놓을 수 없거나 빈 곳이 없으면 true
            //정가운데에 w,b,b,w 놓고 시작
             //6*6->(2,2):2,(2,3):1(3,2):1, (3,3):2 
            map[N/2-1][N/2-1] = 2;
            map[N/2-1][N/2] = 1;
            map[N/2][N/2-1] = 1;
            map[N/2][N/2] = 2;

            int black = 0;
            int white = 0;

            for(int j=0;j<M;j++){
                int x = sc.nextInt()-1;
                int y = sc.nextInt()-1;
                
                //1이면 흑돌 2이면 백돌
                int player = sc.nextInt();
                //자신이 놓을 돌과 자신의 돌 사이에 상대편의 돌이 있을경우??
                //1. 상하좌우대각선 상대편 돌이 있는지 확인-> 있으면 그방향으로 내돌있는지 확인
            
                if(player==1){
                    //흑인 경우
                    boolean isFind = false;
                    boolean rotate= false;
                    if(map[x][y]==0){
                        for(int k=0;k<8;k++){
                            int nx = x+dx[k];
                            int ny = y+dy[k];
                            isFind = false;
                            if(nx>=0 && nx<N && ny>=0 && ny<N){
                                if(map[nx][ny]==2){
                                    //백이 있으면
                                    //그 다음 흑인지 확인
                                    int s = 0;
                                    int next_x = nx+dx[k]*s;
                                    int next_y = ny+dy[k]*s;
                                    while(next_x>=0 && next_x<N && next_y>=0 && next_y<N){
                                        next_x = nx+dx[k]*s;
                                        next_y = ny+dy[k]*s;
                                        if(next_x<0 || next_x>=N || next_y<0 || next_y>=N) { s--; break;}
                                        if(map[next_x][next_y]==1){
                                            //흑을 만나면 거기까지 끝
                                            isFind = true;
                                            break;
                                        }
                                        else if(map[next_x][next_y]==0){
                                            //빈칸 만나면 끝
                                            s--;
                                            break;
                                        }  
                                        s++;
                                    }
                                    if(isFind==true){
                                        //바꿀 수 있으면
                                        map[x][y]=1;
                                        rotate = true;
                                        for(int check=0;check<=s;check++){
                                            map[nx+dx[k]*check][ny+dy[k]*check] =1;
                                        }
                                        //다 바꾸고 break
                                    }

                                }
                            }
                        }
                        if(rotate==false){
                            //못찾았는지는 다른 변수로 .............
                            //못찾으면 다른 player
                            for(int k=0;k<8;k++){
                                int nx = x+dx[k];
                                int ny = y+dy[k];
                                isFind = false;
                                if(nx>=0 && nx<N && ny>=0 && ny<N){
                                    if(map[nx][ny]==1){
                                        //백이 있으면
                                        //그 다음 흑인지 확인
                                        int s = 0;
                                        int next_x = nx+dx[k]*s;
                                        int next_y = ny+dy[k]*s;
                                        while(next_x>=0 && next_x<N && next_y>=0 && next_y<N){
                                            next_x = nx+dx[k]*s;
                                            next_y = ny+dy[k]*s;
                                            if(next_x<0 || next_x>=N || next_y<0 || next_y>=N) { s--; break;}
                                            if(map[next_x][next_y]==2){
                                                //흑을 만나면 거기까지 끝
                                                isFind = true;
                                                break;
                                            }
                                            else if(map[next_x][next_y]==0){
                                                //빈칸 만나면 끝
                                                s--;
                                                break;
                                            }  
                                            s++;
                                        }
                                        if(isFind==true){
                                            //바꿀 수 있으면
                                            map[x][y]=2;
                                            rotate = true;
                                            for(int check=0;check<=s;check++){
                                                map[nx+dx[k]*check][ny+dy[k]*check] =2;
                                            }
                                            //다 바꾸고 break
                                        }
    
                                    }
                                }
                            }
                        }
                    }
                    
                    //둘다 못놓으면 끝
                    if(rotate==false){
                        gameOver=true;
                    }
                }
                else{
                    boolean isFind = false;
                    boolean rotate= false;
                    if(map[x][y]==0){
                        for(int k=0;k<8;k++){
                            int nx = x+dx[k];
                            int ny = y+dy[k];
                            isFind = false;
                            if(nx>=0 && nx<N && ny>=0 && ny<N){
                                if(map[nx][ny]==1){
                                    //백이 있으면
                                    //그 다음 흑인지 확인
                                    int s = 0;
                                    int next_x = nx+dx[k]*s;
                                    int next_y = ny+dy[k]*s;
                                    while(next_x>=0 && next_x<N && next_y>=0 && next_y<N){
                                        next_x = nx+dx[k]*s;
                                        next_y = ny+dy[k]*s;
                                        if(next_x<0 || next_x>=N || next_y<0 || next_y>=N) { s--; break;}
                                        if(map[next_x][next_y]==2){
                                            //흑을 만나면 거기까지 끝
                                            isFind = true;
                                            break;
                                        }
                                        else if(map[next_x][next_y]==0){
                                            //빈칸 만나면 끝
                                            s--;
                                            break;
                                        }  
                                        s++;
                                    }
                                    if(isFind==true){
                                        //바꿀 수 있으면
                                        map[x][y]=2;
                                        rotate = true;
                                        for(int check=0;check<=s;check++){
                                            map[nx+dx[k]*check][ny+dy[k]*check] =2;
                                        }
                                        //다 바꾸고 break
                                    }

                                }
                            }
                        }
                        if(rotate==false){
                            //못찾았는지는 다른 변수로 .............
                            //못찾으면 다른 player
                            for(int k=0;k<8;k++){
                                int nx = x+dx[k];
                                int ny = y+dy[k];
                                isFind = false;
                                if(nx>=0 && nx<N && ny>=0 && ny<N){
                                    if(map[nx][ny]==2){
                                        //백이 있으면
                                        //그 다음 흑인지 확인
                                        int s = 0;
                                        int next_x = nx+dx[k]*s;
                                        int next_y = ny+dy[k]*s;
                                        while(next_x>=0 && next_x<N && next_y>=0 && next_y<N){
                                            next_x = nx+dx[k]*s;
                                            next_y = ny+dy[k]*s;
                                            if(next_x<0 || next_x>=N || next_y<0 || next_y>=N) { s--; break;}
                                            if(map[next_x][next_y]==1){
                                                //흑을 만나면 거기까지 끝
                                                isFind = true;
                                                break;
                                            }
                                            else if(map[next_x][next_y]==0){
                                                //빈칸 만나면 끝
                                                s--;
                                                break;
                                            }  
                                            s++;
                                        }
                                        if(isFind==true){
                                            //바꿀 수 있으면
                                            map[x][y]=1;
                                            rotate = true;
                                            for(int check=0;check<=s;check++){
                                                map[nx+dx[k]*check][ny+dy[k]*check] =1;
                                            }
                                            //다 바꾸고 break
                                        }
    
                                    }
                                }
                            }
                        }
                    }
                    
                    //둘다 못놓으면 끝
                    if(rotate==false){
                        gameOver=true;
                    }
                }
                // System.out.println(Arrays.deepToString(map));
                if(gameOver==true){
                    //2. 빈곳이 없으면 끝남
                    // 양 플레이어 모두 놓을 곳이 없으면끝남 
                    break;
                }
            }
            // System.out.printf("%d %d\n",black,white);
            //흑, 백 몇개인지 세기
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    if(map[i][j]==1){
                        black++;
                    }
                    else if(map[i][j]==2){
                        white++;
                    }
                }
            }
            System.out.printf("#%d %d %d\n",testcase,black,white);
        }
    }
}
