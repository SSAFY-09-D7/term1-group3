import java.util.*;
import java.io.FileInputStream;
import java.lang.*;

public class Password
{
	public static void main(String args[]) throws Exception
	{

		Scanner sc = new Scanner(System.in);
		int T = 10;

		for(int test_case = 1; test_case <= T; test_case++)
		{
            int n;
            n = sc.nextInt();
            ArrayList<Integer> password = new ArrayList<Integer>();
            //int[] password = new int[n];
            String str;
            str = sc.next();
            for(int i = 0;i<n;i++){
               password.add(str.charAt(i) - '0');
            }
            int check = 0;
            while(check == 0){
                for(int j = 0;j<password.size()-1;j++){
                    if(password.get(j) == password.get(j+1)){
                        password.remove(j+1);
                        password.remove(j);
                        break;
                    }else{
                        if(j==password.size()-2) check = 1;
                    }
                }
            }
            
            System.out.print("#" + test_case + " ");
            for(int i = 0;i<password.size();i++){
                System.out.print(password.get(i));
            }
            System.out.println();
		}
	}
}
