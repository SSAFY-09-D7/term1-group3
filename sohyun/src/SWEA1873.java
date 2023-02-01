import java.util.*;
import java.io.*;
public class SWEA1873 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        for(int testcase=1;testcase<=T;testcase++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int H = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            char[][] str = new char[H][W];

            //H개 줄에 W개 문자열
            for(int h=0;h<H;h++){
                String s= br.readLine();
                for(int w=0;w<W;w++){
                    str[h][w] = s.charAt(w);
                }
            }
            int N = Integer.parseInt(br.readLine());
            String input = br.readLine();
            //input : U,D,L,R,S
        }
    }
}
