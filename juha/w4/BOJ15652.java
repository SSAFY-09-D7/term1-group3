import java.util.Scanner;

public class BOJ15652 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		comb(n, new int[m], 0, 0);
	}

	private static void comb(int n, int[] sel, int current, int start) {
		if(current == sel.length) {
			for(int i = 0;i<sel.length;i++) {
				System.out.print(sel[i] + " ");
			}
			System.out.println();
		}else {
			for(int i = start; i<n;i++) {
				sel[current] = i+1;
				comb(n, sel, current+1, i);
			}
		}
	}

}
