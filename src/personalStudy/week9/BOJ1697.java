package personalStudy.week9;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ1697 {

    private static int N;
    private static int K;
    private static boolean[] visited;
    private static Queue<Integer> queue;
    private static int count;
    private static final int MIN = 0;
    private static final int MAX = 100_000;

    private static void solution() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        visited = new boolean[MAX + 1];
        queue = new LinkedList<>();
        queue.add(N);
        visited[N] = true;

        if (N == K) return; // 수빈이와 동생 위치가 동일할 경우

        while(!queue.isEmpty()) {
            count++;
            int size = queue.size();
            for (int i = 0; i < size; i++) { // queue 소진. 아래에서 queue 크기 변경되기 때문 queue.size() 불가
                Integer q = queue.poll();

                if (q - 1 == K || q + 1 == K || q * 2 == K) { // 수빈이가 걷거나 순간이동한 위치가 동생 위치라면
                    return;
                }
                if (q - 1 >= MIN && !visited[q - 1]) { // 수빈이가 걸은(q+1) 위치가 방문한 적이 없다면
                    queue.add(q - 1);
                    visited[q - 1] = true;
                }
                if (q + 1 <= MAX && !visited[q + 1]) { // 수빈이가 걸은(q-1) 위치가 방문한 적이 없다면
                    queue.add(q + 1);
                    visited[q + 1] = true;
                }
                if (q * 2 <= MAX && !visited[2 * q]) { // 수빈이가 순간이동한(q*2) 위치가 방문한 적이 없다
                    queue.add(q * 2);
                    visited[q * 2] = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        solution();
        System.out.println(count);
    }
}
