import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution7272 {
    static String[] strArr = {"CEFGHIJKLMNSTUVWXYZ ","ADOPQR","B"};

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("sohyun/input/s_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        for (int testcase = 1; testcase <= TC; testcase++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String firstStr = st.nextToken();
            String secondStr = st.nextToken();
            if (isHole(firstStr,secondStr))
                System.out.printf("#%d SAME\n", testcase);
            else
                System.out.printf("#%d DIFF\n", testcase);
        }
    }

    public static boolean isHole(String str1, String str2) {
        boolean same = true;
        if (str1.length() != str2.length()) {
            same = false;
        }
        else {
            for (int idx = 0; idx < str1.length(); idx++) {
                String first_c = str1.substring(idx, idx + 1);
                String second_c = str2.substring(idx, idx + 1);
                for (int n = 0; n < 3; n++) {
                    if (strArr[n].contains(first_c) != strArr[n].contains(second_c))
                    {
                        same = false;
                        break;
                    }
                }
            }
        }
        
        return same;
    }

}
