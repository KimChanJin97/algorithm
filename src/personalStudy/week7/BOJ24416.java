package personalStudy.week7;

import java.util.Scanner;

public class BOJ24416 {

    static int[] f = new int[41];
    static int fib = 0;
    static int fibonacci = 0;

    static String solution() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        fib(n);
        fibonacci(n);

        StringBuilder sb = new StringBuilder();
        sb.append(fib + 1).append(" ").append(fibonacci + 1);

        return sb.toString();
    }

    static int fib(int n) {
        if (n == 1 || n == 2) return 1;
        fib++;
        return fib(n - 1) + fib(n - 2);
    }

    static int fibonacci(int n) {
        f[1] = f[2] = 1;
        for (int i = 3; i < n; i++) {
            fibonacci++;
            f[i] = f[i - 1] + f[i - 2];
        }
        return f[n];
    }

    public static void main(String[] args) {
        System.out.println(solution());
    }
}
