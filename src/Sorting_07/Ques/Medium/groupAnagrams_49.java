package Sorting_07.Ques.Medium;

import jdk.jfr.Description;

import java.util.*;

class groupAnagrams_49 {
    public static void main(String[] args) {
        String[] arr = {"eat","tea","tan","ate","nat","bat"};
        List<List<String>> lists = groupAnagrams3(arr);
        System.out.println(lists);
    }

    @Description("passed all testcases + optimal solution")
    public static List<List<String>> groupAnagrams3(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (final String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
        }
        System.out.println(map);
        return new ArrayList<>(map.values());
    }

    private static List<List<String>> groupAnagrams2(String[] arr) {
        List<List<String>> result = new ArrayList<>();
        List<Integer> taken = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if(taken.contains(i)) continue;
            String key = getsortedKey(arr[i]);
            List<String> strings = new ArrayList<>();
            strings.add(arr[i]);
            for (int j = i+1; j < arr.length; j++) {
                if(taken.contains(j)) continue;
                String s = getsortedKey(arr[j]);
                if (key.equals(s)) {
                    strings.add(arr[j]);
                    taken.add(j);
                }
            }
            result.add(strings);
        }
        return result;
    }

    private static String getsortedKey(String s) {
        char[] charArray = s.toCharArray();
        Arrays.sort(charArray);
        return String.valueOf(charArray);
    }


    public static List<List<String>> groupAnagrams(String[] arr) {
        List<List<String>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (list.contains(i)) continue;
            List<String> strings = new ArrayList<>();
            strings.add(arr[i]);
            int[] arrElement = getArrayForThisElement(arr[i]);
            for (int j = i + 1; j < arr.length; j++) {
                if (list.contains(j)) continue;
                boolean flag = checkIfEqual(arrElement, arr[j]);
                if (flag) {
                    list.add(j);
                    strings.add(arr[j]);
                }
            }
            result.add(strings);
        }
        return result;
    }

    private static boolean checkIfEqual(int[] arr1, String s) {
        int[] arr2 = getArrayForThisElement(s);
        for (int i = 0; i < 26; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    private static int[] getArrayForThisElement(String s) {
        int[] arr = new int[26];
        for (char c : s.toCharArray()) {
            arr[c - 'a']++;
        }
        return arr;
    }

}