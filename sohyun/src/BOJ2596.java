import java.util.Arrays;
import java.util.Scanner;

public class BOJ2596 {

	public static void main(String[] args){
	
		//a b c d e f g h
		//한 문자마다 0 또는 1인 숫자 여섯개를 보낸다
		// 모든 문자 표현과 숫자 두 자 이상이 다른 경우 무슨 문자인지 알 수 없다
		Scanner sc = new Scanner(System.in);
		
		//A,B,C,D,E,F,G,H
		String[] dict = {"000000","001111","010011","011100","100110","101001","110101","111010"};
		
		int N = sc.nextInt();
		
		String s = sc.next();
		
		
		int[] answerArr = new int[N];
		int count = 0;
		
		boolean isFind = false;
		int wordCnt = 0;
		
		//숫자 한자만 다르고, 다른 문자들과는 각각 숫자 두 자 이상이 다르면 그 문자로 인식
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<s.length();i+=6) {
			
			isFind = false;
			
			//subs : 6개로 자르기
			String subs = s.substring(i, i+6);
			
			//몇번째 문자인지 확인
			wordCnt+=1;
			
			//다르다면 몇개 다른지 셀것
			int diff = 0;
			
			//같은 문자가 존재하면 계산할 필요 없이 answer에 저장 후 break
			for(int idx=0;idx<dict.length;idx++) {
				if(subs.equals(dict[idx])) {
					int a = (int)'A';
					sb.append((char)(idx+a));
					answerArr[count]=idx;
					isFind = true;
					count++;
					break;
				}
			}
			
			if(isFind) {
				continue;
			}
			else {
				char[] origin = subs.toCharArray();
				for(int idx=0;idx<dict.length;idx++) {
					diff = 0;
					char[] temp = dict[idx].toCharArray();
					for(int m=0;m<6;m++) {
						if(temp[m]!=origin[m]) {
							diff+=1;
						}
					}
					if(diff<2) {
						//만약, 2자 미만으로 다른 문자를 찾은 경우, 그 값을 append,
						int a = (int)'A';
						sb.append((char)(idx+a));
						
						isFind = true;
						break;
					}
					
				}
			}
			if(!isFind) {
				 System.out.println(wordCnt);
				 break;
			}
			
		}
		if(isFind) System.out.println(sb);
		
	}
	
}