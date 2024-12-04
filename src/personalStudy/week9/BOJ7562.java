package personalStudy.week9;

import java.io.*;
import java.util.*;

public class BOJ7562 {

    private static int[][] visited;
    private static int I;
    private static int dstX;
    private static int dstY;

    private static int[] dirX = {-2, -1, 1, 2, -2, -1, 1, 2};
    private static int[] dirY = {1, 2, 2, 1, -1, -2, -2, -1};

    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();

    private static String solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        while (tc-- > 0) {
            I = Integer.parseInt(br.readLine());
            visited = new int[I][I];

            st = new StringTokenizer(br.readLine());
            int srcX = Integer.parseInt(st.nextToken());
            int srcY = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            dstX = Integer.parseInt(st.nextToken());
            dstY = Integer.parseInt(st.nextToken());

            sb.append(BFS(new int[]{srcX, srcY}) - 1).append("\n");
        }
        return sb.toString();
    }

    private static int BFS(int[] src) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(src);
        int srcX = src[0];
        int srcY = src[1];

        if (srcX == dstX && srcY == dstY) return 1;

        visited[srcY][srcX] = 1;
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            for (int i = 0; i < 8; i++) {
                int nowX = now[0];
                int nowY = now[1];
                int nextX = now[0] + dirX[i];
                int nextY = now[1] + dirY[i];
                if (isInRange(nextX, nextY) && visited[nextY][nextX] == 0) {
                    queue.add(new int[]{nextX, nextY});
                    visited[nextY][nextX] = visited[nowY][nowX] + 1;
                }
            }
        }
        return visited[dstY][dstX];
    }

    private static boolean isInRange(int nextX, int nextY) {
        return (0 <= nextX && nextX < I && 0 <= nextY && nextY < I);
    }

    public static void main(String[] args) throws IOException {
        System.out.println(solution());
    }
}