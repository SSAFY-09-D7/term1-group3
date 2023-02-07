import java.util.*;

public class BOJ2581 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		
		int sum = 0;
		List<Integer> list = new ArrayList<Integer>();
		for(int i = m;i<=n;i++) {
			int a = findPri(i);
			if(a!=0) list.add(a);
			sum += a;
		}
		if(sum!=0) {
		Collections.sort(list);
		System.out.println(sum);
		System.out.println(list.get(0));}
		else System.out.println("-1");
	}
	
	public static int findPri(int n) {
		for(int i = 1;i*i<=n;i++) {
			if(i*i==n) return 0;
			if(n%i==0 && i!=1) return 0;
		}
		
		return n;
	}

}
