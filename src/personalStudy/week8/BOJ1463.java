package personalStudy.week8;

import java.util.Scanner;

public class BOJ1463 {

    private static int[] dp;

    public static int solution() {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        dp = new int[N + 1]; // 1 ~ N
        for (int i = 0; i <= N; i++) { // 초기화
            dp[i] = -1;
        }
        dp[1] = 0; // 1은 1로 만들 필요없음 -> 0회

        return recur(N);
    }

    public static int recur(int i) { // 1을 더한다는 것은 해당 재귀호출로 최소 연산이 이뤄졌음(카운트함)을 의미
        if (dp[i] == -1) {

            if (i % 6 == 0) {
                dp[i] = Math.min(recur(i - 1), Math.min(recur(i / 3), recur(i / 2))) + 1;
            } else if (i % 3 == 0) {
                dp[i] = Math.min(recur(i / 3), recur(i - 1)) + 1;
            } else if (i % 2 == 0) {
                dp[i] = Math.min(recur(i / 2), recur(i - 1)) + 1;
            } else {
                dp[i] = recur(i - 1) + 1;
            }
        }
        return dp[i];
    }

    public static void main(String[] args) {
        System.out.println(solution());
    }

}
