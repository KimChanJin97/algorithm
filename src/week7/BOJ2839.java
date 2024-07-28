package week7;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BOJ2839 {

    static int solution() {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 6

        if (N < 5 && N != 3) return -1;
        if (N == 3) return 1;

        // 최대로 5kg 담기
        List<Integer> list = new ArrayList<>();
        int limit = N / 5; // 1
        for (int i = 0; i < limit; i++) {
            list.add(5);
        }
        int answer = N - (5 * limit); // 1

        while (answer < N) {
            if (answer % 3 == 0) { // 만약 3으로 나눠떨어지면
                return list.size() + (answer / 3);
            } else if (answer % 3 != 0 && list.get(0) == 5) { // 만약 3으로 나눠떨어지지 않고 5가 존재한다면
                list.remove(list.size() - 1); // 5 빼고
                list.add(3); // 3 넣음
                answer += 2; // 결과적으로 2 빼는 것과 같음
            } else { // 5가 존재하지 않는다면 (끝까지 와서 불가능함을 의미)
                return -1;
            }
        }

        return list.size();
    }

    public static void main(String[] args) {
        System.out.println(solution());
    }

}
