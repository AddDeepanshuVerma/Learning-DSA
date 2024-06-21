package DailyCodeChallenge;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeMap;

class IsNStraightHand {

    public static void main(String[] args) {
        int[] arr = {2,3,4,5,6,7,8,9};
//        System.out.println(isNStraightHand(arr, 2));
        isNStraightHandList(arr, 8);
    }

    public static boolean isNStraightHand(int[] arr, int eachGroupSize) {
        int n = arr.length;
        if (n % eachGroupSize != 0) return false;

        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        for (int a : arr) {
            treeMap.put(a, treeMap.getOrDefault(a, 0) + 1);
        }

        while (!treeMap.isEmpty()) {
            int min = treeMap.firstKey();
            for (int i = 1; i < eachGroupSize; i++) {
                if (treeMap.containsKey(min + 1)) {
                    haltKey(treeMap, min);
                    min++;
                } else return false;
            }
            haltKey(treeMap, min);
        }
        return true;
    }

    private static void haltKey(TreeMap<Integer, Integer> treeMap, int key) {
        int value = treeMap.get(key);
        if (value > 1) {
            treeMap.put(key, value - 1);
        } else {
            treeMap.remove(key);
        }
    }

    public static void isNStraightHandList(int[] arr, int eachGroupSize) {
        int n = arr.length;
        if (n % eachGroupSize != 0) {
            System.out.println("No Consecutive cards are possible");
            return;
        }

        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        for (int a : arr) {
            treeMap.put(a, treeMap.getOrDefault(a, 0) + 1);
        }
        System.out.println("for map: "+ treeMap);
        List<List<Integer>> list = new ArrayList<>();
        while (!treeMap.isEmpty()) {
            List<Integer> lst = new ArrayList<>();
            int min = treeMap.firstKey();
            for (int i = 1; i < eachGroupSize; i++) {
                if (treeMap.containsKey(min + 1)) {
                    lst.add(min);
                    haltKey(treeMap, min);
                    min++;
                } else {
                    System.out.println("Consecutive cards are partial \n: " + list);
                    return;
                }
            }
            haltKey(treeMap, min);
            lst.add(min);
            list.add(lst);
        }
        System.out.println("Consecutive cards are completed : \n" + list);
//        return true;
    }
}