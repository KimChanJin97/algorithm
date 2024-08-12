package week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ2293 {

    private static int n;
    private static int k;

    private static int[] coins;
    private static int[] dp;

    public static int solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken()); // 3
        k = Integer.parseInt(st.nextToken()); // 10

        coins = new int[n];
        dp = new int[k + 1];

        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine()); // 1,2,5
        }

        // 작은 값부터 dp 하기 위해 정렬할 필요없음 ("해당 동전이 추가될 수 있다면" 조건 때문. 그냥 주어진대로 누적하면 됨)

        dp[0] = 1; // 최초 j == coins[i] 경우에 dp 값 세팅하기 위해 1로 초기값 세팅

        for (int i = 0; i < n; i++) { // coins[0] ~ coins[n-1]
            for (int j = 1; j <= k; j++) { // dp[1] ~ dp[k]
                if (j >= coins[i]) {
                    dp[j] = dp[j] + dp[j - coins[i]];
                }
            }
        }
        return dp[k];
    }

    public static void main(String[] args) throws IOException {
        System.out.println(solution());
    }

}
