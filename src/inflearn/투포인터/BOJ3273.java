package inflearn.투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ3273 {

    private static int answer;
    private static int[] arr;

    private static int solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int x = Integer.parseInt(br.readLine());

        for (int p1 = 0; p1 < n; p1++) {
            int src = arr[p1];
            for (int p2 = p1 + 1; p2 < n; p2++) {
                if (x - src == arr[p2]) {
                    answer++;
                    break;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        System.out.println(solution());
    }
}
