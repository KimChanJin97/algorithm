package personalStudy.week10;

import java.io.*;
import java.util.*;

public class BOJ1865_BellmanFord {

    private static StringTokenizer st;
    private static List<Node>[] graph;
    private static int[] dp;
    private static int node, road, wormHall;
    private static final int INF = Integer.MAX_VALUE;
    private static StringBuilder sb = new StringBuilder();

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        while (tc-- > 0) {
            st = new StringTokenizer(br.readLine());
            node = Integer.parseInt(st.nextToken());
            road = Integer.parseInt(st.nextToken());
            wormHall = Integer.parseInt(st.nextToken());

            // 그래프, dp 초기화
            graph = new ArrayList[node + 1];
            dp = new int[node + 1];
            for (int i = 1; i <= node; i++) {
                graph[i] = new ArrayList<>();
                dp[i] = INF;
            }

            for (int i = 1; i <= road; i++) {
                st = new StringTokenizer(br.readLine());
                int src = Integer.parseInt(st.nextToken());
                int dst = Integer.parseInt(st.nextToken());
                int time = Integer.parseInt(st.nextToken());
                graph[src].add(new Node(dst, time));
                graph[dst].add(new Node(src, time));
            }

            for (int i = 1; i <= wormHall; i++) {
                st = new StringTokenizer(br.readLine());
                int src = Integer.parseInt(st.nextToken());
                int dst = Integer.parseInt(st.nextToken());
                int time = Integer.parseInt(st.nextToken());
                graph[src].add(new Node(dst, -time));
            }

            // 모든 지점이 연결되었다는 보장이 없기 때문에 모든 지점을 출발지로 설정하여 모두 탐색
            boolean hasMinusCycle = false;
            for (int i = 1; i <= node; i++) {
                // 음의 사이클이 존재한다면
                if (bellmanFord(i)) {
                    hasMinusCycle = true;
                    sb.append("YES\n");
                    break;
                }
            }

            // 음의 사이클이 존재하지 않다면
            if (!hasMinusCycle) {
                sb.append("NO\n");
            }
        }

        System.out.println(sb);
    }

    private static boolean bellmanFord(int start) {
        dp[start] = 0;
        boolean update = false;

        // 도로가 1 개일 때부터 node - 1 개일 때까지의 모든 경우에 대하여
        for (int edge = 1; edge < node; edge++) {
            // (매번 업데이트 초기화) **중요**
            update = false;
            // 각 지점에서
            for (int vertex = 1; vertex <= node; vertex++) {
                // 지점을 방문하지 않았다면 패스
                if (dp[vertex] == INF) {
                    continue;
                }
                // 이동가능한 지점을 방문하며
                for (Node node : graph[vertex]) {
                    // 최단경로라면 갱신
                    if (dp[node.dst] > dp[vertex] + node.time) {
                        dp[node.dst] = dp[vertex] + node.time;
                        update = true;
                    }
                }
            }
            // 도로가 i 개일 때 모든 지점에 대하여 최단경로를 탐색했을 때 갱신이 이뤄지지 않았다면 종료
            if (!update) {
                break;
            }
        }

        // 만약 단 한번이라도 갱신이 있었다면
        if (update) {
            // 각 지점에서
            for (int vertex = 1; vertex <= node; vertex++) {
                // 이동가능한 지점을 방문하며
                for (Node node : graph[vertex]) {
                    // 해당 지점을 방문하지 않았다면 패스
                    if (dp[vertex] == INF) {
                        continue;
                    }
                    // 최단경로라면 음의 사이클이 존재함을 반환
                    if (dp[node.dst] > dp[vertex] + node.time) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    static class Node implements Comparable<Node> {
        int dst;
        int time;

        public Node(int dst, int time) {
            this.dst = dst;
            this.time = time;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.time, o.time);
        }
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
