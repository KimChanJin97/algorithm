package inflearn.최장연속부분수열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ22862 {

    private static int solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 입력
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // 배열 초기화
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int lo = 0, odd = 0, max = 0, even = 0;
        for (int hi = 0; hi < N; hi++) {
            if (arr[hi] % 2 == 0) { // 짝수라면 짝수 갯수 증가
                even++;
            } else { // 홀수라면 홀수 갯수 증가
                odd++;
            }

            while (odd > K) { // 홀수 갯수(odd)가 제거 가능 갯수(K)를 넘는다면 lo 를 증가시켜 홀수 갯수(odd) 제어 시도
                if (arr[lo] % 2 == 0) { // 짝수라면 짝수 갯수 감소
                    even--;
                } else { // 홀수라면 홀수 갯수 감수
                    odd--;
                }
                lo++; // lo 증가
            }

            max = Math.max(max, even); // 짝수 갯수 갱신
        }
        return max;
    }

    public static void main(String[] args) throws IOException {
        System.out.println(solution());
    }
}
