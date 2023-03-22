package w05;

import java.io.*;
import java.util.*;

// BOJ 2011 암호코드 #210
class Main {
    public static void main(String[] arg) throws Exception {
        System.setIn(new FileInputStream("./inputs/input_BOJ2011.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] code = br.readLine().toCharArray();
        int[] dp = new int[code.length + 1];
        int mod = 1_000_000;
        boolean isPossible = true;

        if (code.length == 0 || code[0] == '0')
            isPossible = false;
        else {
            dp[0] = 1;
            dp[1] = code[1] == 0 ? 1 : isLetter(code[0], code[1]) ? 2 : 1;
            for (int i = 1; i < code.length; i++) {
                if (code[i + 1] == '0' && code[i] > '2') {
                    isPossible = false;
                    break;
                }

                if (i < code.length - 1 && code[i + 1] == '0') {
                    dp[i] = dp[i - 1];
                    dp[i + 1] = dp[i];
                    i++;

                    if (i <= code.length - 2) {
                        dp[i + 1] = dp[i - 1];
                        i++;
                    }

                } else if (i > 1)
                    dp[i] = isLetter(code[i - 1], code[i]) ? (dp[i - 1] + dp[i - 2]) % mod : dp[i - 1];
            }
        }

        for (int i = 0; i < code.length; i++) {
            System.out.println(i + ": " + (char) code[i] + " ---> dp: " + dp[i]);
        }

        System.out.println(isPossible ? dp[code.length - 1] : 0);
    }

    private static boolean isLetter(char a, char b) {
        if (a == '0')
            return false;
        int num = (a - '0') * 10 + (b - '0');
        if (num > 0 && num <= 26)
            return true;
        return false;
    }
}
