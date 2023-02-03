import java.util.*;

public class BOJ10163 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] cnt = new int[n];
		int[][] paper = new int[1001][1001];
		
		int[] max = new int[2];
		for(int i = 1;i<=n;i++) {
			int[] startEnd = new int[4];
			for(int j = 0;j<4;j++) {
				
				if(j>=2) {
					startEnd[j] = startEnd[j%2] + sc.nextInt()-1;
					max[j%2] = Math.max(max[j%2], startEnd[j]);
				}else {
					startEnd[j] = sc.nextInt();
				}
			}
			paper = attachPaper(paper, startEnd, i);
		}
		
		for(int i =0;i<=max[0];i++) {
			for(int j = 0;j<=max[1];j++) {
				if(paper[i][j]!=0) {
					cnt[paper[i][j]-1]++;
				}		
			}
		}
		for(int i = 0;i<n;i++) {
			System.out.println(cnt[i]);
		}
	}
	
	public static int[][] attachPaper(int[][] paper, int[] startEnd, int n){
		for(int i = startEnd[0];i<=startEnd[2];i++) {
			for(int j = startEnd[1];j<=startEnd[3];j++) {
				paper[i][j] = n;
			}
		}
		return paper;
	}

}
