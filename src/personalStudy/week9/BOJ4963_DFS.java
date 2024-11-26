package personalStudy.week9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ4963_DFS {

    private static final List<Integer> ANSWERS = new ArrayList<>();
    private static int[][] board;
    private static boolean[][] visited;
    private static int width;
    private static int height;
    // 상 하 좌 우 좌상 우상 좌하 우하
    private static final int[] dirX = {0, 0, -1, 1, -1, 1, -1, 1};
    private static final int[] dirY = {1, -1, 0, 0, 1, 1, -1, -1};

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;


        while (!(str = br.readLine()).equals("0 0")) {
            StringTokenizer st = new StringTokenizer(str);
            width = Integer.parseInt(st.nextToken());
            height = Integer.parseInt(st.nextToken());

            // 초기화
            board = new int[height][width]; // 2차원 행렬
            for (int i = 0; i < height; i++) { // 높이
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < width; j++) { // 너비
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // 초기화
            visited = new boolean[height][width]; // 2차원 행렬

            // 로직
            int count = 0;
            for (int i = 0; i < height; i++) { // 높이
                for (int j = 0; j < width; j++) { // 너비
                    if (!visited[i][j] && board[i][j] == 1) {
                        DFS(j, i); // width, height
                        count++;
                    }
                }
            }
            ANSWERS.add(count);
        }
    }

    private static void DFS(int w, int h) {
        visited[h][w] = true;
        for (int i = 0; i < 8; i++) {
            int nextX = w + dirX[i];
            int nextY = h + dirY[i];
            if (nextX < 0 || nextY < 0 || nextX > width - 1 || nextY > height - 1) {
                continue;
            }
            if (!visited[nextY][nextX] && board[nextY][nextX] == 1) {
                DFS(nextX, nextY);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        solution();
        ANSWERS.stream().forEach(i -> System.out.println(i));
    }
}
