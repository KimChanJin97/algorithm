package week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1149 {

    // 키포인트 0) 3개의 dp를 동시에 한다고 생각
    // 키포인트 1) 각 0행 색깔은 모두 최소라고 간주
    // 키포인트 2) 자기자신을 항상 최소라고 생각. 항상                나                                      를 선택한다고 생각
    //        i  ) N행의 자기자신이 R 일 경우, dp[N][R] = arr[N][R] + min(recur(N-1, G), recur(N-1, B))
    //        ii ) N행의 자기자신이 G 일 경우, dp[N][G] = arr[N][G] + min(recur(N-1, R), recur(N-1, B))
    //        iii) N행의 자기자신이 B 일 경우, dp[N][B] = arr[N][B] + min(recur(N-1, R), recur(N-1, G))

    private static int[][] arr;
    private static int[][] dp;

    private static final int RED = 0;
    private static final int GREEN = 1;
    private static final int BLUE = 2;

    public static int solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        arr = new int[N][3]; // 3 은 색깔 갯수를 의미
        dp = new int[N][3]; // 3 은 색깔 갯수를 의미

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 위에서 초기화한 이후에 메모리제이션
        dp[0][RED] = arr[0][RED]; // 최초에는 자기자신이 최소라고 간주
        dp[0][GREEN] = arr[0][GREEN]; // 최초에는 자기자신이 최소라고 간주
        dp[0][BLUE] = arr[0][BLUE]; // 최초에는 자기자신이 최소라고 간주

        return Math.min(Math.min(recur(N - 1, RED), recur(N - 1, GREEN)), recur(N - 1, BLUE)); // 첫번째 집을 1이라 했기 때문에 인덱스 0에 맞춰주기 위해 N - 1
    }

    public static int recur(int N, int color) {

        if (dp[N][color] == 0) {

            if (color == RED) {
                dp[N][RED] = arr[N][RED] + Math.min(recur(N - 1, GREEN), recur(N - 1, BLUE));
            } else if (color == GREEN) {
                dp[N][GREEN] = arr[N][GREEN] + Math.min(recur(N - 1, RED), recur(N - 1, BLUE));
            } else if (color == BLUE) {
                dp[N][BLUE] = arr[N][BLUE] + Math.min(recur(N - 1, RED), recur(N - 1, GREEN));
            }
        }

        return dp[N][color];
    }

    public static void main(String[] args) throws IOException {
        System.out.println(solution());
    }

}
