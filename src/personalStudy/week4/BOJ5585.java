package personalStudy.week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ5585 {

    private static final int[] arr = {500, 100, 50, 10, 5, 1};

    private static int solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = 1000 - Integer.parseInt(br.readLine());

        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (n >= arr[i]) {
                int x = n / arr[i];
                n -= arr[i] * x;
                count += x;
            }
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        System.out.println(solution());
    }
}
