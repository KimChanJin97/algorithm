package mutsaStudy.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1654 {

    private static int[] arr;

    public static long solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        // arr 채우기 & right 구하기
        // right 는 이분탐색(upperBound)을 위해 필요하다
        long right = 0;
        arr = new int[K];
        for (int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            if (right < arr[i]) {
                right = arr[i];
            }
        }

        right += 1; // upperBound 이므로 upperBound + 1

        long left = 0;
        long mid = 0;

        // upperBound 방식
        while (left < right) {

            mid = (left + right) / 2;

            // 랜선을 mid 로 나눴을 때 몇 개가 나오는지 판단
            int count = 0;
            for (int i = 0; i < K; i++) {
                count += (arr[i] / mid);
            }

            // 나눈 값이 만약 N 개보다 작다면 mid 를 감소시켜서 다시 나눠봐야 함 -> 이분탐색 범위 왼쪽 이동
            if (count < N) {
                right = mid;
            }
            // 나눈 값이 만약 N 개보다 크다면 mid 를 증가시켜서 다시 나눠봐야 함 -> 이분탐색 범위 오른쪽 이동
            else {
                left = mid + 1;
            }
        }

        return left - 1; // upperBound 이므로 마지막에 -1
    }

    public static void main(String[] args) throws IOException {
        System.out.println(solution());
    }
}
