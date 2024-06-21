package Sorting_07.Ques.Medium;

import jdk.jfr.Description;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class largestNumber_179 {
    public static void main(String[] args) {
        int[] arr = {3, 30, 34, 5, 9};
        System.out.println(largestNumber(arr));

//        String[] arr2 = {"3", "30", "34", "5", "9"};
//        System.out.println(largestNumber2(arr2));
//        System.out.println("34,9 => " + "349".compareTo("934"));
//        System.out.println("9,34 => " + "934".compareTo("349"));

    }
    @Description("passed all testcases + optimal solution")
    private static String largestNumber(int[] nums) {
        /*List<String> s1 = Arrays.stream(nums.clone())
                .mapToObj(s -> s + "")
                .sorted((a, b) -> (b + a).compareTo(a + b))
                .collect(Collectors.toList());
        System.out.println(s1);

        String s2 = Arrays.stream(nums.clone())
                .mapToObj(String::valueOf)
                .sorted((a, b) -> (b + a).compareTo(a + b))
                .collect(Collectors.joining());
        System.out.println(s2);*/
        final String s = Arrays.stream(nums)
                .mapToObj(String::valueOf)
                .sorted((a, b) -> (b + a).compareTo(a + b))
                .collect(Collectors.joining(""));
        return s.startsWith("00") ? "0" : s;
    }


    public static String largestNumber2(String[] nums) {
        Comparator<String> comp3 = (a, b) -> (b + a).compareTo(a + b);

        Comparator<String> comp2 = (s1, s2) -> {
            int a = Integer.parseInt(s1 + s2);
            int b = Integer.parseInt(s2 + s1);
            if (a > b) {
                return -1;
            } else return 1;
        };

        Comparator<String> comp = new Comparator<>() {
            @Override
            public int compare(String s1, String s2) {
                int a = Integer.parseInt(s1 + s2);
                int b = Integer.parseInt(s2 + s1);
                if (a > b) {
                    return -1;
                } else return 1;
            }
        };
        Arrays.sort(nums, comp3);
        return String.join("", nums);
    }
}