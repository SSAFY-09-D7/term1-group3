import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ17413 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        char[] charArr = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        int idx = 0;
        String temp = "";
        while (idx<charArr.length) 
        {
            if (charArr[idx] == '<') {
                if (temp.length() > 0) {
                    for (int sdx = temp.length() - 1; sdx >= 0; sdx--) {
                        sb.append(temp.charAt(sdx));
                    }
                }
                temp = "";
                while (charArr[idx] != '>') {
                    sb.append(charArr[idx]);
                    idx++;
                }
                if (charArr[idx] == '>') {
                    sb.append(charArr[idx]);
                }
            } else if (charArr[idx] == ' ') {
                if (temp.length() > 0) {
                    for (int sdx = temp.length() - 1; sdx >= 0; sdx--) {
                        sb.append(temp.charAt(sdx));
                    }
                }
                sb.append(" ");
                temp = "";
            } else {
                temp += charArr[idx];
            }
            idx++;
        }
        if (temp.length() != 0) {
            for (int sdx = temp.length() - 1; sdx >= 0; sdx--) {
                sb.append(temp.charAt(sdx));
            }
        }
        System.out.println(sb);
        
    }
}