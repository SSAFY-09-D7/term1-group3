import java.util.*;
import java.io.*;

public class BOJ16562 {
    static int N;
    static int M;
    static long k;
    static int[] parents;
    static int[] money;
    static int answer;
    public static void main(String[] args)throws Exception {
        //같은 그룹이면 돈 한번만 내면됨(적은돈으로)
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        money = new int[N+1];
        st= new StringTokenizer(br.readLine());

        answer = 0;

        //make set
        parents= new int[N+1];
        
        for(int i=1;i<=N;i++){
            money[i] = Integer.parseInt(st.nextToken()); 
            parents[i] = i;
        }

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            
            union(s,e);
            
        }

        Set<Integer> set = new HashSet<Integer>();
        for(int i=1;i<=N;i++){
            set.add(parents[i]);
        }
        // System.out.println(set);

        Iterator iter = set.iterator();
        while(iter.hasNext()){
            int minV = Integer.MAX_VALUE;
            int nowP = (int)iter.next();

            for(int j=1;j<=N;j++){
                if(parents[j]==nowP){
                    minV = Math.min(minV,money[j]);
                }
            }
            
            answer+=minV;
        }
            

        if(answer>k) System.out.println("Oh no");
        else System.out.println(answer);
        
    }
    private static void union(int s, int e) {
        int ps = find(s);
        int pe = find(e);
        if(ps!=pe) {
            parents[ps] = pe;
        }
    }
    private static int find(int s){
        if(parents[s] == s) return s;
        else return parents[s] = find(parents[s]);
    }
}
