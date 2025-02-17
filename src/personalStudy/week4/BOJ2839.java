package personalStudy.week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2839 {

    private static int count = 0;

    private static int solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        while (n > 0) {
            // 둘 다 나눌 수 없다면 5 빼기
            if (n % 5 != 0 && n % 3 != 0) {
                n -= 5;
                count++;
            }
            // 5로 나눌 수 있다면 5 빼기
            else if (n % 5 == 0) {
                n -= 5;
                count++;
            }
            // 3으로 나눌 수 있다면 3 빼기
            else if (n % 3 == 0) {
                n -= 3;
                count++;
            }
        }

        // 설탕을 정확히 n킬로그램 배달할 수 있다면
        if (n == 0) {
            return count;
        }
        // 설탕을 정확히 n킬로그램 배달할 수 없다면
        return -1;
    }

    public static void main(String[] args) throws IOException {
        System.out.println(solution());
    }
}
