import java.util.*;
import java.io.*;
public class BOJ2693 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());

        //3번째 큰 값 출력
        for(int i=0;i<T;i++){
            st = new StringTokenizer(br.readLine());
            ArrayList<Integer> arr = new ArrayList<>();
            while (st.hasMoreTokens()) {
                arr.add(Integer.parseInt(st.nextToken()));
            }
            
            Collections.sort(arr);
            System.out.println(arr.get(arr.size()-3));
        }

    }
}
