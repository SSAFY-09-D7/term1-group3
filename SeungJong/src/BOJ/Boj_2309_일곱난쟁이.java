package BOJ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Boj_2309_일곱난쟁이 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int[] arr = new int[9];
		List<Integer> arrList;
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		arrList = findList(arr);
		for (Integer integer : arrList) {
			bw.write(integer+"\n");
			bw.flush();
		}
	}

	public static ArrayList<Integer> findList(int[] arr) throws IOException {
		ArrayList<Integer> arrList = new ArrayList<>();
		for (int i = 1; i < (1 << 9); i++) {
			arrList.clear();
			for (int j = 0; j < 9; j++) {
				int bol = i & (1<<j);
				if(bol > 0) {
					arrList.add(arr[j]);
					if(arrList.size()==7 && arrList.stream().reduce(0, Integer::sum)==100) {
						Collections.sort(arrList);
						return arrList;
					}
				}
			}
		}
		return null;
	}

}
