import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Maze {
	static int T, N, X, Y, JumpCount, MoveCount;
	static int[] JumpX;
	static int[] JumpY;
	static int[][] arr;
	static int[] Dir;
	static int[] MoveLength;
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("./input/input_maze.txt"));
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			X = sc.nextInt()-1;
			Y = sc.nextInt()-1;
			JumpCount = sc.nextInt();
			arr = new int[N][N];
			JumpX = new int[JumpCount];
			JumpY = new int[JumpCount];
			for (int i = 0; i < JumpCount; i++) {
				JumpX[i] = sc.nextInt()-1;
				JumpY[i] = sc.nextInt()-1;
				arr[JumpX[i]][JumpY[i]] = -1;
			}
			MoveCount = sc.nextInt();
			Dir = new int[MoveCount];
			MoveLength = new int[MoveCount];
			for (int i = 0; i < MoveCount; i++) {
				Dir[i] = sc.nextInt();
				MoveLength[i] = sc.nextInt();
				if( X < 0 || X >= N || Y < 0 || Y >= N) break;
				switch(Dir[i]) {
				case 1:
					for (int j = 0; j < MoveLength[i]; j++) {
						X -= 1;
						if(X < 0 || arr[X][Y] == -1) {
							X = -1;
							break;
						}
					}
					break;
				case 2:
					for (int j = 0; j < MoveLength[i]; j++) {
						Y += 1;
						if(Y >= N || arr[X][Y] == -1) {
							Y = -1;
							break;
						}
					}
					break;
				case 3:
					for (int j = 0; j < MoveLength[i]; j++) {
						X += 1;
						if(X >= N || arr[X][Y] == -1) {
							X = -1;
							break;
						}
					}
					break;
				case 4:
					for (int j = 0; j < MoveLength[i]; j++) {
						Y -= 1;
						if(Y < 0 || arr[X][Y] == -1) {
							Y = -1;
							break;
						}
					}
					break;
				}
			}
			if(X < 0 || Y < 0) {
				X = -1;
				Y = -1;
			}
			System.out.println("#"+tc+" "+(X+1)+" "+(Y+1));
			
		}
		sc.close();
	}

}
