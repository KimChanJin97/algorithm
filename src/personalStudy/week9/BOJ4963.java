package personalStudy.week9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ4963 {

    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();
    private static int[][] board;
    private static boolean[][] visited;

    private static int w, h, modifiedX, modifiedY;

    private static final int[] dirX = {-1, 0, 1, -1, 1, -1, 0, 1};
    private static final int[] dirY = {-1, -1, -1, 0, 0, 1, 1, 1};

    private static final String END = "0 0";

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line;
        while (!(line = br.readLine()).equals(END)) {
            st = new StringTokenizer(line);
            w = Integer.parseInt(st.nextToken()); // 너비 = 열 (낚시 조심)
            h = Integer.parseInt(st.nextToken()); // 높이 = 행 (낚시 조심)
            board = new int[h][w];
            visited = new boolean[h][w];

            // board 초기화
            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // 계산
            int count = 0;
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    // 몇 번의 DFS() 재귀로 하나의 땅덩어리를 판별한 이후
                    // 판별이 끝난 땅덩어리는 다시 판별하지 않기 위해 조건문 필요
                    if (!visited[i][j] && board[i][j] == 1) {
                        count++;
                        DFS(i, j); // 그 몇 번의 DFS() 재귀의 첫 시작임
                    }
                }
            }

            sb.append(count).append("\n");
        }
    }

    private static void DFS(int x, int y) {
        visited[x][y] = true;

        for (int i = 0; i < 8; i++) {
            modifiedX = dirX[i] + x;
            modifiedY = dirY[i] + y;

            if (isInRange() && isNotVisited() && isLand()) {
                DFS(modifiedX, modifiedY);
            }
        }
    }

    private static boolean isInRange() {
        // 팔방위X 가 0 보다 크고
        // 팔방위Y 가 0 보다 크고
        // 팔방위X 가 h 보다 작고 (x 는 행이므로 h 로 따져야 함)
        // 팔방위Y 가 w 보다 작다면 (y 는 열이므로 w 로 따져야 함)
        return (modifiedX >= 0 && modifiedY >= 0 && modifiedX < h && modifiedY < w);
    }

    private static boolean isNotVisited() {
        return !visited[modifiedX][modifiedY];
    }

    private static boolean isLand() {
        return board[modifiedX][modifiedY] == 1;
    }

    public static void main(String[] args) throws IOException {
        solution();
        System.out.println(sb);
    }
}
