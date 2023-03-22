package w02;

import java.util.regex.Pattern;
import java.util.*;
 
class Solution
{
    public static void main(String args[]) throws Exception
    {
        System.setIn(new FileInputStream("./inputs/input_SWEA1234.txt"));
        Scanner sc = new Scanner(System.in);
         
        for (int i = 1; i <= 10; i++) {
            sc.nextInt();
            String str = sc.next();
            Pattern pattern = Pattern.compile("(\\w)\\1");
 
            while (pattern.matcher(str).find()) {
                str = str.replaceAll("(\\w)\\1","");
            }
             
            System.out.println("#" + i + " " + str);
        }
    }
}