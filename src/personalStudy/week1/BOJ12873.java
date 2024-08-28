package personalStudy.week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ12873 {

    // in case of 6.
    // 123456
    // X (1: 1단계 끝) 1 % 6 = 1

    // 23456
    //   X (8: 2단계 끝) 8 % 5 = 3

    // 2356
    // X (27: 3단계 끝) 27 % 4 = 3

    // 356
    // X (64: 4단계 끝) 64 % 3 = 1

    // 56
    // X (125: 5단계 끝) 125 % 2 = 1

    // 5
    // -

    private static List<Integer> list;

    private static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        list = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            list.add(i);
        }

        int round = 1;
        int idx = 0;
        while (list.size() > 1) {
            idx = (int) ((idx + Math.pow(round, 3) - 1) % list.size());
            list.remove(idx);
            round++;
        }
    }

    public static void main(String[] args) throws IOException {
        solution();
        System.out.println(list.get(0));
    }
}
