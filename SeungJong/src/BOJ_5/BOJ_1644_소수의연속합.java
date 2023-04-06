package BOJ.BOJ5;

import java.util.*;
import java.io.*;

public class BOJ_1644_소수의연속합 {
	static boolean prime[] = new boolean[4000001];
	static ArrayList<Integer> prime_numbers = new ArrayList<>();
    static int Num, Ans;
    public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Num = Integer.parseInt(br.readLine());
        prime[0] = prime[1] = true;
        
        for(int i=2; i*i<=Num; i++){
        	// prime[i]가 소수라면
            if(!prime[i]){
            	// prime[j] 소수가 아닌 표시
            	for(int j=i*i; j<=Num; j+=i) prime[j]=true;                
            }        
        }    
        
        // 소수 출력
        for(int i=1; i<=Num;i++){
        	if(!prime[i]) prime_numbers.add(i);     
        }
        int start = 0, end = 0;
        for (int i = 0; i < prime_numbers.size(); i++) {
			start = prime_numbers.get(i);
			if(start == Num)  {
				Ans++;
				break;
			}
			int sum = start;
			for (int j = i; j < prime_numbers.size(); j++) {
				if(i==j) continue;
				end = prime_numbers.get(j);
				sum += end;
				if(sum == Num) {
					Ans++;
					break;
				}
				else if(sum > Num) break;
			}
		}
        System.out.println(Ans);
    }
}