package Random;

import jdk.jfr.Description;

import java.util.Comparator;


@Description("Listen to the recording in mobile named the same")
public class comparator_comparable implements Comparable<Integer> {
    public static void main(String[] args) {
        Comparator<Integer> comparator = (o1, o2) -> o2 - o1;
    }

    @Override
    public int compareTo(Integer o) {
        return 0;
    }
}
