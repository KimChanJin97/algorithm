package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ11899 {

    private static final char LEFT = '(';
    private static final Stack<Character> STACK = new Stack<>();

    // STACK 은 최종적으로 짝이 맞지 않은 괄호만을 남기는 것이 목적
    // LEFT 는 STACK 에 무조건 저장 (LEFT 또는 RIGHT 가 STACK 에 있더라도 괜찮음)
    // RIGHT 는 경우에 따라 제거 또는 저장
    // (1) STACK 에 LEFT 가 있는데 RIGHT 가 제공된 경우 -> LEFT 제거 (RIGHT 는 무시)
    // (2) STACK 에 LEFT 가 없는데 RIGHT 가 제공된 경우 -> RIGHT 저장

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        STACK.push(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == LEFT) {
                STACK.push(c);
            } else {
                if (!STACK.isEmpty() && STACK.peek() == LEFT) {
                    STACK.pop();
                } else {
                    STACK.push(c);
                }
            }
        }
        STACK.stream().forEach(c -> System.out.print(c));
    }
}
