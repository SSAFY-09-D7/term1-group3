import java.util.*;

public class BOJ14888 {
	static char[] sign = {'+','-','*','/'};
	static List<Integer> list = new ArrayList<Integer>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] num = new int[n];
		
		char[] signArray = new char[n-1];
		for(int i = 0;i<n;i++) {
			num[i] = sc.nextInt();
		}
		
		int cnt = 0;
		for(int i = 0;i < 4;i++) {
			int temp = sc.nextInt();
			for (int j = 0;j<temp;j++) {
				signArray[cnt++] = sign[i]; 
			}
		}
		
		perm(num, signArray, new char[n-1], 0, new boolean[n-1]);
		Collections.sort(list);
		
		System.out.println(list.get(list.size()-1));
		System.out.println(list.get(0));
		
		list.clear();
	}
	
	
	private static void perm(int[] num, char[] signArray, char[] sel, int idx, boolean[] v) {	
		// basis part
		if(idx == sel.length) {
			int x = num[0];
			for(int i = 0;i<sel.length;i++) {
				switch(sel[i]) {
				case '+':
					x += num[i+1];
					break;
				case '*':
					x *= num[i+1];
					break;
				case '-':
					x -= num[i+1];
					break;
				case '/':
					x /= num[i+1];
					break;
				}
			}
			
			list.add(x);
			return;
		}		
		
		// indcutive part
		for(int i = 0;i<signArray.length;i++) {
			if(v[i] == false) {
				v[i] = true;
				sel[idx] = signArray[i];
				perm(num, signArray, sel, idx+1, v);
				v[i] = false;
			}
		}
	}

}
