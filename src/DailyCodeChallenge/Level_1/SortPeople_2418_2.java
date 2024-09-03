package DailyCodeChallenge.Level_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


class SortPeople_2418_2 {
    public static void main(String[] args) {
        String[] names = {"Anna", "Elsa", "Olaf", "Kristoff"};
        int[] heights = {150, 140, 160, 170};
        String[] res = sortPeople2(names, heights);
        System.out.println(Arrays.toString(res));
    }

    // using selection sort
    private static String[] sortPeople2(String[] names, int[] heights) {

        for (int i = 0; i < heights.length; i++) {
            int min = Integer.MAX_VALUE;
            int index = 0;
            for (int j = 0; j < heights.length - i; j++) {
                if (heights[j] < min) {
                    min = heights[j];
                    index = j;
                }
            }
            swap(heights, names, index, heights.length - i - 1);
        }
        System.out.println(Arrays.toString(heights));
        return names;
    }

    private static void swap(int[] heights, String[] names, int i, int j) {
        int temp = heights[i];
        heights[i] = heights[j];
        heights[j] = temp;

        String temp2 = names[i];
        names[i] = names[j];
        names[j] = temp2;
    }

    public static <T> void swap2(T[] heights, int i, int j) {
        T temp = heights[i];
        heights[i] = heights[j];
        heights[j] = temp;
    }

    private static String[] sortPeople(String[] names, int[] heights) {
        List<data<String, Integer>> list = new ArrayList<>();
        for (int i = 0; i < names.length; i++) {
            data tmp = new data<>(names[i], heights[i]);
            list.add(tmp);
        }
        list.sort((a, b) -> b.value - a.value);
//        Collections.sort(list, (a, b) -> b.value - a.value);
        for (int i = 0; i < list.size(); i++) {
            names[i] = list.get(i).key;
        }
        return names;
    }

    record data<K, V>(K key, V value) {
    }
}