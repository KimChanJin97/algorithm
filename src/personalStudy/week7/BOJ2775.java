package personalStudy.week7;

import java.util.Scanner;

public class BOJ2775 {

    static String solution() {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();

        // 초기화
        int[][] apartment = new int[15][15];
        for (int i = 0; i <= 14; i++) { // 0층 ~ 14층 1호
            apartment[i][1] = 1;
        }
        for (int i = 1; i <= 14; i++) { // 0층 1호 ~ 14호
            apartment[0][i] = i;
        }

        // DP
        for (int i = 1; i <= 14; i++) {
            for (int j = 2; j <= 14; j++) {
                apartment[i][j] = apartment[i][j - 1] + apartment[i - 1][j];
                // 첫번째 인자 : 바로 좌측값이 (k-1)층 (n-1)호 까지의 모든 사람 수 총합
                // 두번째 인자 : 바로 아래값
            }
        }

        // 답 구하기
        StringBuilder sb = new StringBuilder();
        while (tc-- > 0) {
            int floor = sc.nextInt();
            int room = sc.nextInt();
            sb.append(apartment[floor][room]).append("\n");
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(solution());
    }
}
