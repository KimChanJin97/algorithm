package week7;

import java.util.Scanner;

public class BOJ9655 {

    static String solution() {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        if (N % 2 == 0) {
            return "CY";
        }
        return "SK";
    }

    public static void main(String[] args) {
        System.out.println(solution());
    }
}


// 1 -> 상근1 승
// 2 -> 상근1 창영1 승
// 3 -> 상근3 승
// 4 -> 상근1 창영3 승 || 상근3 창영1 승 || 상근1 창영1 상근1 창영1 승
// 5 -> 상근1 창영1 상근1 창영1 상근1 승 || 상근1 창영1 상근3 승 || 상근1 창영3 상근1 승
// ...
// 홀수 상근 승 / 짝수 창영 승
