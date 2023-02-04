import java.io.*;

import java.util.*;
public class BOJ2941 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        System.out.println(findCro(s));

    }

    private static int findCro(String s) {
        //크로아티아 알파벳이 몇개있는지?
        int answer = 0;
        Queue<String> queue = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            String temp = s.charAt(i) + "";
            queue.add(temp);
        }

        while (!queue.isEmpty()) {
            String start = queue.poll();
            if (start.equals("-") || start.equals("="))
                continue;
            else answer++;
            if (queue.isEmpty())
                break;
            switch (start) {
                case "c":
                    if (queue.peek().equals("=") || queue.peek().equals("-"))
                        queue.remove();
                    break;
                case "d":
                    if (queue.peek().equals("z")) {
                        queue.remove();
                        if (!queue.isEmpty() && queue.peek().equals("="))
                        {
                            queue.remove();
                        } else
                            answer++;
                    }
                    break;
                case "l":
                    if (queue.peek().equals("j"))
                        queue.remove();
                   
                    break;
                case "n":
                    if (queue.peek().equals("j"))
                      queue.remove();
                    
                    break;
                case "s":
                    if (queue.peek().equals("="))
                        queue.remove();
                    
                    break;
                case "z":
                    if (queue.peek().equals("="))
                        queue.remove();
                    
                    break;
            }
        }
        return answer;
    }
}
