package personalStudy.week9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ4963_DFS {

    private static int[][] map;
    private static boolean[][] visited;
    private static final String END = "0 0";
    private static int w;
    private static int h;
    // 상 하 좌 우 좌상 좌하 우상 우하
    private static int[] dirX = {0, 0, -1, 1, -1, -1, 1, 1};
    private static int[] dirY = {1, -1, 0, 0, 1, -1, 1, -1};

    private static StringTokenizer st;
    private static final StringBuilder SB = new StringBuilder();
    private static int count = 0;

    private static String solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line;
        while (!(line = br.readLine()).equals(END)) {
            st = new StringTokenizer(line); // 3 2
            w = Integer.parseInt(st.nextToken()); // 3
            h = Integer.parseInt(st.nextToken()); // 2

            map = new int[h + 1][w + 1];
            visited = new boolean[h + 1][w + 1];

            for (int y = 1; y <= h; y++) {
                st = new StringTokenizer(br.readLine());
                for (int x = 1; x <= w; x++) {
                    map[y][x] = Integer.parseInt(st.nextToken());
                }
            }

            count = 0;
            for (int y = 1; y <= h; y++) {
                for (int x = 1; x <= w; x++) { // 모든 좌표에 대해 검사
                    if (!visited[y][x] && map[y][x] == 1) { // 방문한 곳임에도 불구하고 count++ 하지 않기 위해
                        DFS(new Position(x, y)); // 처음(1,1)부터 시작
                        count++;
                    }
                }
            }

            SB.append(count).append("\n");
        }
        return SB.toString();
    }

    private static void DFS(Position pos) {
        visited[pos.y][pos.x] = true;
        for (int i = 0; i < 8; i++) { // 8방향으로 훑기
            int nextX = pos.x + dirX[i];
            int nextY = pos.y + dirY[i];
            if (canGoRegardlessOfVisited(nextX, nextY) && !visited[nextY][nextX] && map[nextY][nextX] == 1) {
                DFS(new Position(nextX, nextY));
            }
        }
    }

    private static boolean canGoRegardlessOfVisited(int nextX, int nextY) {
        return (1 <= nextX && nextX <= w && 1 <= nextY && nextY <= h);
    }

    private static class Position {
        private int x;
        private int y;
        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        System.out.println(solution());
    }
}
