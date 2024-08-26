package week9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2606 {

    private static int[][] board;
    private static boolean[] visited;
    private static StringTokenizer st;

    private static int total;
    private static int conn;

    private static int answerUsingDFS;
//    private static int answerUsingBFS;

//    private static Queue<Integer> queue = new LinkedList<>();

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        total = Integer.parseInt(br.readLine());
        conn = Integer.parseInt(br.readLine());

        board = new int[total + 1][total + 1];
        for (int i = 1; i <= conn; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            board[x][y] = board[y][x] = 1;
        }

        visited = new boolean[total + 1];
        DFS(1);

//        visited = new boolean[total + 1];
//        BFS(1);
    }

    public static void DFS(int x) {
        visited[x] = true;
        answerUsingDFS++;
        for (int y = 1; y <= total; y++) {
            if (board[x][y] == 1 && !visited[y]) {
                DFS(y);
            }
        }
    }

//    public static void BFS(int x) {
//        queue.add(x);
//        visited[x] = true;
//
//        while (!queue.isEmpty()) {
//            answerUsingBFS++;
//            Integer poll = queue.poll();
//            for (int y = 1; y <= total; y++) {
//                if (board[poll][y] == 1 && !visited[y]) {
//                    queue.add(y);
//                    visited[y] = true;
//                }
//            }
//        }
//    }

    public static void main(String[] args) throws IOException {
        solution();
        System.out.println(answerUsingDFS - 1); // 처음 출발 노드는 제외해야 하므로 -1
//        System.out.println(answerUsingBFS);
    }

}
