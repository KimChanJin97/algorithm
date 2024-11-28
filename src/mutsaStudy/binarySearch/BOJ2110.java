package mutsaStudy.binarySearch;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ2110 {

    private static int[] house;

    private static int solution() {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        house = new int[N];
        int M = sc.nextInt();

        for (int i = 0; i < N; i++) {
            house[i] = sc.nextInt();
        }
        Arrays.sort(house);

        int lo = 1; // 공유기 설치 최소 간격
        int hi = house[N - 1] - house[0] + 1; // 공유기 설치 최대 간격 + 1

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (canInstall(mid) < M) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo - 1;
    }

    private static int canInstall(int mid) {
        // 첫번째(0) 집에 공유기 설치 가정
        int installCount = 1;
        int installHouseIndex = house[0];

        // 두번째(1) 집부터 공유기 설치 시작
        for (int i = 1; i < house.length; i++) {
            int houseIndex = house[i];
            if (houseIndex - installHouseIndex >= mid) {
                installCount++;
                installHouseIndex = houseIndex;
            }
        }
        return installCount;
    }

    public static void main(String[] args) {
        System.out.println(solution());
    }
}
