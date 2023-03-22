package w05;

import java.io.*;
import java.util.regex.*;

class Main{
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("./inputs/input_BOJ3613.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int type = getType(str);
        String result = type == 1? toCpp(str) : type == 2 ? toJava(str) : "Error!";

        System.out.println(result);
    }
    
    private static int getType(String str) {
        if (str.matches(".*[A-Z].*") && str.matches(".*_.*")|| str.matches(".*(_){2,}.*|^([A-Z]|_).*|.*(_)$")||str.equals("")) return -1;
        if (str.contains("_")) return 1;
       else return 2;
    }

    private static String toCpp(String input) {
        String str = input;
        Matcher matcher = Pattern.compile("(?:_([a-z]))").matcher(str);
        while(matcher.find()) {
          str = str.replace(matcher.group(), matcher.group(1).toUpperCase());
        }

        return str;
    }

    private static String toJava(String input) {
        String str = input;
        Matcher matcher = Pattern.compile("([A-Z])").matcher(str);
        while(matcher.find()) {
          str = str.replace(matcher.group(), "_"+matcher.group().toLowerCase());
        }

        return str;
    }
}