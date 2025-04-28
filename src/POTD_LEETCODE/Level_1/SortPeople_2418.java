package POTD_LEETCODE.Level_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;


class SortPeople_2418 {
    public static void main(String[] args) {
        String[] names = {"Alice", "Bob", "Bob"};
        int[] heights = {155, 185, 150};
        String[] res = sortPeople2(names, heights);
        System.out.println(Arrays.toString(res));
    }

    public static String[] sortPeople(String[] names, int[] heights) {
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < names.length; i++) {
            map.put(names[i], heights[i]);
        }
        Arrays.sort(names, (a, b) -> map.get(b) - map.get(a));
        return names;
    }

    public static String[] sortPeople2(String[] names, int[] heights) {
        List<Pair<Integer, String>> heightAndNames = new ArrayList<>();

        for (int i = 0; i < names.length; ++i)
            heightAndNames.add(new Pair<>(heights[i], names[i]));

        heightAndNames.sort((a, b) -> b.key() - a.key());

        for (int i = 0; i < heightAndNames.size(); ++i)
            names[i] = heightAndNames.get(i).value();
        return names;
    }
    public record Pair<K, V>(K key, V value) {
    }
    static class Pair2<K, V> {
        private final K key;
        private final V value;

        public Pair2(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }
}
