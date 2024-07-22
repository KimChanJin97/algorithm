package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ17608 {
    // 맨 오른쪽보다 크다면 기준으로 삼고, 그 기준보다 크면 +1

    private static int solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < N; i++) {
            stack.push(Integer.parseInt(br.readLine()));
        }

        Integer standard = stack.pop();
        int answer = 0;
        for (int i = 0; i < N-1; i++) {

            if (stack.peek() > standard) {
                standard = stack.pop();
                answer++;
            } else {
                stack.pop();
            }
        }

        return answer + 1;
    }

    public static void main(String[] args) throws IOException {
        System.out.println(solution());
    }
}
