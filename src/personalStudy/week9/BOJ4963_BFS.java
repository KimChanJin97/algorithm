package personalStudy.week9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ4963_BFS {

    private static String DONE = "0 0";
    private static StringTokenizer st;
    private static int[][] map;
    private static boolean[][] visited;
    private static int[] dirX = {-1, 0, 1, -1, 1, -1, 0, 1};
    private static int[] dirY = {1, 1, 1, 0, 0, -1, -1, -1};
    private static int x, y;
    private static StringBuilder sb = new StringBuilder();

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line;
        while (!(line = br.readLine()).equals(DONE)) {
            st = new StringTokenizer(line);
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            map = new int[y][x];
            visited = new boolean[y][x];

            for (int i = 0; i < y; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < x; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int count = 0;
            for (int i = 0; i < y; i++) {
                for (int j = 0; j < x; j++) {
                    if (!visited[i][j] && map[i][j] == 1) {
                        count++;
                        BFS(i, j);
                    }
                }
            }
            sb.append(count).append("\n");
        }
    }

    private static void BFS(int y, int x) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{y, x});

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int nowY = poll[0];
            int nowX = poll[1];

            for (int i = 0; i < 8; i++) {
                int nextY = dirY[i] + nowY;
                int nextX = dirX[i] + nowX;
                if (checkRange(nextY, nextX) && !visited[nextY][nextX] && map[nextY][nextX] == 1) {
                    visited[nextY][nextX] = true;
                    queue.add(new int[]{nextY, nextX});
                }
            }
        }
    }

    private static boolean checkRange(int nextY, int nextX) {
        return 0 <= nextY && nextY < y &&
                0 <= nextX && nextX < x;
    }

    public static void main(String[] args) throws IOException {
        solution();
        System.out.println(sb);
    }
}
