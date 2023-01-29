package BOJ;

import java.util.Scanner;

public class Boj_17413 {
	static char[] arrChar;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		arrChar = new char[str.length()];
		for (int i = 0; i < str.length(); i++) {
			arrChar[i] = str.charAt(i);
		}
		String ans = "";
		String temp = "";
		for (int i = 0; i < arrChar.length; i++) {
			if(arrChar[i] == '<') {
				while(true) {
					ans += arrChar[i];
					i += 1;
					if(arrChar[i] == '>') {
						ans += arrChar[i];
						break;
					}
				}
			}
			else if(arrChar[i] == ' ') {
				ans += " ";
			}
			else {
				temp += arrChar[i];
				if(i+1 >= arrChar.length || arrChar[i+1] == ' ' || arrChar[i+1] == '<') {
					StringBuffer sbr = new StringBuffer(temp);
					ans += sbr.reverse();
					temp = "";
				}
				
			}
		}
		System.out.println(ans);
		sc.close();
	}
}