import java.util.*;
import java.io.*;
public  class BOJ16206 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        // 롤케이크 개수
        int N = Integer.parseInt(st.nextToken());
        //최대 M번 자를 수 있다.
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        List<Integer> roll = new ArrayList<>();

        //rollcake 길이가 10의 배수인 경우 따로 담아줄 배열
        List<Integer> roll2 = new ArrayList<>();
        
        //케이크 값 넣기
        while (st.hasMoreTokens()) {
            int cake = Integer.parseInt(st.nextToken());
            if(cake%10==0) roll2.add(cake);
            else roll.add(cake);
        }

        //10의 배수일 경우 작은것부터 고려해야됨 -> 오름차순 정렬
        Collections.sort(roll2);


        int cut = 0;            //자르는 횟수
        int rollCnt = 0;       //조각 갯수
        int result = 0;

        //1. 10의 배수인 경우에 대해서 cut
        for(int cake : roll2){
            //최대 횟수 다 자르면 break
            if(M<=0) break;
            rollCnt = cake/10;
            cut = rollCnt-1;

            if(M<cut){
                //자른 수가 최대횟수보다 많아지면 
                //최대횟수로 돌려놓고 조각갯수도 최대횟수로 돌림
                cut = M;
                rollCnt = cut;
              
            }

            M-=cut;
            result+=rollCnt;
        }

        //2. 10의 배수 아닌 경우
        for(int cake:roll){
            if(M<=0) break;
            rollCnt = cake/10;
            cut = rollCnt;

            if(M<cut){
                cut = M;
                rollCnt = cut;
            }
            M-=cut;
            result+=rollCnt;
        }
        System.out.println(result);
    }
}