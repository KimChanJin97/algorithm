package personalStudy.week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1449 {

    private static int[] leakIndexes;

    private static int solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int leakCount = Integer.parseInt(st.nextToken());
        int tapeLength = Integer.parseInt(st.nextToken());

        leakIndexes = new int[leakCount + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= leakCount; i++) {
            leakIndexes[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(leakIndexes);

        int coveredIndex = 0;
        int count = 0;
        for (int i = 1; i <= leakCount; i++) {
            if (leakIndexes[i] > coveredIndex) { // 누수 인덱스가 커버 인덱스를 벗어난다면 테이프 붙여야 함
                count++;
                coveredIndex = leakIndexes[i] + (tapeLength - 1); // 커버 인덱스는 누수 인덱스에 좌우 0.5 를 제외한 테이프 길이를 더한 값
            }
        }

        return count;
    }

    public static void main(String args[]) throws IOException {
        System.out.println(solution());
    }
}
