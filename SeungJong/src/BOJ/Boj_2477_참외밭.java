package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj_2477_참외밭 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());
		ArrayList<Integer> list = new ArrayList<>();
		String str = "";
		int[] dir = new int[6];
		int[] size = new int[6];
		int bigSquare = 0;
		int smallSquare = 0;
		for(int i=0; i<6; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			dir[i] = Integer.parseInt(st.nextToken());
			size[i] = Integer.parseInt(st.nextToken());
			str += dir[i];
		}
		list = findDuplicate(dir, str);
		bigSquare = size[list.get(0)] * size[list.get(1)];
//		System.out.println(bigSquare);
		int smallIndex1 = (list.get(0) + 3) % 6;
		int smallIndex2 = (list.get(1) + 3) % 6;
//		System.out.println(smallIndex1+" "+smallIndex2);
		smallSquare = size[smallIndex1] * size[smallIndex2];
		System.out.println((bigSquare - smallSquare)*K);
		// 중복 아닌 인덱스를 찾는다 -> 전체 크기
		// 해당 인덱스에서 다음 다음 인덱스와 다음 인덱스가 작은 크기
		
	}

	private static ArrayList<Integer> findDuplicate(int[] dir, String str) {
		String ans = "";
		ArrayList<Integer> index = new ArrayList<>();
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < str.length(); i++) {
			if(ans.contains(str.substring(i,  i+1)) == false) {
				ans += str.substring(i,  i+1);
				list.add(i);
			}
			else {
				index.add(str.indexOf(str.substring(i,  i+1)));
			}
		}
		for (int i = 0; i < index.size(); i++) {
			list.remove(index.get(i));
		}
		return list;
	}

}
