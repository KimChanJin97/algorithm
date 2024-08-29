package mutsaStudy.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2805 {

    private static int[] arr;

    public static long solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        final int N = Integer.parseInt(st.nextToken());
        final int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine()," ");
        arr = new int[N];
        long right = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (right < arr[i]) {
                right = arr[i];
            }
        }

//        right++; // 배열의 길이로 right 를 측정하는 것이 아니기 때문에 right++ 할 필요없음
        long left = 0;
        long mid = 0;

        // upperBound 방식
        while (left < right) {

            mid = (left + right) / 2;
            long sum = 0;
            for (int i = 0; i < N; i++) {
                if (arr[i] - mid > 0) {
                    sum += (arr[i] - mid);
                }
            }

            // sum 이 M 보다 작다면 mid 를 감소시켜서 다시 빼봐야 함 -> 이분탐색 범위 왼쪽 이동
            if (sum < M) {
                right = mid;
            }
            // sum 이 M 보다 크다면 mid 를 증가시켜서 다시 빼봐야 함 -> 이분탐색 범위 오른쪽 이동
            else {
                left = mid + 1;
            }
        }

        return left - 1; // upperBound 이므로 -1
    }

    public static void main(String[] args) throws IOException {
        System.out.println(solution());
    }
}
