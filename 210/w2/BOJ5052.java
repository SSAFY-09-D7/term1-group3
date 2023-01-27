package w2;

import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("./inputs/input_BOJ5052.txt"));
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int t = 0; t < T; t++) {
            int cnt = sc.nextInt();
            HashSet<String> phones = new HashSet<>();
            HashSet<Integer> sizes = new HashSet<>();
            String[] ps = new String[cnt];
            String result = "YES";

            for (int i = 0; i < cnt; i++) {
                String str = sc.next();
                phones.add(str);
                ps[i] = str;
                sizes.add(str.length());
            }

            for (String p : ps) {
                for (Integer s : sizes) {
                    if (!isRelated(p, s, phones)) {
                        result = "NO";
                        break;
                    }
                }
            }

            System.out.println(result);
        }

        sc.close();
    }

    private static boolean isRelated(String p, Integer s, HashSet<String> phones) {
        if (s >= p.length())
            return true;
        String currStr = p.substring(0, s);
        phones.remove(p);
        if (phones.contains(currStr)) {
            phones.add(p);
            return false;
        }
        phones.add(p);
        return true;
    }
}