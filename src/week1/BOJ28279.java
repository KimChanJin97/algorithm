package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class BOJ28279 {

    private static Deque<Integer> deque = new LinkedList();
    private static StringBuilder sb = new StringBuilder();

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        while (N-- > 0) {
            String line = br.readLine();

            if (line.startsWith("1")) {
                com_1(Integer.parseInt(line.split(" ")[1]));
                continue;
            }

            if (line.startsWith("2")) {
                com_2(Integer.parseInt(line.split(" ")[1]));
                continue;
            }

            if (line.startsWith("3")) {
                com_3();
                continue;
            }

            if (line.startsWith("4")) {
                com_4();
                continue;
            }

            if (line.startsWith("5")) {
                com_5();
                continue;
            }

            if (line.startsWith("6")) {
                com_6();
                continue;
            }

            if (line.startsWith("7")) {
                com_7();
                continue;
            }

            if (line.startsWith("8")) {
                com_8();
            }
        }
    }

    private static void com_1(int i) {
        deque.addFirst(i);
    }

    private static void com_2(int i) {
        deque.addLast(i);
    }

    private static void com_3() {
        if (!deque.isEmpty()) {
            sb.append(deque.pollFirst()).append("\n");
        } else {
            sb.append(-1).append("\n");
        }
    }

    private static void com_4() {
        if (!deque.isEmpty()) {
            sb.append(deque.pollLast()).append("\n");
        } else {
            sb.append(-1).append("\n");
        }
    }

    private static void com_5() {
        sb.append(deque.size()).append("\n");
    }

    private static void com_6() {
        if (deque.isEmpty()) {
            sb.append(1).append("\n");
        } else {
            sb.append(0).append("\n");
        }
    }

    private static void com_7() {
        if (!deque.isEmpty()) {
            sb.append(deque.peekFirst()).append("\n");
        } else {
            sb.append(-1).append("\n");
        }
    }

    private static void com_8() {
        if (!deque.isEmpty()) {
            sb.append(deque.peekLast()).append("\n");
        } else {
            sb.append(-1).append("\n");
        }
    }

    public static void main(String[] args) throws IOException {
        solution();
        System.out.println(sb.toString());
    }
}
