package mutsaStudy.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1920 {

    private static int[] Ns;
    private static int[] Ms;

    private static StringTokenizer st;
    private static StringBuilder sb;

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N과 N개의 자연수 입력
        int N = Integer.parseInt(br.readLine());
        Ns = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            Ns[i] = Integer.parseInt(st.nextToken());
        }

        // M과 M개의 자연수 입력
        int M = Integer.parseInt(br.readLine());
        Ms = new int[M];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < M; i++) {
            Ms[i] = Integer.parseInt(st.nextToken());
        }
        // 비교기준(N) >= 비교대상(M)

        Arrays.sort(Ns); // 이진탐색은 무조건 정렬되어 있어야 함

        sb = new StringBuilder();
        for (int j = 0; j < M; j++) {
            int left = 0;
            int right = N - 1;
            while (true) {
                int mid = (left + right) / 2;
                if (left > right) { // left 가 right 를 초과했다면 존재하지 않다는 것
                    sb.append(0).append("\n");
                    break;
                } else if (Ms[j] == Ns[mid]) { // Ms의 요소가 비교대상의 중간값과 동일하다면 기록
                    sb.append(1).append("\n");
                    break;
                } else if (Ms[j] < Ns[mid]) { // Ms의 요소가 비교대상보다 작다면 비교 범위를 왼쪽으로 이동
                    right = mid - 1;
                } else { // Ms의 요소가 비교대상보다 크다면 비교 범위를 오른쪽으로 이동
                    left = mid + 1;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        solution();
        System.out.println(sb);
    }
}
