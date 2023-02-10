import java.io.*;
import java.util.*;
public class BOJ14719 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());   //세로
        int W = Integer.parseInt(st.nextToken());   //가로
        st = new StringTokenizer(br.readLine());
        int answer =0 ;

        //W개 주어짖ㅁ
        int[][] map = new int[H][W];
        for(int i=0;i<W;i++){
            int r = Integer.parseInt(st.nextToken());
            for(int k=0;k<r;k++)
                map[k][i]=1;
        }
        //map을 돌면서 각 행에서 1을 만나면 cnt ++
        //만약에 1이 또 없이 끝나면 cnt한거 0ㅇ로ㅓ 
        //answer+=cnt;
        for(int l=0;l<H;l++){
            List<Integer> oneMap = new ArrayList<>();
            for(int k=0;k<W;k++){
                if(map[l][k]==1){
                    oneMap.add(k);
                }
            }
            // System.out.println(oneMap);
            for(int idx=0;idx<oneMap.size()-1;idx++){
                int sub = oneMap.get(idx+1)-oneMap.get(idx)-1;
                answer+=sub;
            }
            
        }
        System.out.println(answer);
    }
}
