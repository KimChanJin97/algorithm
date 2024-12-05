package personalStudy.week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ10162 {

    private static final int A = 300;
    private static final int B = 60;
    private static final int C = 10;
    private static final String NONE = "-1";
    private static final StringBuilder SB = new StringBuilder();

    private static String solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        if (N % 10 != 0) {
            return NONE;
        }

        else {
            int tmp = 0;
            if (N - A >= 0) { // 300
                tmp = N / A;
                N %= A;
            }
            SB.append(tmp).append(" ");

            tmp = 0;
            if (N - B >= 0) { // 60
                tmp = N / B;
                N %= B;
            }
            SB.append(tmp).append(" ");

            tmp = 0;
            if (N - C >= 0) { // 10
                tmp = N / C;
            }
            SB.append(tmp).append(" ");
        }

        return SB.toString();
    }

    public static void main(String[] args) throws IOException {
        System.out.println(solution());
    }
}
