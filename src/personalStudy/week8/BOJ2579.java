package personalStudy.week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 계단 오르기
public class BOJ2579 {

    private static int[] stairs;
    private static Integer[] dp;

    private static int solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // N 은 3000 이하의 자연수

        stairs = new int[N + 1];
        dp = new Integer[N + 1];
        for (int i = 1; i <= N; i++) {
            stairs[i] = Integer.parseInt(br.readLine());
        }

        // ArrayIndexOutOfBoundsException 방지
        dp[0] = 0;

        // 확실하게 구할 수 있는 최대 누적값
        if (N == 1) {
            dp[1] = stairs[1];
        }
        // 확실하게 구할 수 있는 최대 누적값
        if (N >= 2) {
            dp[1] = stairs[1];
            dp[2] = stairs[1] + stairs[2];
        }

        return find(N);
    }

    private static int find(int N) {
        if (dp[N] == null) {
            dp[N] = Math.max(find(N - 3) + stairs[N - 1], find(N - 2)) + stairs[N];
        }
        return dp[N];
    }

    public static void main(String[] args) throws IOException {
        System.out.println(solution());
    }
}
