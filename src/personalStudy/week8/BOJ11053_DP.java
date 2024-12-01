package personalStudy.week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 가장 긴 증가하는 부분 수열
public class BOJ11053_DP {

    private static int[] arr;
    private static Integer[] dp;

    private static int solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        arr = new int[N];
        dp = new Integer[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            LIS(i);
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            if (max < dp[i]) {
                max = dp[i];
            }
        }

        return max;
    }

    private static int LIS(int nowIdx) {
        if (dp[nowIdx] == null) {
            dp[nowIdx] = 1;
            for (int beforeIdx = 0; beforeIdx < nowIdx; beforeIdx++) {
                if (arr[beforeIdx] < arr[nowIdx]) {
                    dp[nowIdx] = Math.max(dp[nowIdx], LIS(beforeIdx) + 1);
                }
            }
        }
        return dp[nowIdx];
    }

    public static void main(String[] args) throws IOException {
        System.out.println(solution());
    }
}
