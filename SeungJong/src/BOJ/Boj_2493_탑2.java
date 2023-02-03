package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Boj_2493_탑2 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int idx = 0;
		Stack<Top> stack = new Stack<Top>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			Top t = new Top(Integer.parseInt(st.nextToken()), idx++);
			while(!stack.isEmpty()) {
				if(stack.peek().height < t.height) {
					stack.pop();				
				} else {
					sb.append(stack.peek().idx+1+" ");
					break;
				}
			}
			if(stack.empty()) sb.append("0 ");
			stack.push(t);
		}
		System.out.println(sb);
	}
}

class Top{
	public int height;
	public int idx;
	public Top(int h, int i){
		this.height = h;
		this.idx = i;
	}
	
}
