package Random;

import jdk.jfr.Description;

import java.util.Arrays;
import java.util.Comparator;

public class Comparator_Usage {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        Integer[] wArray = Arrays.stream(arr)
                                 .boxed()
                                 .toArray(Integer[]::new);
        Arrays.sort(wArray, (a, b) -> Integer.bitCount(a) - Integer.bitCount(b));
        System.out.println(Arrays.toString(wArray));

    }

    @Description("Comparator usage")
    private static void Comparator_types(int[] arr) {
        int[] ep = {0, 1, 2, 3, 4, 5, 6, 7, 8};
        Integer[] wEp = Arrays.stream(arr)
                              .boxed()
                              .toArray(Integer[]::new);

        // complete intro of basic comparator definition,
        // It needs to be performed on wrapper classes
        Comparator<Integer> comp1 = (Integer a, Integer b) -> {
            return Integer.bitCount(a) - Integer.bitCount(b);
        };
        Arrays.sort(wEp, comp1);

        // No need to Initialize variable
        Comparator<Integer> comp2 = (a, b) -> {
            return Integer.bitCount(a) - Integer.bitCount(b);
        };
        Arrays.sort(wEp, comp2);

        // If there is no parenthesis then no need to mention return
        Comparator<Integer> comp3 = (a, b) -> Integer.bitCount(a) - Integer.bitCount(b);
        Arrays.sort(wEp, comp3);

        // if comparing just two variable using a inbuilt function, use call by reference
        Comparator<Integer> comp4 = Comparator.comparingInt(Integer::bitCount);
        Arrays.sort(wEp, comp4);

        // can adjust the comparator within required parameter
        Arrays.sort(wEp, (a, b) -> Integer.bitCount(a) - Integer.bitCount(b));
    }


}
