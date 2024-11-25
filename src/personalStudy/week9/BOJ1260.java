package personalStudy.week9;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ1260 {

    private static int[][] board;
    private static boolean[] visited;
    private static StringBuilder sb;
    private static int N;
    private static int M;
    private static int V;

    private static void solution() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        V = sc.nextInt();

        board = new int[N + 1][N + 1];

        for (int i = 0; i < M; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            board[start][end] = board[end][start] = 1; // 양방향간선
        }

        sb = new StringBuilder();
        visited = new boolean[N + 1];
        DFS(V);

        sb.append("\n");
        visited = new boolean[N + 1];
        BFS();
    }

    private static void DFS(int v) {
        visited[v] = true;
        sb.append(v + " ");
        for (int i = 1; i <= N; i++) {
            if (!visited[i] && board[v][i] == 1) { // DFS
                DFS(i);
            }
        }
    }

    private static void BFS() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(V);
        visited[V] = true;
        sb.append(V + " "); // V부터 시작
        while (!queue.isEmpty()) {
            Integer v = queue.poll();
            for (int i = 1; i <= N; i++) {
                if (!visited[i] && board[v][i] == 1) { // BFS
                    queue.add(i);
                    visited[i] = true;
                    sb.append(i + " ");
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        solution();
        System.out.println(sb);
    }
}
