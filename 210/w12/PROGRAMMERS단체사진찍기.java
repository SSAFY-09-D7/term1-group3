package w12;

import java.util.*;

class Solution {
    int answer = 0;
    public int solution(int n, String[] data) {
        String[] people = { "A", "C", "F", "J", "M", "N", "R", "T" };
        boolean[] visited = new boolean[8];

        dfs(visited, people, data, "");

        return answer;
    }

    public void dfs(boolean[] visited, String[] people, String[] data, String shot) {
        if (shot.length() == 8) {
            if (check(shot, data))
                answer++;
            return;
        }

        for (int i = 0; i < 8; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(visited, people, data, shot + people[i]);
                visited[i] = false;
            }
        }
    }

    public boolean check(String str, String[] data) {
        for (String d : data) {
            int aIdx = str.indexOf(d.charAt(0));
            int bIdx = str.indexOf(d.charAt(2));
            int distance = Math.abs(aIdx - bIdx) - 1;

            char op = d.charAt(3);
            int operand = d.charAt(4) - '0';
            if (op == '=' && distance != operand) {
                return false;
            } else if (op == '<' && distance >= operand) {
                return false;
            } else if (op == '>' && distance <= operand) {
                return false;
            }
        }
        return true;
    }
}
