package programmers;

import java.util.LinkedList;
import java.util.Queue;

public class P0002_DFS {

    public void DP(int m, int n, int[][] puddles) {
        int mod = 1_000_000_007;
        int y = n;
        int x = m;
        int[][] dp = new int[y + 1][x + 1];

        for (int[] puddle : puddles) {
            int py = puddle[0];
            int px = puddle[1];
            dp[py][px] = -1;
        }

        dp[y][x] = 1;

        for (int i = 1; i <= y; i++) {
            for (int j = 1; j <= x; j++) {
                // 출발지이거나 웅덩이라면
                if ((i == 1 && j == 1) || dp[i][j] == -1) {
                    continue;
                }
                // 위에서 아래로 가는 경우
                if (i > 1 && dp[i - 1][j] != -1) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][j]) % mod;
                }
                // 왼쪽에서 오른쪽으로 가는 경우
                if (j > 1 && dp[i][j-1] != -1) {
                    dp[i][j] = (dp[i][j] + dp[i][j-1]) % mod;
                }
            }
        }
        System.out.println(dp[y][x]);
    }

    public void BFS(int m, int n, int[][] puddles) {
        int mod = 1_000_000_007;
        int[] dirY = {0, 1};
        int[] dirX = {1, 0};
        int y = n;
        int x = m;
        int[][] dp = new int[y + 1][x + 1];
        boolean[][] isPuddle = new boolean[y + 1][x + 1];

        for (int[] puddle : puddles) {
            int py = puddle[0];
            int px = puddle[1];
            isPuddle[py][px] = true;
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{1,1});
        dp[1][1] = 1;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int nowY = poll[0];
            int nowX = poll[1];

            for (int i = 0; i < 2; i++) {
                int nextY = nowY + dirY[i];
                int nextX = nowX + dirX[i];

                // 다음에 갈 곳이 범위을 벗어났거나, 웅덩이가 있는 곳이라면
                if (nextY > y || nextX > x || isPuddle[nextY][nextX]) {
                    continue;
                }

                // 다음에 갈 곳에 길이 있다면
                if (dp[nextY][nextX] == 0) {
                    queue.add(new int[]{nextY, nextX});
                }

                dp[nextY][nextX] = (dp[nextY][nextX] + dp[nowY][nowX]) % mod;
            }
        }
        System.out.println(dp[y][x]);
    }

    public int DFS(int m, int n, int[][] puddles) {
        int mod = 1_000_000_007;
        int[] dirY = {0, 1};
        int[] dirX = {1, 0};
        int y = n;
        int x = m;
        int[][] dp = new int[y + 1][x + 1];
        boolean[][] isPuddle = new boolean[y + 1][x + 1];


    }
}
