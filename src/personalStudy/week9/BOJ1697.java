package personalStudy.week9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1697 {

    private static int myIdx;
    private static int sisIdx;

    private static final int MIN = 0;
    private static final int MAX = 30;
    private static int[] visitedSum = new int[MAX + 1];

    private static StringTokenizer st;

    private static int solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        myIdx = Integer.parseInt(st.nextToken());
        sisIdx = Integer.parseInt(st.nextToken());

        return BFS();
    }

    private static int BFS() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(myIdx);
        visitedSum[myIdx] = 1;
        while (!queue.isEmpty()) {
            Integer myIndex = queue.poll();
            if (isInBound(myIndex + 1) && visitedSum[myIndex + 1] == 0) {
                queue.add(myIndex + 1);
                visitedSum[myIndex + 1] = visitedSum[myIndex] + 1;
            }
            if (isInBound(myIndex - 1) && visitedSum[myIndex - 1] == 0) {
                queue.add(myIndex - 1);
                visitedSum[myIndex - 1] = visitedSum[myIndex] + 1;
            }
            if (isInBound(myIndex * 2) && visitedSum[myIndex * 2] == 0) {
                queue.add(myIndex * 2);
                visitedSum[myIndex * 2] = visitedSum[myIndex] + 1;
            }
        }
        return visitedSum[sisIdx];
    }

    private static boolean isInBound(int nextIdx) {
        return (MIN <= nextIdx && nextIdx <= MAX);
    }

    public static void main(String[] args) throws IOException {
        System.out.println(solution() - 1);
    }
}
