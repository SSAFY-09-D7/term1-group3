import java.util.*;
import java.lang.*;

public class NoGlasses
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
        String[] ans = {"DIFF", "SAME"};
        char[] alph = {'A', 'D', 'O', 'P', 'Q', 'R'};
        int[] alp = new int[26];
        alp[1] = 2;
        for(int i = 0;i<6;i++){
            alp[(int)(alph[i])-65] = 1;}
        
 		for(int test_case = 1; test_case <= T; test_case++)
		{
            String[] arr = new String[2];
            int check = 1;
            for(int i = 0;i<2;i++){
                arr[i] = sc.next();
            }
            
            if(arr[0].length() != arr[1].length()){
                check = 0;
            }else{
                for(int i =0; i< arr[0].length();i++){
                    if(alp[(int)(arr[0].charAt(i)) - 65] != alp[(int)(arr[1].charAt(i)) - 65]){
                        check = 0;
                        break;
                    }
                }
            }
            
            System.out.println("#" + test_case + " " + ans[check]);
		}
	}
}
