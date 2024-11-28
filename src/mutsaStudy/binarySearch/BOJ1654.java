package mutsaStudy.binarySearch;

import java.util.Scanner;

public class BOJ1654 {

    private static int[] arr;

    private static long solution() {
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt();
        int N = sc.nextInt();

        arr = new int[K];
        long max = 0;
        for (int i = 0; i < K; i++) {
            arr[i] = sc.nextInt();
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        max++;
        long min = 1;
        while (min < max) {
            long mid = min + (max - min) / 2;
            int key = 0;
            for (long i : arr) {
                key += i / mid;
            }
            // key 가 작다면 max 감소 (더 작은 값으로 나눠서 key 증가)
            if (key < N) { // upper bound
                max = mid;
            }
            // key 가 크다면 min 증가 (더 큰 값으로 나눠서 key 감소)
            else {
                min = mid + 1;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        System.out.println(solution() - 1); // upper bound 는 key 초과 최초값이므로 마지막에 - 1
    }
}
