import java.util.*;

public class BOJ2999 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		
		int r=0, c=0;
		for(int i = 1;i*i<=s.length();i++) {
			if(i*i == s.length()) {
				r = i; c = i;
				break;
			}
			if(s.length()%i==0) {
				r = Math.min(i, s.length()/i);
				c = Math.max(i, s.length()/i);
			}
		}
		
		char[][] answer = new char[r][c];
		int index = 0;
		for(int i = 0;i<c;i++) {
			for(int j = 0;j<r;j++) {
				answer[j][i] = s.charAt(index++);
			}
		}
		
		for(int i = 0;i<r;i++) {
			for(int j = 0;j<c;j++) {
				System.out.print(answer[i][j]);
			}
		}
		System.out.println();
		
	}

}
