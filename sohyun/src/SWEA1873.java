import java.util.*;
import java.io.*;

public class SWEA1873 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int testcase = 1; testcase <= T; testcase++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int H = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            char[][] str = new char[H][W];

            for (int h = 0; h < H; h++) {
                String s = br.readLine();
                for (int w = 0; w < W; w++) {
                    str[h][w] = s.charAt(w);
                }
            }

            int N = Integer.parseInt(br.readLine());
            String input = br.readLine();

            //input : U,D,L,R,S
            for (int idx = 0; idx < input.length(); idx++) {
                char c = input.charAt(idx);
                //start (전차 찾기)
                int[][] start = findStart(str, H, W);
                str = changeMap(start, c, str, H, W);
            }

            System.out.printf("#%d %s", testcase, answerString(str,H,W));
        }
    }

    private static String answerString(char[][] str,int H, int W) {
        String answer = "";
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                answer += str[i][j] + "";
            }
            answer += "\n";
        }
        return answer;
    }
    private static char[][] changeMap(int[][] start, char c, char[][] map, int H, int W) {
        // 명령어가 무엇인지 파악
        int x = start[0][0];
        int y = start[0][1];
        switch (c) {
            
            case 'U':
                map[x][y] = '^';
                if (x - 1 >= 0 && map[x-1][y]=='.') {
                    map[x][y] = '.';
                    map[x - 1][y] = '^';
                }
                break;
            case 'D':
                map[x][y] = 'v';
                if (x + 1 < H && map[x+1][y]=='.') {
                    map[x][y] = '.';
                    map[x + 1][y] = 'v';
                }
                break;
            case 'L':
                map[x][y] = '<';
                if (y - 1 >= 0 && map[x][y-1]=='.') {
                    map[x][y] = '.';
                    map[x][y - 1] = '<';
                }
                break;
            case 'R':
                map[x][y] = '>';
                if (y + 1 < W && map[x][y+1]=='.') {
                    map[x][y] = '.';
                    map[x][y + 1] = '>';
                }
                break;
            case 'S':
                map = shooting(start, map, H, W);
                break;
        }
        return map;
    }
    
    private static char[][] shooting(int[][] start, char[][] map, int H, int W) {
        int x = start[0][0];
        int y = start[0][1];
        char c = map[x][y];
        switch (c) {
            case '>':
                map = checkWall(map, x, y, 0, 1,H,W);
                break;
            case '<':
                map = checkWall(map, x, y, 0, -1,H,W);
                break;
            case '^':
                map = checkWall(map, x, y, -1, 0,H,W);
                break;
            case 'v':
                map = checkWall(map, x, y, 1, 0,H,W);
                break;
        }
        return map;
    }

    private static char[][] checkWall(char[][] map, int x, int y, int dx, int dy,int H, int W) {
        int nx = x + dx;
        int ny = y + dy;
        if (nx >= 0 && nx < H && ny >= 0 && ny < W) {
            char next = map[nx][ny];
            if (next == '*') {
                map[nx][ny] = '.';
            } else if (next == '.' || next == '-') {
                int cnt = 1;
                while (true) {
                    nx = x + dx * cnt;
                    ny = y + dy * cnt;
                    if (nx < 0 || nx >= H || ny < 0 || ny >= W)
                        break;
                    if (map[nx][ny] == '#')
                        break;
                    else if (map[nx][ny] == '*') {
                        map[nx][ny] = '.';
                        break;
                    }
                    cnt++;
                }
            }
        }

        return map;
    }
    
    private static int[][] findStart(char[][] str, int H, int W) {
        int[][] start = new int[1][2];
        for (int h = 0; h < H; h++) {
            for (int w = 0; w < W; w++) {
                if (str[h][w]=='>' || str[h][w]=='<'
                        || str[h][w]=='^'
                        || str[h][w] == 'v') {
                    start[0][0] = h;
                    start[0][1] = w;
                    break;
                }
            }
        }
        return start;
    }
}
