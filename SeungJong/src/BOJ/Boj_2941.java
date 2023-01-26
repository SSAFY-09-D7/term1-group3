package BOJ;

import java.util.Scanner;

public class Boj_2941 {

	static String[] str = {"c=", "c-", "dz=","d-", "lj", "nj", "s=", "z="};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String inputStr = sc.next();
		int count = Search(inputStr);
		System.out.println(count);
		sc.close();
	}
	private static int Search(String inputStr) {
		for (int i = 0; i < str.length; i++) {
			inputStr = inputStr.replace(str[i], "1");
		}
		return inputStr.length();
	}

}
