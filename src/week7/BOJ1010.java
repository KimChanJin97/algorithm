package week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1010 {

    static int[][] dp;

    static String solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        // 조합 점화식 1 : (n,r) = (n-1, r-1) + (n-1, r)
        // 조합 점화식 2 : (n,0) = (n, n) = 1

        while (T-- > 0) {
            dp = new int[30][30];

            String[] split = br.readLine().split(" ");
            int N = Integer.parseInt(split[0]);
            int M = Integer.parseInt(split[1]);

            sb.append(combi(M, N)).append("\n");
        }

        return sb.toString();
    }

    static int combi(int n, int r) {
        if (dp[n][r] > 0) return dp[n][r];
        if (n == r || r == 0) return dp[n][r] = 1; // 조합 점화식 2 + 메모리제이션
        return dp[n][r] = combi(n - 1, r - 1) + combi(n - 1, r); // 조합 점화식 1 + 메모리제이션
    }

    public static void main(String[] args) throws IOException {
        System.out.println(solution());
    }
}
