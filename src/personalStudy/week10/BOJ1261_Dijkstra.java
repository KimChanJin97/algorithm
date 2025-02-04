package personalStudy.week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ1261_Dijkstra {

    private static StringTokenizer st;
    private static int[] dirX = {1, 0, -1, 0};
    private static int[] dirY = {0, 1, 0, -1};
    private static char[][] miro;
    private static int[][] dp;
    private static int width, height;

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        width = Integer.parseInt(st.nextToken());
        height = Integer.parseInt(st.nextToken());

        dp = new int[height][width];
        miro = new char[height][width];

        for (int i = 0; i < height; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
            miro[i] = br.readLine().toCharArray();
        }

        dijkstra();

        System.out.println(dp[height - 1][width - 1]);
    }

    private static void dijkstra() {
        dp[0][0] = 0;
        PriorityQueue<Room> pq = new PriorityQueue<>();
        pq.add(new Room(0, 0, 0));

        while (!pq.isEmpty()) {
            Room now = pq.poll();

            int nowY = now.y;
            int nowX = now.x;
            int nowCost = now.cost;

            for (int i = 0; i < 4; i++) {
                int nextY = nowY + dirY[i];
                int nextX = nowX + dirX[i];

                // out of bound 예외 방지
                if (!checkRange(nextY, nextX)) {
                    continue;
                }
                // 이동하려는 곳에 벽이 있다면
                int nextCost = nowCost + checkWall(nextY, nextX);
                // 이동하려는 곳이 최단경로라면
                if (dp[nextY][nextX] > nextCost) {
                    dp[nextY][nextX] = nextCost;
                    pq.add(new Room(nextY, nextX, nextCost));
                }
            }
        }
    }

    private static boolean checkRange(int nextY, int nextX) {
        if (0 <= nextX && nextX < width && 0 <= nextY && nextY < height) {
            return true;
        }
        return false;
    }

    private static int checkWall(int nextY, int nextX) {
        if (miro[nextY][nextX] == '1') {
            return 1;
        }
        return 0;
    }

    static class Room implements Comparable<Room> {
        int y;
        int x;
        int cost;

        public Room(int y, int x, int cost) {
            this.y = y;
            this.x = x;
            this.cost = cost;
        }

        @Override
        public int compareTo(Room o) {
            return this.cost - o.cost;
        }
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
