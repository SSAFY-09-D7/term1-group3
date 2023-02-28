import java.util.*;
import java.io.*;
public class BOJ2606 {
    static int[] parents;
    static int cnt;

    public static void main(String[] args)throws Exception {
        //1번 컴퓨터 기준
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        parents= new int[N+1];
        for(int i=0;i<N+1;i++){
            parents[i] = i;
        }
        for(int i=0;i<M;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            union(s,e);
        }
        // System.out.println(Arrays.toString(parents));
        for(int i=0;i<N+1;i++){
            if(find(i)==find(1)) cnt++;
        }
        System.out.println(cnt-1);

    }
    private static void union(int s, int e){
        int ps = find(s);
        int pe=find(e);
        if(ps!=pe){
            parents[ps] = pe;
        } 
    }
    private static int find(int a){
        if(parents[a]==a) return a;
        else return parents[a] = find(parents[a]);
    }
}
