package week7;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BOJ14916 {

    static int solution() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        if (n == 2) return 1;
        if (n == 4) return 2;
        if (n < 5) return -1;

        // 최대로 5원으로 채우기
        List<Integer> list = new ArrayList<>();
        int limit = n / 5;
        for (int i = 0; i < limit; i++) {
            list.add(5);
        }

        int answer = n - (list.size() * 5); // 최대로 5원으로 채운 후 나머지 금액
        while (answer < n) {
            if (answer % 2 == 0) { // 2원으로 나눠진다면
                return list.size() + (answer / 2);
            } else if (answer % 2 != 0 && list.get(0) == 5) { // 2원으로 나눠지지 않고 5원이 존재한다면
                list.remove(list.size() - 1); // 5 제거
                list.add(2); // 2 삽입
                answer += 3;
            } else { // 5원이 존재하지 않는다면 (끝까지 와서 불가능함을 의미)
                return -1;
            }
        }

        return 100;
    }

    public static void main(String[] args) {
        System.out.println(solution());
    }
}
