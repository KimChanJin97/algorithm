package personalStudy.week8;

import java.util.Scanner;

public class BOJ2156 {

    // 경우 1) n 을 포함하는 경우
    //      i ) n-2최대누적 + n요소
    //      ii) n-3최대누적 + n-1요소 + n요소
    // 경우 2) n 을 포함하지 않는 경우 (그래도 점화식은 같음)
    //      i ) n-1최대누적

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
                        Math.max(
                                recur(i - 2),
                                recur(i - 3) + seq[i - 1]
                        ) + seq[i],
                            recur(i - 1));
        }
        return dp[i];
    }

    public static void main(String[] args) {
        System.out.println(solution());
    }
}
