package personalStudy.week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11047 {

    private static Integer[] arr;

    private static int solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        arr = new Integer[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int count = 0;
        for (int i = N - 1; i >= 0; i--) {
            if (K >= arr[i]) {
                int x = K / arr[i];
                K -= arr[i] * x;
                count += x;
            }
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        System.out.println(solution());
    }
}
