package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ24511 {

    private static String solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 자료구조 개수
        String[] dataStructures = br.readLine().split(" "); // 자료구조 종류
        String[] elements = br.readLine().split(" "); // 원소

        // 큐가 가지는 원소들만 매핑 (스택은 매핑 의미 없음)
        // 데크로 큐스택을 흉내낼 수 있음
        Deque<String> queueStack = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            if (dataStructures[i].equals("0")) {
                queueStack.add(elements[i]);
            }
        }

        int M = Integer.parseInt(br.readLine()); // 수열 길이
        StringTokenizer st = new StringTokenizer(br.readLine()); // 수열

        StringBuilder sb = new StringBuilder();
        while (M-- > 0) {
            String move = st.nextToken(); // 삽입할 새 원소
            queueStack.addFirst(move); // 기존 원소가 맨 뒤로 이동하는 효과
            sb.append(queueStack.pollLast()).append(" "); // 마지막 원소 퇴출 (큐든 스택이든 무조건 마지막 퇴출됨)
        }

        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        System.out.println(solution());
    }
}
