package personalStudy.week9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//   0 1 2 3 4
// 0 - - - - -
// 1 - 0 1 1 1
// 2 -   0 0 1
// 3 -     0 1
// 4 -       0

public class BOJ1260 {

    private static int[][] arr;
    private static boolean[] visited;
    private static int node;
    private static int edge;
    private static int start;
    private static final StringBuilder SB = new StringBuilder();

    private static String solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        node = Integer.parseInt(st.nextToken()); // 1 이상 1,000 이하
        edge = Integer.parseInt(st.nextToken()); // 1 이상 10,000 이하
        start = Integer.parseInt(st.nextToken());

        arr = new int[node + 1][node + 1];
        visited = new boolean[node + 1];

        for (int i = 0; i < edge; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[y][x] = arr[x][y] = 1;
        }

        DFS(start);

        SB.append("\n");

        visited = new boolean[node + 1];
        BFS();

        return SB.toString();
    }

    private static void DFS(int y) {
        visited[y] = true;
        SB.append(y).append(" ");
        for (int x = 1; x <= node; x++) { // 가로로 훑기
            if (!visited[x] && arr[y][x] == 1) {
                DFS(x);
            }
        }
    }

    private static void BFS() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;
        SB.append(start).append(" ");
        while (!queue.isEmpty()) {
            Integer y = queue.poll();
            for (int x = 1; x <= node; x++) { // 가로로 훑기
                if (!visited[x] && arr[y][x] == 1) {
                    queue.add(x);
                    visited[x] = true;
                    SB.append(x).append(" ");
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        System.out.println(solution());
    }
}
