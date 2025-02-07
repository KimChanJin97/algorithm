package personalStudy.week14;

import java.io.*;
import java.util.*;

public class BOJ15649 {

    private static int[] arr;
    private static boolean[] visited;

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new int[M];
        visited = new boolean[N];

        DFS(N, M, 0);
    }

    private static void DFS(int N, int M, int depth) {
        StringBuilder sb = new StringBuilder();
        // 수열이 완성되었는지 판단한다.
        // 수열이 완성되었다면 수열을 출력한다.
        if (depth == M) {
            for (int v : arr) {
                sb.append(v).append(" ");
            }
            System.out.println(sb);
            return;
        }
        // 수열이 완성되지 않았다면 반복문을 순회하며 사용(방문)하지 않은 수를 탐색한다.
        for (int i = 0; i < N; i++) {
            // 반복문을 모두 순회할ㄷ 때까지 사용하지 않은 수를 발견한다면
            if (!visited[i]) {
                // 해당 숫자를 사용(방문)했다고 표시하고
                visited[i] = true;
                // 숫자 + 1 을 수열에 대입하고
                arr[depth] = i + 1;
                // 사용(방문)하지 않은 수를 더 탐색하기 위해 재귀 함수를 호출한다.
                DFS(N, M, depth + 1);
                // 재귀 함수 호출 시점에 사용(방문)한 수를 원상복구한다.
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
