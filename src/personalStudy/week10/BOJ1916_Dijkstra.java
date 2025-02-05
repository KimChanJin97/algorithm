package personalStudy.week10;

import java.io.*;
import java.util.*;

public class BOJ1916_Dijkstra {

    private static int city, bus;
    private static List<City>[] graph;
    private static int[] dp;
    private static boolean[] visited;
    private static StringTokenizer st;

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        city = Integer.parseInt(br.readLine());
        bus = Integer.parseInt(br.readLine());

        graph = new ArrayList[city + 1];
        for (int i = 1; i <= city; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 1; i <= bus; i++) {
            st = new StringTokenizer(br.readLine());
            int src = Integer.parseInt(st.nextToken());
            int dst = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph[src].add(new City(dst, cost));
        }

        dp = new int[city + 1];
        Arrays.fill(dp, 987654321);

        visited = new boolean[city + 1];

        st = new StringTokenizer(br.readLine());
        int src = Integer.parseInt(st.nextToken());
        int dst = Integer.parseInt(st.nextToken());

        System.out.println(dijkstra(src, dst));
    }

    private static int dijkstra(int src, int dst) {
        dp[src] = 0;
        PriorityQueue<City> pq = new PriorityQueue();
        pq.add(new City(src, 0));

        while (!pq.isEmpty()) {
            City now = pq.poll();

            // 현재 도시에 방문한 적이 있다면 방문한 그 시점이 최단경로 (최단경로 구할 필요없음)
            if (!visited[now.dst]) {
                visited[now.dst] = true;

                // 현재 도시와 연결된 모든 다음 도시에 대하여 최단경로 탐색
                for (City next : graph[now.dst]) {
                    // 다음 도시에 방문한 적이 없고 최단경로라면
                    if (!visited[next.dst] && dp[next.dst] > dp[now.dst] + next.cost) { //
                        // 최단경로 갱신
                        dp[next.dst] = dp[now.dst] + next.cost;
                        // 다음 도시와 연결된 다다음 도시에 대하여 최단경로 탐색하기 위해 인큐
                        pq.add(new City(next.dst, dp[next.dst]));
                    }
                }
            }
        }
        return dp[dst];
    }

    private static class City implements Comparable<City> {
        int dst;
        int cost;

        public City(int dst, int cost) {
            this.dst = dst;
            this.cost = cost;
        }

        @Override
        public int compareTo(City o) {
            return this.cost - o.cost;
        }
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
