package mutsaStudy.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ12015_BS {

    private static int[] arr;
    private static int[] LIS;
    private static int N;

    private static int solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        LIS = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        LIS[0] = arr[0];
        int len = 1;
        for (int i = 1; i < N; i++) {
            int key = arr[i];
            int last = LIS[len - 1]; // 증가하는 부분 수열(LIS)의 마지막 요소
            // 만약 last 보다 더 큰 key 를 발견한다면 last 뒤에 key 를 추가
            if (last < key) {
                LIS[len] = key;
                len++;
            }
            // 만약 last 보다 더 큰 key 를 발견하지 못한다면 last 이전 범위에서 key 를 추가할 인덱스를 이분탐색
            // key 는 최초 이상 값(lowerBound)에 대입해야 함
            // 길이를 구하면 되니깐 추가가 아니라 대입이어도 문제 없음
            // 그리고 추가해버리면 중복 원소가 생길 수 있음
            else {
                int lo = 0;
                int hi = len;
                while (lo < hi) {
                    int mid = lo + (hi - lo) / 2;
                    // key 가 작다 = 탐색 범위를 줄여라
                    if (key <= LIS[mid]) {
                        hi = mid;
                    }
                    // key 가 크다 = 탐색 범위를 올려라
                    else {
                        lo = mid + 1;
                    }
                }
                LIS[lo] = key;
            }
        }

        return len;
    }

    public static void main(String[] args) throws IOException {
        System.out.println(solution());
    }
}
