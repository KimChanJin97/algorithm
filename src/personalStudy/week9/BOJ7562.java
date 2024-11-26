package personalStudy.week9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ7562 {

    private static boolean[][] visited;
    private static int I;
    private static int x2;
    private static int y2;
    private static final int[] DIR_X = {-2, -1, 1, 2, -2, -1, 1, 2};
    private static final int[] DIR_Y = {1, 2, 2, 1, -1, -2, -2, -1};

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        StringTokenizer st;
        while (tc-- > 0) {
            I = Integer.parseInt(br.readLine());
            visited = new boolean[I][I];

            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            x2 = Integer.parseInt(st.nextToken());
            y2 = Integer.parseInt(st.nextToken());

            System.out.println(BFS(x1, y1));
        }
    }

    private static int BFS(int x, int y) {
        final Queue<Piece> QUEUE = new LinkedList<>();
        QUEUE.add(new Piece(x, y, 0));
        visited[y][x] = true;

        if (x == x2 && y == y2) return 0;

        while (!QUEUE.isEmpty()) {
            Piece piece = QUEUE.poll();
            for (int i = 0; i < 8; i++) {
                int nextX = piece.x + DIR_X[i];
                int nextY = piece.y + DIR_Y[i];

                // 범위 벗어난다면 다음
                if (nextX < 0 || nextY < 0 || nextX > I - 1 || nextY > I - 1) {
                    continue;
                }
                // 목적지에 도착했다면
                if (nextX == x2 && nextY == y2) {
                    return piece.move + 1;
                }
                // 목적지에 도착하지 못했다면
                if (!visited[nextY][nextX]) {
                    QUEUE.add(new Piece(nextX, nextY, piece.move + 1));
                    visited[nextY][nextX] = true;
                }
            }
        }
        return -1;
    }

    private static class Piece {
        int x;
        int y;
        int move;
        public Piece(int x, int y, int move) {
            this.x = x;
            this.y = y;
            this.move = move;
        }
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}