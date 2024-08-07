package week8;

import java.util.Scanner;

public class BOJ2579 {

    // 키포인트 : 규칙을 준수하는 점화식을 세울 수 있어야 함

    private static int[] seq;
    private static int[] dp;

    // 규칙1 : 계단은 하나 또는 두개씩 걸을 수 있음
    // 규칙2 : 연속 세개 계단을 걸을 순 없음 -> [ 낚시 ] n-1, n 를 걷는 것 자체가 계단 연속 3개 걸은 것임...!
    // 규칙3 : 마지막 계단은 무조건 걸어야 함

    static int solution() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        seq = new int[301];
        for (int i = 1; i <= n; i++) {
            seq[i] = sc.nextInt();
        }

        dp = new int[n + 2]; // n = 1, 2 인 경우 때문에 +2

        dp[1] = seq[1]; // n = 1 인 경우, 계단 1개이므로 stairs[1] 가 최대값
        dp[2] = Math.max(seq[2], seq[1] + seq[2]);

        // n = 3 이상인 경우, 계단 3개 이상이므로 점화식 적용
        // n = 3 인 경우, score[0] = 0 으로 초기화되어 있기 때문에 괜찮음
        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(dp[i - 3] + seq[i - 1], dp[i - 2]) + seq[i];
        }

        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(solution());
    }

}
