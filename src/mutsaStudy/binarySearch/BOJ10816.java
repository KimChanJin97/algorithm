package mutsaStudy.binarySearch;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ10816 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int N = in.nextInt();
        int[] arr = new int[N];

        for(int i = 0; i < N; i++) {
            arr[i] = in.nextInt();
        }

        Arrays.sort(arr);

        int M = in.nextInt();

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < M; i++) {
            int key = in.nextInt();
            sb.append(upperBound(arr, key) - lowerBound(arr, key)).append(' ');
        }
        System.out.println(sb);
    }

    private static int lowerBound(int[] arr, int key) { // key 이상의 값이 최초로 발견되는 인덱스
        int lo = 0;
        int hi = arr.length;
        // arr.length - 1 하지 않는 이유
        // 1. 배열 사이즈가 1일 경우 lo = 0, hi = 0 가 되어 while 진입 불가하기 때문

        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (key <= arr[mid]) { // = 조건이 붙은 이유는 key "이상(=포함)"의 값이 최초로 발견되는 인덱스를 구하기 위함
                hi = mid; // 조건이 key <= arr[mid] 이므로 arr[mid] hi = mid 하더라도 arr[hi - x] 는 key "이하"이기 때문에 옳다 (정렬 가정)
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }

    private static int upperBound(int[] arr, int key) { // key 를 초과하는 값이 최초로 발견되는 인덱스
        int lo = 0;
        int hi = arr.length;
        // arr.length - 1 하지 않는 이유
        // 1. 배열 사이즈가 1일 경우 lo = 0, hi = 0 가 되어 while 진입 불가해서 무조건 0 을 반환하게 됨
        // 2. hi 위치 조정없이 배열의 끝까지 도달할 경우 lo == arr.length - 1 && arr.lenght - 1 == hi 가 되어
        //    key 를 초과하는 값이 최초로 발견되는 인덱스 - 1 를 구하게 되기 때문

        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (key < arr[mid]) { // = 조건이 붙지 않은 이유는 key를 "초과(=미포함)"하는 값이 최초로 발견되는 인덱스를 구하기 위함
                hi = mid; // 조건이 key < arr[mid] 이므로 hi = mid 하더라도 arr[hi] 는 key 를 "초과"하기 때문에 옳다 (정렬 가정)
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }

    // int hi = arr.length 이해를 위한 반례
    // 1
    // 1
    // 2
    // 1 1
    // ans : 1 1

    // upperBound 메서드에서 key < arr[mid] 조건을 이해하기 위한 반례
    // lowerBound 메서드에서 key <= arr[mid] 조건을 이해하기 위한 반례
    // 11
    // 1 2 2 4 4 4 6 7 8 9 10
    // 8
    // 10 9 -5 2 3 4 5 -10
    // ans : 1 1 0 2 0 3 0 0
}