import java.util.*;
import java.io.*;

public class Main3 {
    static int N, half;
    static int[][] board;
    static int[][] labels;
    static int[][] ds = {{1,0}, {0,-1}, {-1,0}, {0,1}};
    static int[][] sds = {{1,0}, {0,1}, {-1,0}, {0,-1}};
    public static void main(String[] args) throws Exception {
    	System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        half = N/2;
        board = new int[N][N];
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = getScore();
        printLabel();
        for (int i = 0; i < 0; i++) {
            rotate();
          //  print();
            result += getScore();
        }

        System.out.println(result);
    }

    private static int getScore() {
        // 방문 안했으면
        labels = new int[N][N];
        List<Integer> cnts = new ArrayList<>();
        cnts.add(0);
        List<Integer> vals = new ArrayList<>();
        vals.add(0);
        int labelNum = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (labels[i][j] == 0) {
                    vals.add(board[i][j]);
                    cnts.add(addLabel(i, j, labelNum++));
                }
            }
        }

        int nearCnts[][] = new int[labelNum][labelNum];

        // label을 돌면서 맞닿아 있는 곳 표시
         for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i < N-1 && labels[i][j] != labels[i+1][j]) {
                    nearCnts[labels[i][j]][labels[i+1][j]]++;
                    nearCnts[labels[i+1][j]][labels[i][j]]++;
                }

                if (j < N-1 && labels[i][j] != labels[i][j+1])  {
                    nearCnts[labels[i][j]][labels[i][j+1]]++;
                    nearCnts[labels[i][j+1]][labels[i][j]]++;
                }
            }
        }

        int sum = 0;

        // 이중 반복문으로 모든 조합 계산하기
        for (int i = 1; i < labelNum; i++) {
            for (int j = i+1; j < labelNum; j++) {
            	System.out.println(i + "," + j + " -> " +cnts.get(i) + " " + cnts.get(j)  + " " + vals.get(i) + " " + vals.get(j) + " " + nearCnts[i][j]);
                sum += (cnts.get(i) + cnts.get(j)) * vals.get(i) * vals.get(j) * nearCnts[i][j];
            }
        }

        return sum;
    }

    private static int addLabel(int startR, int startC, int labelIdx) {
        int cnt = 0;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{startR, startC});
        labels[startR][startC] = labelIdx;
        int target = board[startR][startC];

        while(!q.isEmpty()) {
            int[] curr = q.poll();
            cnt++;

            for (int i = 0; i < 4; i++) {
                int nr = curr[0] + ds[i][0];
                int nc = curr[1] + ds[i][1];

                if (nr < 0 || nr >= N || nc < 0 || nc >= N || labels[nr][nc] != 0 || board[nr][nc] != target) continue;

                labels[nr][nc] = labelIdx;
                q.add(new int[]{nr, nc});
            }
        }
        return cnt;
    }

    private static void rotate() {
        rotateCore();
        rotateSide(0, 0);
        rotateSide(0, half + 1);
        rotateSide(half+1, 0);
        rotateSide(half+1, half+1);
    }
    
    private static void rotateCore() {
        Queue<Integer> q = new LinkedList<>();
        int[][] edges = {{0, half}, {half, N-1}, {N-1, half}, {half, 0}};

        // 모든 요소들 넣기
        for (int i = 0; i < 4; i++) {
            int nr = edges[i][0];
            int nc = edges[i][1];
            
            for (int j = 0; j < half; j++) {
                q.add(board[nr][nc]);
                nr += ds[i][0];
                nc += ds[i][1];
            }
        }

        for (int i = 0; i < 4; i++) {
            int ii = (i - 1 + 4) % 4;
            int nr = edges[ii][0];
            int nc = edges[ii][1];
            
            for (int j = 0; j < half; j++) {
                board[nr][nc] = q.poll();
                nr += ds[ii][0];
                nc += ds[ii][1];
            }
        }

    }

    private static void rotateSide(int startR, int startC) {
        // static int[][] ds = {{1,0}, {0,-1}, {-1,0}, {1,0}};
        for (int layer = 0; layer < half/2; layer++) {
            int tmp = board[startR + layer][startC + layer];
            int nr = startR + layer;
            int nc = startC + layer;
            for (int d = 0; d < 4; d++) {
                for (int i = 0; i < half - 1 - (layer*2); i++) {
                	// System.out.print(nr + "," + nc + "<-" + (nr + sds[d][0]) + "," + (nc + sds[d][1]) + "   ");
                    board[nr][nc] = board[nr + sds[d][0]][nc + sds[d][1]];
                    nr += sds[d][0];
                    nc += sds[d][1];
                }
               // System.out.println();
            }
            board[startR + layer][startC + layer + 1] = tmp;
        }        
    }

    private static void print() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) 
                System.out.print(board[i][j] + "\t");
            System.out.println();
        }
        System.out.println();
    }
    
    private static void printLabel() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) 
                System.out.print(labels[i][j] + "\t");
            System.out.println();
        }
        System.out.println();
    }
}
