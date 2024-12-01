package personalStudy.week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1149_DP {

    private static int[][] dp;
    private static int[][] cost;

    private static final int RED = 0;
    private static final int GREEN = 1;
    private static final int BLUE = 2;

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        dp = new int[N][3];
        cost = new int[N][3];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            cost[i][RED] = Integer.parseInt(st.nextToken());
            cost[i][GREEN] = Integer.parseInt(st.nextToken());
            cost[i][BLUE] = Integer.parseInt(st.nextToken());
        }

        dp[0][RED] = cost[0][RED];
        dp[0][GREEN] = cost[0][GREEN];
        dp[0][BLUE] = cost[0][BLUE];

        System.out.println(Math.min(calculate(N - 1, RED), Math.min(calculate(N - 1, GREEN), calculate(N - 1, BLUE))));
    }

    private static int calculate(int N, int color) {
        if (dp[N][color] == 0) {
            if (color == RED) {
                dp[N][RED] = Math.min(calculate(N - 1, GREEN), calculate(N - 1, BLUE)) + cost[N][RED];
            } else if (color == GREEN) {
                dp[N][GREEN] = Math.min(calculate(N - 1, RED), calculate(N - 1, BLUE)) + cost[N][GREEN];
            } else {
                dp[N][BLUE] = Math.min(calculate(N - 1, GREEN), calculate(N - 1, RED)) + cost[N][BLUE];
            }
        }
        return dp[N][color];
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
