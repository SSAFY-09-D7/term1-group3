import java.util.*;
import java.io.FileInputStream;

public class CropHarvest
{
	public static void main(String args[]) throws Exception
	{

		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
            int n;
            n = sc.nextInt();
            int[][] arr = new int[n][n];
            
            for(int i = 0;i<n;i++){
                String str;
                str = sc.next();
                for(int j = 0;j<n;j++){
                    arr[i][j] = str.charAt(j) - '0';
                }
            }
            int x = n/2;
            int sum = 0;
            for(int i = 0;i<=x;i++){
                for(int j = x-i;j>=0;j--){
                    if(i == 0){
                        if(j==0){ sum += arr[x][x];
                        }else{
                        sum += arr[x][x+j] + arr[x][x-j];
                        }
                    }else{
                        if(j==0){ sum += arr[x+i][x] + arr[x-i][x];
                        }else{
                        sum += arr[x-i][x+j] + arr[x-i][x-j] + arr[x+i][x+j] + arr[x+i][x-j];
                        }   
                    }
                }
            }
            System.out.println("#" + test_case + " " + sum);
		}
	}
}
