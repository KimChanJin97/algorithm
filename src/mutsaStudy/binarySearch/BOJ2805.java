package mutsaStudy.binarySearch;

import java.util.Scanner;

public class BOJ2805 {

    private static int[] tree;

    private static int solution() {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int key = sc.nextInt();

        tree = new int[N];
        int hi = 0;
        for (int i = 0; i < N; i++) {
            tree[i] = sc.nextInt();
            if (hi < tree[i]) {
                hi = tree[i];
            }
        }

        int lo = 1;
        hi++;
        int mid = 0;
        long sum = 0;
        while (lo < hi) {
            mid = lo + (hi - lo) / 2;
            sum = 0;
            for (int i = 0; i < N; i++) {
                if (tree[i] >= mid) {
                    sum += tree[i] - mid;
                }
            }
            // 범위를 줄인다 = 작게 자른다 = 나머지를 늘린다 = sum 증가
            if (key > sum) {
                hi = mid;
            }
            // 범위를 늘린다 = 크게 자른다 = 나머지를 줄인다 = sum 감소
            else {
                lo = mid + 1;
            }
        }
        return lo;
    }

    public static void main(String[] args) {
        System.out.println(solution() - 1);
    }

}
