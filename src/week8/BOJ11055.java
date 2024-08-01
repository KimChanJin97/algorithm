package week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11055 {

    private static int[] seq;
    private static int[] dp;

    public static int solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        seq = new int[N];
        dp = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            LIS(i);
        }

        int max = dp[0];
        for (int i = 1; i < N; i++) {
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    private static int LIS(int i) {
        if (dp[i] == 0) { // LIS 계산이 되지 않았다면
            dp[i] = seq[i]; // 기본값 seq[i]로 초기화

            for (int j = i - 1; j >= 0; j--) {
                if (seq[j] < seq[i]) { // 만약 기준 요소(seq[i])보다 작은 요소(seq[j])가 존재한다면
                    dp[i] = Math.max(dp[i], LIS(j) + seq[i]); // "기준요소"와 "기준이전요소 + 기준요소"를 비교하여 큰 것으로 기준 요소를 갈아끼우기
                }
            }
        }

        return dp[i]; // LIS 계산이 된 상태라면 계산할 필요없이 반환
    }

    public static void main(String[] args) throws IOException {
        System.out.println(solution());
    }


}
