package personalStudy.week9;

import java.util.*;
import java.io.*;

public class BOJ4963_DFS {

    private static final String DONE = "0 0";
    private static int[][] map;
    private static boolean[][] visited;
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();
    private static int[] dirX = {-1, 0, 1, -1, 1, -1, 0, 1};
    private static int[] dirY = {1, 1, 1, 0, 0, -1, -1, -1};
    private static int x, y;

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
                        DFS(i, j);
                    }
                }
            }

            sb.append(count).append("\n");
        }
    }

    private static void DFS(int nowY, int nowX) {
        visited[nowY][nowX] = true;

        for (int i = 0; i < 8; i++) {
            int nextY = dirY[i] + nowY;
            int nextX = dirX[i] + nowX;

            if (checkRange(nextY, nextX) && !visited[nextY][nextX] && map[nextY][nextX] == 1) {
                DFS(nextY, nextX);
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
