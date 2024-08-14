package week9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ1260 {

    private static int[][] board;
    private static boolean[] visited; // 양방향 간선이기 때문에 1차원. (x,y) 방문했다면 (y,x) 방문할 필요없음 또는 (y,x) 방문했다면 (x,y) 방문할 필요없음

    private static Stack<Integer> stack = new Stack<>();
    private static Queue<Integer> queue = new LinkedList<>();

    private static int VERTEX; // 정점
    private static int EDGE; // 간선
    private static int START; // 시작점

    private static StringBuilder sb = new StringBuilder();

    public static String solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        VERTEX = Integer.parseInt(st.nextToken());
        EDGE = Integer.parseInt(st.nextToken());
        START = Integer.parseInt(st.nextToken());

        board = new int[VERTEX + 1][VERTEX + 1];
        for (int i = 1; i <= EDGE; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            board[x][y] = board[y][x] = 1; // 양방향 간선
        }

        // DFS_RECURSION
        visited = new boolean[VERTEX + 1];
        visited[START] = true;
        DFS_RECURSION(START);
        sb.append("\n");

        // DFS_REPETITION
//        visited = new boolean[VERTEX + 1];
//        DFS_ITERATION(START);
//        sb.append("\n");

        // BFS_REPETITION
        visited = new boolean[VERTEX + 1];
        BFS_ITERATION(START);

        return sb.toString();
    }

    public static void DFS_RECURSION(int x) { // 행을 하나씩 내려가면서(+1) 재귀
        visited[x] = true; // 방문
        sb.append(x).append(" ");

        for (int y = 1; y <= VERTEX; y++) { // 열을 작은 수(1)부터 하나씩 이동하면서(+1) 반복문
            if (board[x][y] == 1 && !visited[y]) {
                DFS_RECURSION(y);
            }
        }
    }

//    public static void DFS_ITERATION(int x) {
//        stack.push(x);
//
//        while (!stack.isEmpty()) {
//            Integer vertex = stack.pop();
//
//            if (visited[vertex]) continue;
//
//            visited[vertex] = true;
//            sb.append(vertex).append(" ");
//            for (int y = VERTEX; y >= 1; y--) {
//                if (board[vertex][y] == 1 && !visited[y]) {
//                    stack.push(y);
//                }
//            }
//        }
//    }

    public static void BFS_ITERATION(int x) {
        queue.add(x);
        visited[x] = true; // 최초 방문

        while (!queue.isEmpty()) {
            Integer vertex = queue.poll();
            sb.append(vertex).append(" ");

            for (int y = 1; y <= VERTEX; y++) { // 열을 작은 수(1)부터 하나씩 이동하면서(+1) 반복문
                if (board[vertex][y] == 1 && !visited[y]) {
                    queue.add(y);
                    visited[y] = true; // 방문
                }
            }
        }
    }


    public static void main(String[] args) throws IOException {
        System.out.println(solution());
    }
}
