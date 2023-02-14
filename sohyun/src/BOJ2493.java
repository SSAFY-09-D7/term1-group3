import java.util.*;

import java.io.*;

public class BOJ2493 {
    public static void main(String[] args)throws Exception {
       
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<Integer>();
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int cnt = 0;

        for(int idx=1;idx<=N;idx++){
            cnt = 0;
            int number  = Integer.parseInt(st.nextToken());
            if(stack.isEmpty()){
                sb.append(0).append(" ");
                stack.push(number);
            }
            else{
                if(stack.peek()<=number){
                    //큰 수 찾을 때 까지
                    while(!stack.isEmpty()){
                        if(stack.peek()>=number){
                            cnt++;
                            break;
                        }
                        else{
                            stack.pop();
                            cnt++;
                        }
                        
                    }
                    // if(stack.isEmpty()){
                    //     sb.append(0).append(" ");
                    // }
                    // else{
                    //     sb.append(idx-cnt).append(" ");
                    // }
                    sb.append(stack.size()).append(" ");
                    stack.push(number);
                    // cnt=idx;
                    
                }
                else{
                    
                    sb.append(idx-1).append(" ");
                    stack.push(number);
                    
                }
                System.out.println(stack);
            }
            
        }
        System.out.println(sb.toString().trim());
    }
}
