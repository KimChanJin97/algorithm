package personalStudy.week10;

import java.io.*;
import java.util.*;

public class BOJ13549_Dijkstra {

    private static int N, K;
    private static final int INF = 100_000;
    private static final int MAX = 100_000;

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int[] dp = new int[MAX + 1];
        Arrays.fill(dp, INF);

        Queue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(N, 0));

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int index = node.index;
            int time = node.time;

            // 이미 최단시간이 최신화된 상태라면 패스
            if (dp[node.index] < node.time) {
                continue;
            }

            // 한칸 후진을 가정했을 때 최단시간이라면 최신화
            int backwardIndex = index - 1;
            int time1 = time + 1;
            if (canMove(backwardIndex) && dp[backwardIndex] > time1) {
                dp[backwardIndex] = time1;
                pq.add(new Node(backwardIndex, time1));
            }

            // 한칸 전진을 가정했을 때 최단시간이라면 최신화
            int forwardIndex = index + 1;
            int time2 = time + 1;
            if (canMove(forwardIndex) && dp[forwardIndex] > time2) {
                dp[forwardIndex] = time2;
                pq.add(new Node(forwardIndex, time2));
            }

            // 순간이동을 가정했을 때 최단시간이라면 최신화
            int teleportIndex = index * 2;
            if (canMove(teleportIndex) && dp[teleportIndex] > time) {
                dp[teleportIndex] = time;
                pq.add(new Node(teleportIndex, time));
            }
        }

        int minTime;
        if (N >= K) { // 후진만 해야 한다면 또는 제자리라면
            minTime = N - K;
        } else {
            minTime = dp[K];
        }

        System.out.println(minTime);
    }

    private static boolean canMove(int movedIndex) {
        return 0 <= movedIndex && movedIndex <= MAX;
    }

    private static class Node implements Comparable<Node> {
        int index;
        int time;

        public Node(int index, int time) {
            this.index = index;
            this.time = time;
        }

        @Override
        public int compareTo(Node o) {
            return this.time - o.time;
        }
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
