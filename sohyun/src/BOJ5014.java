import java.util.*;
import java.io.*;
public class BOJ5014 {

	static int[] map;
	static int F,S,G,U,D;
	static int[] dx;
	static int answer;
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		F = Integer.parseInt(st.nextToken());		//총수
		S = Integer.parseInt(st.nextToken())-1;		//현재위치
		G = Integer.parseInt(st.nextToken())-1;		//가야하는곳
		U = Integer.parseInt(st.nextToken());		//U층 위로
		D = Integer.parseInt(st.nextToken());		//D층 아래로
		dx =new int[] {U,-D};
		
		map = new int[F];
		Arrays.fill(map,-1);
		bfs(S);
		System.out.println((map[G]==-1)?"use the stairs":map[G] );
	}

	private static void dfs(int start) {
		if(start==G) {
			answer = Math.min(answer, map[start]);
			System.exit(0);
		}
		for(int i=0;i<2;i++) {
			int nx = start+dx[i];
			if(nx>=0 && nx<F && map[nx]==-1) {
				map[nx] = map[start]+1;
				dfs(nx);
			}
		}
		
	}
	
	private static void bfs(int start) {
		Queue<Integer> q = new LinkedList<>();
		map[start]=0;
		q.add(start);
		while(!q.isEmpty()) {
			int p = q.poll();
			for(int i=0;i<2;i++) {
				int nx = p+dx[i];
				if(nx>=0 && nx<F && map[nx]==-1) {
					map[nx] = map[p]+1;
					q.add(nx);
				}
			}
		}
	}

}
