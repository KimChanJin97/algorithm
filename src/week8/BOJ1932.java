package week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1932 {

    private static int[][] tri;
    private static Integer[][] dp;
    private static int n;

    public static int solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        tri = new int[n][n];
        dp = new Integer[n][n];

        for (int i = 0; i < n; i++) { // 0, 1, 2, 3, 4
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j <= i; j++) { // 0, 01, 012, 0123, 01234
                tri[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            dp[n - 1][i] = tri[n - 1][i];
        }

        return find(0, 0);
    }

    public static int find(int row, int col) {
        if (row == n - 1) return dp[row][col];

        if (dp[row][col] == null) {
            dp[row][col] = Math.max(find(row + 1, col), find(row + 1, col + 1)) + tri[row][col];
        }

        return dp[row][col];
    }

    public static void main(String[] args) throws IOException {
        System.out.println(solution());
    }

}
