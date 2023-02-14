import java.util.*;
import java.io.*;

public class BOJ1700 {

    static int[] visited;
    static Stack<Integer> stack;
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] numArr = new int[K];
        visited = new int[101];
        stack = new Stack<>();
        st = new StringTokenizer(br.readLine());
        int count = 0;


        for(int j=0;j<K;j++){
            //몇번 방문해야 하는지 저장
            int number = Integer.parseInt(st.nextToken());
            numArr[j] = number;
            visited[number]+=1;
        }


        for(int i=0;i<K;i++){

            //스택이 꽉차서 빼야 할 때
            int number = numArr[i];
            if(stack.size()>=N){
                if(stack.contains(number)){
                    visited[number]-=1;
                    continue;
                }
                else{
                    int removeIdx = findIdx(visited, stack);
                    int top = stack.remove(removeIdx);
                    count++;
                    stack.push(number);
                    visited[number]-=1;
                }
            }
            else{
                //스택 꽉 안찼을 때
                if(stack.contains(number)){
                    visited[number]-=1;
                    continue;
                }
                else{
                    stack.push(number);
                    visited[number]-=1;
                }
                
            }

        }

        System.out.println(count);


    }
    private static int findIdx(int[] visited,Stack<Integer> stack){
        //stack에 있는 수중 제일 적게나오는애를 찾기
        int index = 0;
        int minNum = Integer.MAX_VALUE;
        for(int s=0;s<stack.size();s++){
            if(visited[stack.get(s)]<=minNum){
                minNum = visited[stack.get(s)];
                index = s;
            }
        }
        return index;
    }
}
