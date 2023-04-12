
import java.util.*;

public class Main {
	int N;	// 건물의 층수
	int X[] = new int [100+10]; // 층별 공급지의 위치
	int Y[] = new int [100+10]; // 층별 소비지의 위치
	
	void InputData(){
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		for (int i = 0; i<N; i++){
			X[i] = sc.nextInt();
			Y[i] = sc.nextInt();
		}
		sc.close();
	}

	public static void main(String[] args){
		int ans = 1;
		Main m = new Main();

		m.InputData();	 //	입력 함수
		//	코드를 작성하세요
		for(int i=m.N; i>=1; i--) {
			boolean flag = false;
			for(int j=i-1; j>=0; j--){
				if((m.X[i] <= m.Y[j] && m.X[i] >= m.X[j]) || (m.Y[i] >= m.X[j] && m.Y[i] <= m.Y[j])){
					flag = true;
					break;
				}
			}
			if(!flag) ans++;
		}
		
		System.out.println(ans);//출력
	}
}
