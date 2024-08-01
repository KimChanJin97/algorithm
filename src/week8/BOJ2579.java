package week8;

import java.util.Scanner;

public class BOJ2579 {

    private static int[] stairs;

    // 규칙1 : 계단은 하나 또는 두개씩 걸을 수 있음
    // 규칙2 : 연속 세개 계단을 걸을 순 없음 -> [ 낚시 ] n-1, n 를 걷는 것 자체가 계단 연속 3개 걸은 것임...!
    // 규칙3 : 마지막 계단은 무조건 걸어야 함

    static int solution() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        stairs = new int[301];
        for (int i = 1; i <= n; i++) {
            stairs[i] = sc.nextInt();
        }

        int[] score = new int[n + 2]; // n = 1, 2 인 경우 때문에 +2

        score[1] = stairs[1]; // n = 1 인 경우, 계단 1개이므로 stairs[1] 가 최대값
        score[2] = stairs[1] + stairs[2];// n = 2 인 경우, 계단 2개이므로 stairs[1] + stairs[2] 가 최대값

        // n = 3 이상인 경우, 계단 3개 이상이므로 점화식 적용
        // n = 3 인 경우, score[0] = 0 으로 초기화되어 있기 때문에 괜찮음
        for (int i = 3; i <= n; i++) {
            score[i] = Math.max(score[i - 3] + stairs[i - 1], score[i - 2]) + stairs[i];
        }

        return score[n];
    }

    public static void main(String[] args) {
        System.out.println(solution());
    }

}
