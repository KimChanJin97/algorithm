package mutsaStudy.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2110 {

    private static int[] houses;

    public static long solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        houses = new int[N];
        for (int i = 0; i < N; i++) {
            houses[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(houses);

        long left = 1;
        long right = houses[N - 1] - houses[0] + 1; // upperBound 형식이므로 +1

        while (left < right) { // upperBound 형식
            long mid = (left + right) / 2;

            int count = 1;
            int lastLocate = houses[0];
            for (int i = 1; i < N; i++) {
                int locate = houses[i];
                if (locate - lastLocate >= mid) {
                    count++;
                    lastLocate = locate;
                }
            }

            if (count < C) { // 설치개수가 C 보다 작다면 mid(설치간격)이 컸기 때문임 -> 이분탐색 범위를 왼쪽으로 이동
                right = mid; // 조건이 count < C 이기 때문에 right = mid 하더라도 arr[right] 는 무조건 arr[mid] 를 초과하기 때문에 옳다 (정렬 가정)
            } else { // 설치개수가 C 보다 크다면 mid(설치간격)이 작았기 때문임 -> 이분탐색 범위를 오른쪽으로 이동
                left = mid + 1;
            }
        }

        return left - 1; // upperBound 방식이기 때문에 -1
    }

    public static void main(String[] args) throws IOException {
        System.out.println(solution());
    }
}
