package Interesting;

import java.util.Arrays;
import java.util.Comparator;

public class ComparatorEx {
    public static void main(String[] args) {
        String[] arr = {"3", "30", "34", "5", "9"};

        Comparator<String> comp = new Comparator<>() {
            @Override
            public int compare(String a, String b) {
                return (b + a).compareTo(a + b);
            }
        };
        Arrays.sort(arr, comp);

        Comparator<String> comp1 = (String a, String b) -> {
            return (b + a).compareTo(a + b);
        };
        Arrays.sort(arr, comp1);

        Comparator<String> comp3 = (a, b) -> (b + a).compareTo(a + b);
        Arrays.sort(arr, comp3);

        Arrays.sort(arr, (a, b) -> (b + a).compareTo(a + b));
    }
}
