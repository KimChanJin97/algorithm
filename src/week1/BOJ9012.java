package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ9012 {

    private static final String LEFT = "(";
    private static final String RIGHT = ")";
    private static final String YES = "YES";
    private static final String NO = "NO";

    private static String solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while(N-- > 0) {
            String line = br.readLine();
            String[] split = line.split("");

            Stack<String> stack = new Stack<>();
            for (String s : split) {

                if (s.equals(LEFT)) {
                    stack.push(s);
                    continue;
                }

                if (stack.contains(LEFT) && s.equals(RIGHT)) {
                    stack.pop();
                    continue;
                }

                if (s.equals(RIGHT)) {
                    stack.push(s);
                }
            }

            if (stack.size() > 0) {
                sb.append(NO).append("\n");
            } else {
                sb.append(YES).append("\n");
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        System.out.println(solution());

    }
}
