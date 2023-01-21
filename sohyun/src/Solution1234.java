import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Solution1234 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("sohyun/input/input (33).txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 10; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int TC = Integer.parseInt(st.nextToken());
            String strOrigin = st.nextToken();
            String copyArr = strOrigin;
            // String[] origin = st.nextToken().split("");
            int isDup = duplicateIdx(strOrigin);
            while (isDup != -1) {
                copyArr = copyArr.substring(0, isDup)
                        .concat(copyArr.substring(isDup + 2, copyArr.length()));
                // System.out.println(copyArr);
                
                isDup = duplicateIdx(copyArr);

            }
            System.out.printf("#%d %s\n",i+1,copyArr);
        }

    }

    public static int duplicateIdx(String str)
    {
        int findIdx = -1;
        for(int idx=0;idx<str.length()-1;idx++)
        {
            if (str.charAt(idx) == str.charAt(idx+1)) {
                findIdx = idx;
                break;
            }
        }
        return findIdx;
    }
    
}
