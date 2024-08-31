package mutsaStudy.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ12015 {

    private static int[] seq;
    private static int[] answer;

    public static int solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        seq = new int[N];
        answer = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }

        answer[0] = seq[0];
        int length = 1;
        for (int i = 1; i < seq.length; i++) {

            int key = seq[i];

            if (answer[length - 1] < key) { // 새로운 숫자(key)가 더 크다면 기존 숫자 배열 맨 뒤(answer[length - 1])에 추가
                length++;
                answer[length - 1] = key;
            } else { // 새로운 숫자(key)가 더 작다면 이분탐색하면서 기존 숫자 배열(answer)에서 이분탐색 적용해서 더 작은 숫자를 찾아 대치해야 함
                int left = 0;
                int right = length;

                while (left < right) {
                    int mid = (left + right) / 2;

                    if (key <= answer[mid]) { // 새로운 숫자(key) <= 기존 숫자(answer[mid]) 라면 mid 를 줄여서 새로운 숫자보다 더 작은 숫자를 찾아야 함 -> 탐색범위 왼쪽 이동
                        right = mid;
                    } else { // 새로운 숫자(key) > 기존 숫자(answer[mid]) 라면 mid 를 늘려서 새로운 숫자보다 더 작은 숫자를 찾아야 함 -> 탐색범위 오른쪽 이동
                        left = mid + 1;
                    }
                }

                // while 반복문이 끝난 시점에는 새로운 숫자(key) > 기존 숫자(answer[mid]) 를 만족하는 left(=right) 를 구하게 되었을 것이다.
                // 그 인덱스에 위치하는 기존 숫자(answer[left])를 새로운 숫자(key)로 대체해준다.
                answer[left] = key;
            }
        }
        return length;
    }

    public static void main(String[] args) throws IOException {
        System.out.println(solution());
    }

}
