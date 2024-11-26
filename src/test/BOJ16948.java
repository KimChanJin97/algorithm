package test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ16948 {

    private static int n;
    private static int r2;
    private static int c2;
    private static boolean[][] visited;
    private static final int[] dirR = {-2, -2, 0, 0, 2, 2};
    private static final int[] dirC = {-1, 1, -2, 2, -1, 1};

    private static void solution() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        visited = new boolean[n][n];

        int r1 = sc.nextInt();
        int c1 = sc.nextInt();
        r2 = sc.nextInt();
        c2 = sc.nextInt();

        System.out.println(BFS(r1, c1));
    }

    private static int BFS(int r, int c) {
        final Queue<Piece> QUEUE = new LinkedList<>();
        QUEUE.add(new Piece(r, c, 0));
        visited[c][r] = true;
        while (!QUEUE.isEmpty()) {
            Piece piece = QUEUE.poll();
            for (int i = 0; i < 6; i++) {
                int nextR = piece.r + dirR[i];
                int nextC = piece.c + dirC[i];
                // 범위에 벗어날 경우
                if (nextR < 0 || nextC < 0 || nextR > n - 1 || nextC > n - 1) {
                    continue;
                }
                // 목적지를 찾은 경우
                if (nextR == r2 && nextC == c2) {
                    return piece.move + 1;
                }
                // 아직 목적지를 찾지 못한 경우
                if (!visited[nextC][nextR]) {
                    QUEUE.add(new Piece(nextR, nextC, piece.move + 1));
                    visited[nextC][nextR] = true;
                }
            }
        }
        return -1;
    }

    private static class Piece {
        int r;
        int c;
        int move;
        public Piece(int r, int c, int move) {
            this.r = r;
            this.c = c;
            this.move = move;
        }
    }

    public static void main(String[] args) {
        solution();
    }
}
