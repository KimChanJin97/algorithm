package personalStudy.week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ3986 {

    private static int solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int answer = 0;

        while (N-- > 0) {
            Stack<String> stack = new Stack<>();

            String line = br.readLine();
            String[] split = line.split("");

            for (String s : split) {

                if (stack.isEmpty()) { // 스택이 비었을 경우 무조건 푸시
                    stack.push(s);
                } else if (stack.peek().equals(s)) { // 탑과 푸시할 것이 동일하다면 제거
                    stack.pop();
                } else { // 탑과 푸시할 것이 다르다면 일단 푸시 (나중에 제거될 수도)
                    stack.push(s);
                }
            }

            if (stack.isEmpty()) {
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        System.out.println(solution());
    }
}
