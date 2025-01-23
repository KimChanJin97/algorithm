package personalStudy.week10;

import java.io.*;
import java.util.*;

public class BOJ11657_BellmanFord {

    private static StringTokenizer st;
    private static long[] dp;
    private static List<Bus>[] buses;
    private static final int INF = Integer.MAX_VALUE;
    private static int city, line;

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        city = Integer.parseInt(st.nextToken());
        line = Integer.parseInt(st.nextToken());

        // 버스 초기화 (빈 리스트로 npe 방지)
        buses = new ArrayList[city + 1];
        dp = new long[city + 1];
        for (int i = 1; i <= city; i++) {
            buses[i] = new ArrayList<>();
            dp[i] = INF;
        }
        // 버스 초기화 (입력값 넣기)
        for (int i = 0; i < line; i++) {
            st = new StringTokenizer(br.readLine());
            int src = Integer.parseInt(st.nextToken());
            int dst = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            buses[src].add(new Bus(dst, cost));
        }

        StringBuilder sb = new StringBuilder();
        if (bellmanFord()) {
            sb.append("-1\n");
        } else {
            for (int i = 2; i <= city; i++) {
                if (dp[i] == INF) {
                    sb.append("-1\n");
                } else {
                    sb.append(dp[i] + "\n");
                }
            }
        }
        System.out.println(sb);
    }

    public static boolean bellmanFord() {
        dp[1] = 0;
        boolean update = false;

        for (int i = 1; i < city; i++) {
            update = false;

            for (int j = 1; j <= city; j++) {

                for (Bus bus : buses[j]) {
                    if (dp[j] == INF) {
                        continue;
                    }
                    // 해당 정점에 도달하기까지의 최소시간이 더 크다면 최소시간 갱신
                    if (dp[bus.dst] > dp[j] + bus.cost) {
                        dp[bus.dst] = dp[j] + bus.cost;
                        update = true;
                    }
                }
            }
            // 갱신이 이뤄지지 않았다면 최단거리 계산이 완료된 것이므로 반복문 종료
            if (!update) {
                break;
            }
        }

        // 모든 간선, 모든 정점에 대해 최단거리를 갱신한 이후에 음의 가중치 사이클 존재 여부를 판단
        if (update) {
            for (int i = 1; i <= city; i++) {
                for (Bus bus : buses[i]) {
                    if (dp[i] == INF) {
                        continue;
                    }
                    // 만약 최단거리 갱신이 또 가능하다면 음의 가중치 사이클이 존재한다는 것
                    if (dp[bus.dst] > dp[i] + bus.cost) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private static class Bus {
        int dst;
        int cost;

        public Bus(int dst, int cost) {
            this.dst = dst;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}