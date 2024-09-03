package Interesting;

import jdk.jfr.Description;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@Description("Java 8 – Find duplicate elements in a Stream")
public class FindDuplicateElements {


    @Description("1. Filter & Set.add()")
    public static class JavaDuplicated1 {

        public static void main(String[] args) {

            // 3, 4, 9
            List<Integer> list = Arrays.asList(5, 3, 4, 1, 3, 7, 2, 9, 9, 4);

            Set<Integer> result = findDuplicateBySetAdd(list);

            result.forEach(System.out::println);

        }

        public static <T> Set<T> findDuplicateBySetAdd(List<T> list) {

            Set<T> items = new HashSet<>();
            return list.stream()
                       .filter(n -> !items.add(n)) // Set.add() returns false if the element was already in the set.
                       .collect(Collectors.toSet());

        }

    }

    @Description("2. Map & Collectors.groupingBy")
    public static class JavaDuplicated2 {

        public static void main(String[] args) {

            // 3, 4, 9
            List<Integer> list = Arrays.asList(5, 3, 4, 1, 3, 7, 2, 9, 9, 4);

            Set<Integer> result = findDuplicateByGrouping(list);

            result.forEach(System.out::println);

        }

        public static <T> Set<T> findDuplicateByGrouping(List<T> list) {

            return list.stream()
                       .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))    // create a map {1=1, 2=1, 3=2, 4=2, 5=1, 7=1, 9=2}
                       .entrySet()
                       .stream()                 // Map -> Stream
                       .filter(m -> m.getValue() > 1)       // if map value > 1, duplicate element
                       .map(Map.Entry::getKey)
                       .collect(Collectors.toSet());

        }

    }

    @Description("3. Collections.frequency")
    public static class JavaDuplicated3 {

        public static void main(String[] args) {

            // 3, 4, 9
            List<Integer> list = Arrays.asList(5, 3, 4, 1, 3, 7, 2, 9, 9, 4);

            Set<Integer> result = findDuplicateByFrequency(list);

            result.forEach(System.out::println);

        }

        public static <T> Set<T> findDuplicateByFrequency(List<T> list) {

            return list.stream()
                       .filter(i -> Collections.frequency(list, i) > 1)
                       .collect(Collectors.toSet());

        }

    }

}
