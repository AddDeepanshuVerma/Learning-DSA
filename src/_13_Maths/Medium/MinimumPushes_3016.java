package _13_Maths.Medium;

import java.util.*;

class MinimumPushes_3016 {
    public static void main(String[] args) {
        String str = "aabbccddeeffgghhiiiiii";
        String[] arr = str.split("");
        HashMap<String, Integer> map = new HashMap<>();
        for (String s : arr) {
            map.merge(s, 1, Integer::sum);
        }
        System.out.println(map);
        System.out.println(map);
        Arrays.sort(arr, (a, b) -> map.get(b) - map.get(a));
        System.out.println(Arrays.toString(arr));
        LinkedHashSet<String> set = new LinkedHashSet<>(List.of(arr));
        System.out.println(set);
    }

    public int minimumPushes(String word) {
        String[] arr = word.split("");
        HashMap<String, Integer> map = new HashMap<>();
        for (String s : arr) {
            map.merge(s, 1, Integer::sum);
        }
        System.out.println(map);
        return 0;
    }
}