package personalStudy.week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 포도주 시식
public class BOJ2156 {

    private static int[] cups;
    private static Integer[] dp;

    private static int solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        cups = new int[n + 1]; // ArrayIndexOutOfBoundsException 방지
        dp = new Integer[n + 1];

        for (int i = 1; i <= n; i++) {
            cups[i] = Integer.parseInt(br.readLine());
        }

        // ArrayIndexOutOfBoundsException 방지
        dp[0] = 0;
        // 확실하게 구할 수 있는 최대 누적합
        if (n == 1) {
            dp[1] = cups[1];
        }
        // 확실하게 구할 수 있는 최대 누적합
        if (n >= 2) {
            dp[1] = cups[1];
            dp[2] = cups[1] + cups[2];
        }

        return find(n);
    }

    private static int find(int n) {
        if (dp[n] == null) {
            dp[n] = Math.max(Math.max(find(n - 3) + cups[n - 1], find(n - 2)) + cups[n], find(n - 1));
        }
        return dp[n];
    }

    public static void main(String[] args) throws IOException {
        System.out.println(solution());
    }
}
