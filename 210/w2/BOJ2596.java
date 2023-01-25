package w2;

import java.io.File;
import java.util.Scanner;

class Main {

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(new File("./inputs/input_BOJ2596.txt"));

        // 입력 처리
        int cnt = in.nextInt();
        String msg = in.next();
        readCode(cnt, msg);

    }

    // 교환 일기 해석 메서드
    private static void readCode(int cnt, String msg) {
        StringBuilder sb = new StringBuilder();

        // 모든 글자를 순회하며 문자 해석
        boolean isPossible = true;
        int wrongIdx = -1;
        for (int i = 0; i < cnt; i++) {

            // 6칸을 한 문자로 해석 처리
            String currentCode = msg.substring(i * 6, (i + 1) * 6);
            char c = getChar(currentCode);

            // 해당하는 문자가 없는 코드이면 해석 불가 처리 및 해당 위치 처리
            if (c == ' ') {
                isPossible = false;
                wrongIdx = i + 1;
                break;
            }

            // 메세지에 문자 삽입
            sb.append(getChar(currentCode));
        }

        // 해석 가능 여부에 따라 출력 처리
        if (isPossible) {
            System.out.println(sb.toString());
        } else {
            System.out.println(wrongIdx + " ");
        }
    }

    // 문자열 코드를 바탕으로 문자 반환
    private static char getChar(String code) {

        // 아스키코드 순서대로 코드 입력
        String[] codes = { "000000", "001111", "010011", "011100", "100110", "101001", "110101", "111010" };

        // 모든 코드를 순회하며 해당하는 문자가 있는 해결
        for (int i = 0; i < codes.length; i++) {
            boolean isSame = true;
            int diffCnt = 0;
            for (int j = 0; j < 6; j++) {

                // 문자열의 모든 문자를 순회하며 비교
                if (codes[i].charAt(j) != code.charAt(j))
                    diffCnt++;

                // 일치하지 않는 문자가 2개면 비교 중단
                if (diffCnt == 2) {
                    isSame = false;
                    break;
                }
            }

            // 해당하는 문자가 있으면 아스키코드를 활용하여 문자 반환
            if (isSame)
                return (char) ('A' + i);
        }

        // 일치하는 문자가 없으면 공백 문자 반환
        return ' ';
    }

}