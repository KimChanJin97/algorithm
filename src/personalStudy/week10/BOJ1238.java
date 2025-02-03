package personalStudy.week10;

import java.io.*;
import java.util.*;

public class BOJ1238 {

    private static int house, road, partyHouse;
    private static StringTokenizer st;
    private static List<House>[] houses, reverseHouses;

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        house = Integer.parseInt(st.nextToken());
        road = Integer.parseInt(st.nextToken());
        partyHouse = Integer.parseInt(st.nextToken());

        houses = new ArrayList[house + 1];
        reverseHouses = new ArrayList[house + 1];

        for (int i = 1; i <= house; i++) {
            houses[i] = new ArrayList();
            reverseHouses[i] = new ArrayList();
        }

        for (int i = 0; i < road; i++) {
            st = new StringTokenizer(br.readLine());
            int src = Integer.parseInt(st.nextToken());
            int dst = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            houses[src].add(new House(dst, cost));
            reverseHouses[dst].add(new House(src, cost));
        }

        final int[] VISIT_DP = dijkstra(reverseHouses);
        final int[] RETURN_DP = dijkstra(houses);

        int answer = 0;
        for (int i = 1; i <= house; i++) {
            answer = Math.max(answer, VISIT_DP[i] + RETURN_DP[i]);
        }

        System.out.println(answer);
    }

    private static int[] dijkstra(List<House>[] towns) {
        Queue<House> pq = new PriorityQueue<>(house + 1);
        boolean[] visited = new boolean[house + 1];
        int[] dp = new int[house + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[partyHouse] = 0;

        pq.add(new House(partyHouse, 0));
        while (!pq.isEmpty()) {
            House now = pq.poll();

            // 이미 방문했다면 최단거리를 구할 수 없다
            if (!visited[now.dst]) {
                visited[now.dst] = true;

                // 현재 집과 이어진 다음 집들을 모두 순회
                for (House next : towns[now.dst]) {

                    // "다음 집까지의 최단경로 > 현재 집까지의 최단경로 + 다음 집으로 가는 데 걸리는 비용" 이라면
                    if (dp[next.dst] > dp[now.dst] + next.cost) {
                        // 최단경로 갱신
                        dp[next.dst] = dp[now.dst] + next.cost;
                        // 다음 집과 이어진 다다음 집들을 모두 순회하기 위해 인큐
                        pq.add(new House(next.dst, dp[next.dst]));
                    }
                }
            }
        }
        return dp;
    }

    static class House implements Comparable<House> {
        int dst;
        int cost;

        public House(int dst, int cost) {
            this.dst = dst;
            this.cost = cost;
        }

        @Override
        public int compareTo(House o) {
            return this.cost - o.cost;
        }
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
