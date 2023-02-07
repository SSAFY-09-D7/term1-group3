import java.util.*;

public class BOJ2798 {
	static List<Integer> list = new ArrayList<Integer>();
	static int[] temp = new int[3];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int[] cardDeck = new int[n];
		for(int i = 0;i<n;i++) {
			cardDeck[i] = sc.nextInt();
		}
		makeCombination(m, 0, 0, cardDeck);
		Collections.sort(list);
		System.out.println(list.get(list.size()-1));
	}
	
	public static void makeCombination(int m, int current, int start, int[] cardDeck) {
		if(3==current) {
			int sum = 0;
			for(int i = 0;i<3;i++) {
				sum += temp[i];
			}
			if(sum <= m) list.add(sum);
		}else {
			for(int i = start; i<cardDeck.length;i++) {
				temp[current] = cardDeck[i];
				makeCombination(m, current + 1, i+1, cardDeck);
			}
		}
	}

}
