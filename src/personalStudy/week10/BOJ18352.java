package personalStudy.week10;

import java.io.*;
import java.util.*;

public class BOJ18352 {

    private static StringTokenizer st;
    private static List<Integer> answer = new ArrayList<>();

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        int city = Integer.parseInt(st.nextToken());
        int road = Integer.parseInt(st.nextToken());
        int dist = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());

        // List<Integer> 로 초기화하는 이유: Integer 는 기본값이 0 임. 특정값으로 초기화하지 않고 빈 리스트로 초기화하기 위해
        // cityCount + 1 로 배열을 초기화하는 이유: 도시는 1부터 시작하기 때문에 편의상
        List<Integer>[] vertexes = new ArrayList[city + 1]; // 배열 초기화 (outer)

        for (int i = 1; i <= city; i++) {
            vertexes[i] = new ArrayList<>(); // 리스트 초기화 (inner), null 방지
        }

        for (int i = 0; i < road; i++) {
            st = new StringTokenizer(br.readLine());
            int src = Integer.parseInt(st.nextToken());
            int dst = Integer.parseInt(st.nextToken());
            vertexes[src].add(dst);
        }

        int[] dp = new int[city + 1];

        Arrays.fill(dp, Integer.MAX_VALUE); // 도시를 방문하며 최단거리를 판단하여 갱신해야 하므로 최대값으로 모두 초기화
        // MAX_VALUE 는 최단거리가 한번도 갱신된 적이 없음을 의미
        dp[start] = 0; // 그 중 시작할 도시의 최단거리만 다시 0 으로 초기화

        Queue<Integer> pq = new LinkedList<>();
        pq.add(start);

        while (!pq.isEmpty()) {
            int src = pq.poll(); // 시작할 도시
            int dstCount = vertexes[src].size(); // 가야할 도시의 갯수

            for (int i = 0; i < dstCount; i++) {
                int dst = vertexes[src].get(i);
                if (dp[dst] > dp[src] + 1) { // src 에서 dst 로 가는 것이 dst 로의 최단거리보다 작다면
                    dp[dst] = dp[src] + 1; // src 에서 dst 로 가는 것이 최단거리이므로 최단거리 갱신
                    pq.add(dst); // dst 를 src 로 설정해서 dst 에서 또다른 dst 로의 최단거리를 구할 준비
                }
            }
        }

        for (int i = 1; i <= city; i++) {
            if (dp[i] == dist) {
                answer.add(i);
            }
        }

        if (answer.size() == 0) {
            System.out.println(-1);
        } else {
            Collections.sort(answer);
            for (int i = 0; i < answer.size(); i++) {
                System.out.println(answer.get(i));
            }
        }
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
