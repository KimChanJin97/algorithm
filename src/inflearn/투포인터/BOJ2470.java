package inflearn.투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2470 {

    private static int[] arr;
    private static int[] answer;

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N];
        answer = new int[2];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int lo = 0, hi = N - 1, min = Integer.MAX_VALUE;
        while (lo < hi) {
            int sum = arr[lo] + arr[hi];

            if (min > Math.abs(sum)) { // sum 이 양수 또는 음수일 수 있기 때문에 0 과의 거리를 구하기 위해 절대값으로 변환
                min = Math.abs(sum); // 0 과의 거리 갱신
                answer[0] = arr[lo];
                answer[1] = arr[hi];
                if (sum == 0) break;
            }

            if (sum < 0) { // 합이 음수라면 lo 를 올려라
                lo++;
            } else { // 합이 양수라면 hi 를 내려라
                hi--;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        solution();
        System.out.println(answer[0] + " " + answer[1]);
    }
}
