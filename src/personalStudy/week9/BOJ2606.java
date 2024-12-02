package personalStudy.week9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2606 {

    private static int[][] arr;
    private static boolean[] visited;
    private static int node;
    private static int edge;
    private static StringTokenizer st;
    private static final int START = 1;

    private static int solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        node = Integer.parseInt(br.readLine());
        edge = Integer.parseInt(br.readLine());

        arr = new int[node + 1][node + 1];
        visited = new boolean[node + 1];

        for (int i = 0; i < edge; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[y][x] = arr[x][y] = 1;
        }

        return BFS();
    }

    private static int BFS() {
        int count = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(START);
        visited[START] = true;
        while (!queue.isEmpty()) {
            Integer y = queue.poll();
            for (int x = 1; x <= node; x++) { // 가로로 훑기
                if (!visited[x] && arr[y][x] == 1) {
                    queue.add(x);
                    visited[x] = true;
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        System.out.println(solution());
    }
}
