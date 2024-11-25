package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ9093 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());

        while (tc-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens()) {
                StringBuilder sb = new StringBuilder(st.nextToken()).reverse();
                answer.append(sb).append(" ");
            }
            answer.append("\n");
        }

        System.out.println(answer.toString().trim());
    }
}
