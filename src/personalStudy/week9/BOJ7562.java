//package personalStudy.week9;
//
//import java.util.LinkedList;
//import java.util.Queue;
//import java.util.Scanner;
//
//public class BOJ7562 {
//
//    private static StringBuilder sb;
//    private static int[][] board;
//    private static boolean[][] visited;
//    private static Queue<Integer> queue;
//    private static int I;
//    // 상 하 좌 우 좌상 우상 좌하 우하
//    private static final int[] dirX = {0, 0, -1, 1, -1, 1, -1, 1};
//    private static final int[] dirY = {1, -1, 0, 0, 1, 1, -1, -1};
//
//    private static void solution() {
//        sb = new StringBuilder();
//        Scanner sc = new Scanner(System.in);
//        int tc = sc.nextInt();
//        for (int i = 0; i < tc; i++) {
//            int count = 0;
//            queue = new LinkedList();
//
//            I = sc.nextInt();
//            board = new int[I + 1][I + 1];
//            visited = new boolean[I + 1][I + 1];
//            int srcX = sc.nextInt();
//            int srcY = sc.nextInt();
//            int dstX = sc.nextInt();
//            int dstY = sc.nextInt();
//
//            if (srcX == dstX && srcY == dstY) { // 출발 위치와 도착 위치가 동일하다면
//                sb.append(0 + "\n");
//                continue;
//            }
//
//            queue.add(srcX);
//            while (!queue.isEmpty()) {
//                int size = queue.size();
//                Integer q = queue.poll();
//
//                for (int j = 0; j < size; j++) {
//                    ()
//                }
//            }
//
//        }
//
//    }
//
//
//
//
//    public static void main(String[] args) {
//
//    }
//}
