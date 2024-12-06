package personalStudy.week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class BOJ10610 {

    private static Integer[] arr;

    private static String solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        arr = new Integer[line.length()];

        int sum = 0;
        String[] split = line.split("");
        for (int i = 0; i < arr.length; i++) {
            sum += Integer.parseInt(split[i]);
        }

        if (sum % 3 == 0 && line.contains("0")) {
            for (int i = 0; i < arr.length; i++) {
                arr[i] = Integer.parseInt(split[i]);
            }
            Arrays.sort(arr, Comparator.reverseOrder());
            return Arrays.stream(arr).map(String::valueOf).collect(Collectors.joining());
        }
        return "-1";
    }

    public static void main(String[] args) throws IOException {
        System.out.println(solution());
    }
}
