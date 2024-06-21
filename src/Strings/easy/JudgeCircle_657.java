package Strings.easy;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class JudgeCircle_657 {
    public static void main(String[] args) {
        System.out.println(judgeCircle("UD"));
    }

    private static boolean judgeCircle(String str) {
        int u = 0, d = 0, l = 0, r = 0;
        for (char c : str.toCharArray()) {
            switch (c) {
                case 'U' -> u++;
                case 'D' -> d++;
                case 'L' -> l++;
                case 'R' -> r++;
            }
        }
        return u == d && l == r;
    }

    private static boolean judgeCircle2(String str) {
        int ud = 0, lr = 0;
        for (char c : str.toCharArray())
            switch (c) {
                case 'U' -> ud++;
                case 'D' -> ud--;
                case 'L' -> lr++;
                case 'R' -> lr--;
            }
        return ud == 0 && lr == 0;
    }

    public static boolean judgeCircle3(String moves) {
        Character[] array = moves.chars().mapToObj(c -> (char) c).toArray(Character[]::new);
        int U = Collections.frequency(List.of(array), 'U');
        int D = Collections.frequency(List.of(array), 'D');
        int L = Collections.frequency(List.of(array), 'L');
        int R = Collections.frequency(List.of(array), 'R');
        return U - D == 0 && L - R == 0;
    }
}