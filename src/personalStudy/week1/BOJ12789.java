package personalStudy.week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ12789 {

    public static String solution() throws IOException {

        Stack<Integer> line = new Stack<>();
        Stack<Integer> extra = new Stack<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder(br.readLine());
        br.close();
        StringTokenizer st = new StringTokenizer(sb.reverse().toString(), " ");

        while (st.hasMoreTokens()) {
            line.push(Integer.parseInt(st.nextToken()));
        }

        int student = 1;

        while (!line.isEmpty()) { // line 비워서 extra 로 다 들어갈 때까지
            if (line.peek() == student) { // line 탑에 해당 학생이 존재할 경우
                line.pop();
                student++;
            } else if (!extra.isEmpty() && extra.peek() == student) { // extra 탑에 해당 학생이 존재할 경우
                extra.pop();
                student++;
            } else { // line, extra 탑에 해당 학생이 존재하지 않을 경우
                extra.push(line.pop());
            }
        }

        // line 이 모두 비워진 상황
        while (!extra.isEmpty()) { // extra 비워질 때까지
            if (extra.peek() == student) { // extra 탑에 해당 학생이 존재할 경우
                extra.pop();
                student++;
            } else { // extra 탑에 해당 학생이 존재하지 않을 경우
                return "Sad";
            }
        }

        return "Nice";
    }

    public static void main(String[] args) throws IOException {
        System.out.println(solution());
    }
}
