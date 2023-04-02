package w11;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;

        for (String str : skill_trees) {
            String filteredStr = str.replaceAll("[^" + skill + "]", "");

            int len = filteredStr.length();

            boolean isPossible = true;
            for (int i = 0; i < len; i++) {
                if (skill.charAt(i) != filteredStr.charAt(i)) {
                    isPossible = false;
                    break;
                }
            }
            if (isPossible)
                answer++;
        }

        return answer;
    }
}
