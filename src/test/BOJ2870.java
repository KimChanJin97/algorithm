package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BOJ2870 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<BigInteger> answers = new ArrayList<>();
        int tc = Integer.parseInt(br.readLine());

        while (tc-- > 0) {
            char[] arr = br.readLine().toCharArray();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < arr.length; i++) {
                if (Character.isDigit(arr[i])) { // 숫자라면
                    sb.append(arr[i]);
                }
                if (sb.length() != 0 && Character.isAlphabetic(arr[i])) { // 영어라면
                    answers.add(new BigInteger(sb.toString())); // 답지에 적고
                    sb = new StringBuilder(); // 초기화
                }
                if (sb.length() != 0 && i == arr.length - 1) { // 문자열 모두 순회했다면
                    answers.add(new BigInteger(sb.toString())); // 답지에 적기
                }
            }
        }

        Collections.sort(answers);
        for (BigInteger i : answers) {
            System.out.println(i);
        }
    }
}
