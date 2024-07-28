package week7;

import java.util.Scanner;

public class BOJ11726 {

    // 규칙 찾아서 점화식 구하기
    // + 메모리제이션 사용

    static int solution() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[1001];
        arr[1] = 1;
        arr[2] = 2;

        for (int i = 3; i <= 1000; i++) {
            arr[i] = (arr[i - 2] + arr[i - 1]) % 10_007;
        }

        return arr[n];
    }

    public static void main(String[] args) {
        System.out.println(solution());
    }
}