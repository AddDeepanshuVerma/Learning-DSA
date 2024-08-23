package Random;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.time.DayOfWeek.*;

public class AntonClass {
    static String str ;
    public static void main(String[] args) {
//        File file = new File("wsbv");
//        List<String> list = new ArrayList<>();
//        if (isaBoolean(str)) {
//            list.add("HI");
//        }
        /*int[] res = searchRange(new int[]{1, 2, 3, 4,5,6,7,9}, 4);
        for (int re : res) {
            System.out.println(re);
        }*/

//        printingMethod();
//        System.out.println(tribonacci(37));

        System.out.println(addToArrayForm22(new int[]{1,2,0,0}, 34));

        System.out.println(Arrays.toString("hi".toCharArray()));

    }


    public static List<Integer> addToArrayForm22(int[] num, int k) {
        List<Integer> list = new ArrayList<>();
        int sum = 0;
        for (int i = 0; i < num.length; i++) {
            sum = sum * 10 + num[i];
        }
        sum+=k;
        System.out.println(sum);
        while (sum > 0) {
            list.add(0, sum % 10);
            sum /= 10;
        }
        return list;
    }


    public static int tribonacci(int n) {
        if (n < 2) {
            return n;
        }
        int[] trio = {0,1,1};
        for (int i = 3; i <= n; ++i) {
            int next = trio[0] + trio[1] + trio[2];
            trio[0] = trio[1];
            trio[1] = trio[2];
            trio[2] = next;
        }
        return trio[2];
    }
    private static void printingMethod(){
        int[] ints = new int[] {1, 2, 3, 4, 5};
        System.out.println(IntStream.of(ints).mapToObj(Integer::toString).collect(Collectors.joining(", ")));
        System.out.println(IntStream.of(ints).boxed().map(Object::toString).collect(Collectors.joining(", ")));
        System.out.println(Arrays.toString(ints));

        String[] strs = new String[] {"John", "Mary", "Bob"};
        System.out.println(Stream.of(strs).collect(Collectors.joining(", ")));
        System.out.println(String.join(", ", strs));
        System.out.println(Arrays.toString(strs));

        DayOfWeek[] days = { FRIDAY, MONDAY, TUESDAY };
        System.out.println(Stream.of(days).map(Object::toString).collect(Collectors.joining(", ")));
        System.out.println(Arrays.toString(days));

// These options are not the same as each item is printed on a new line:
        IntStream.of(ints).forEach(System.out::println);
        Stream.of(strs).forEach(System.out::println);
        Stream.of(days).forEach(System.out::println);

    }

    public static int[] searchRange(int[] nums, int target) {

        List<Integer> list = Arrays.stream(nums).boxed().filter(AntonClass::isGreaterthen2).toList();
        System.out.println(list);
        return new int[]{list.indexOf(target), list.lastIndexOf(target)};
    }

    private static boolean isGreaterthen2(Integer integer) {
        return integer>2;
    }

    private static boolean isaBoolean(String str) {
        String[] array = str.split(" ");
        String st = null;
        for (int i = 0; i < array.length; i++) {
            st = array[i];
        }


        return !AntonClass.str.isEmpty();
    }

}
