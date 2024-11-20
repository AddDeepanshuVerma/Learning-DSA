package POTD_LEETCODE.Level_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class FrequencySort_1636 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3, 3, 3, 4, 4, 4};
        System.out.println(Arrays.toString(frequencySort(arr)));
    }

    public static int[] frequencySort2(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        return Arrays.stream(nums).boxed().sorted((a, b) -> !map.get(a).equals(map.get(b)) ? map.get(a) - map.get(b) : b - a).mapToInt(n -> n).toArray();
    }

    public static int[] frequencySort(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        //The list returned by .toList() (a method of Stream) is immutable. Sorting it (.sort()) sorts 'in place'
        // and this requires mutating the list. You can't do that.
        //The usual fix is to first copy the immutable list into a mutable one: convList = new ArrayList<Integer>(convList);.
        //However, all of your code is a bit suspect. Why go from int[] to List<Integer> to Stream and back again?
        List<Integer> list = new ArrayList<>(Arrays.stream(nums).boxed().toList());
        list.sort((a, b) -> map.get(a) != map.get(b) ? map.get(a) - map.get(b) : b - a);
        return list.stream().mapToInt(n -> n).toArray();
    }
}