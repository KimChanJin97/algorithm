package week8;

import java.util.Scanner;

public class BOJ2156 {

    // 키포인트 : 규칙을 준수하는 점화식을 세울 수 있어야 함

    private static int[] seq;
    private static Integer[] dp;

    public static int solution() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        seq = new int[n + 1];
        dp = new Integer[n + 1];

        for (int i = 1; i <= n; i++) {
            seq[i] = sc.nextInt();
        }

        dp[1] = seq[1];
        if (n > 1) dp[2] = seq[1] + seq[2];

        return recur(n);
    }

    public static int recur(int i) {
        if (dp[i] == null) {
            dp[i] = Math.max(
                    Math.max(recur(i - 2), recur(i - 3) + seq[i - 1]) + seq[i],
                    recur(i - 1));
        }
        return dp[i];
    }

    public static void main(String[] args) {
        System.out.println(solution());
    }
}
