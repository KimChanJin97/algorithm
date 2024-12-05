package personalStudy.week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class BOJ1339 {

    private static final Map<String, Integer> MAP = new LinkedHashMap<>();

    private static int solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        while (N-- > 0) {
            String line = br.readLine();
            int len = line.length() - 1;
            for (String str : line.split("")) {
                MAP.put(str, MAP.getOrDefault(str, 0) + (int) Math.pow(10, len));
                len -= 1;
            }
        }

        List<Integer> values = MAP.entrySet().stream()
                .sorted(Entry.comparingByValue(Comparator.reverseOrder()))
                .map(Entry::getValue)
                .collect(Collectors.toList());

        int answer = 0;
        int start = 9;
        for (int value : values) {
            answer += value * start;
            start -= 1;
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        System.out.println(solution());
    }
}
