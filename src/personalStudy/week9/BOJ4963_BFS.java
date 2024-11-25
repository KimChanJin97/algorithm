package personalStudy.week9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ4963_BFS {

    private static final List<Integer> ANSWERS = new ArrayList<>();
    private static int[][] board;
    private static boolean[][] visited;
    private static int width;
    private static int height;
    // 상 하 좌 우 좌상 좌하 우상 우하
    private static int[] dirX = {0, 0, -1, 1, -1, -1, 1, 1};
    private static int[] dirY = {1, -1, 0, 0, 1, -1, 1, -1};

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str;
        while (!(str = br.readLine()).equals("0 0")) {
            StringTokenizer st = new StringTokenizer(str);
            width = Integer.parseInt(st.nextToken());
            height = Integer.parseInt(st.nextToken());

            // 초기화
            board = new int[height][width];
            for (int i = 0; i < height; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < width; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // 초기화
            visited = new boolean[height][width];

            // 로직
            int count = 0;
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if (!visited[i][j] && board[i][j] == 1) {
                        BFS(i, j);
                        count++;
                    }
                }
            }
            ANSWERS.add(count);
        }
    }

    private static void BFS(int x, int y) {
        final Queue<int[]> QUEUE = new LinkedList<>();
        QUEUE.add(new int[]{x,y});
        visited[x][y] = true;
        while (!QUEUE.isEmpty()) {
            int[] pos = QUEUE.poll();
            for (int i = 0; i < 8; i++) {
                int nextX = pos[0] + dirX[i];
                int nextY = pos[1] + dirY[i];
                if (nextX < 0 || nextY < 0 || nextX >= height || nextY >= width) continue;
                if (!visited[nextX][nextY] && board[nextX][nextY] == 1) {
                    QUEUE.add(new int[]{nextX, nextY});
                    visited[nextX][nextY] = true;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        solution();
        ANSWERS.stream().forEach(i -> System.out.println(i));
    }
}
