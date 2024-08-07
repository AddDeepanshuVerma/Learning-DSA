package Interesting;

import java.util.HashMap;

public class MapMerge {
    public static void main(String[] args) {
        String[] arr = {"a", "b", "a", "a", "b", "a"};
        HashMap<String, Integer> map = new HashMap<>();
        for (String s : arr) {
            map.merge(s, 1, Integer::sum);
        }
        System.out.println("map = " + map);
    }
}
