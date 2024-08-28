package personalStudy.week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ26042 {

    private static String solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int maxSize = 0;
        int minNum = 100_000;

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            String line = br.readLine();

            if (line.startsWith("1")) {
                int num = Integer.parseInt(line.split(" ")[1]);
                queue.add(num);

                if (queue.size() > maxSize) { // 줄 크기가 늘어났다면
                    maxSize = queue.size(); // 줄 크기 갱신
                    minNum = num;
                }

                if (queue.size() == maxSize) { // 줄 크기가 동일하다면
                    if (num < minNum) { // 번호가 작아졌다면
                        minNum = num; // 번호 갱신
                    }
                }
            } else {
                queue.poll();
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(maxSize);
        sb.append(" ");
        sb.append(minNum);

        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        System.out.println(solution());
    }
}
