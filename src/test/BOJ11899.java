package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ11899 {

    private static final char LEFT = '(';
    private static final Stack<Character> STACK = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == LEFT) { // 좌괄호라면 무조건 넣어 (짝짓기 목적)
                STACK.push(s.charAt(i));
            } else { // 우괄호라면
                if (!STACK.isEmpty() && STACK.peek() == LEFT) { // 스택이 비어있지 않고 좌괄호가 스택에 존재할 경우, 좌괄호랑 짝지어서 제거
                    STACK.pop();
                } else { // 좌괄호가 스택에 존재하지 않을 경우, 우괄호 무조건 넣어 (오류 체크 목적)
                    STACK.push(s.charAt(i));
                }
            }
        }
        System.out.println(STACK.size());
    }
}
