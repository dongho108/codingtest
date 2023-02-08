package goorm.p53763;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int n = Integer.parseInt(br.readLine());
        final List<String> inputs = List.of(br.readLine().split(" "));

        final List<String> strings = inputs.stream()
                .distinct()
                .collect(Collectors.toList());
        if (strings.size() >= 3) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
