package mutsaStudy.binarySearch;

import java.util.Scanner;

public class BOJ1300 {

    /***
     * 3 * 3
     *   1 2 3
     * 1 1 2 3
     * 2 2 4 6
     * 3 3 6 9
     *
     * -> 1 2 2 3 3 4 6 6 9
     *
     * 4 * 4
     *    1  2  3  4
     * 1  1  2  3  4
     * 2  2  4  6  8
     * 3  3  6  9  12
     * 4  4  8  12 16
     *
     * -> 1 2 2 3 3 4 4 4 6 6 8 8 9 12 12 16
     *
     * [ 핵심 포인트 ]
     * B[K] = X
     * X 보다 작거나 같은 숫자는 K 개 존재
     */

    private static int solution() {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        int lo = 1;
        int hi = K;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            int key = 0;
            for (int i = 1; i <= N; i++) {
                key += Math.min(mid / i, N);
            }
            // key 가 크다면 hi 감소
            if (K <= key) {
                hi = mid;
            }
            // key 가 작다면 lo 증가
            else {
                lo = mid + 1;
            }
        }
        return lo;
    }

    public static void main(String[] args) {
        System.out.println(solution());
    }
}
