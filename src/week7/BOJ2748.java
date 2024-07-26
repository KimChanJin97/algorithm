package week7;

import java.util.Scanner;

public class BOJ2748 {

    public static long[] arr;

    public static long solution() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        // 메모리제이션을 위한 배열 초기화
        arr = new long[n + 1];
        for (int i = 0; i <= n; i++) {
            arr[i] = -1;
        }

        // idx0, idx1 에 대해 초기화
        arr[0] = 0;
        arr[1] = 1;

        return fibo(n);
    }

    public static long fibo(int n) {
        if (arr[n] == -1) { // 초기화되지 않았다면
            arr[n] = fibo(n - 1) + fibo(n - 2);
        }
        // 초기화되었다면 (최초에는 이미 초기화된 arr[0], arr[1] 부터 시작하여 arr[2] ... 초기화 진행)
        return arr[n];
    }

    public static void main(String[] args) {
        System.out.print(solution());
    }
}
