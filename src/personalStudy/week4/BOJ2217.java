package personalStudy.week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class BOJ2217 {

    private static Integer[] arr;

    private static int solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        arr = new Integer[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr, Comparator.reverseOrder());

        int lift = 0;
        for (int i = 0; i < N; i++) {
            lift = Math.max(lift, arr[i] * (i + 1));
        }

        return lift;
    }

    public static void main(String[] args) throws IOException {
        System.out.println(solution());
    }
}
