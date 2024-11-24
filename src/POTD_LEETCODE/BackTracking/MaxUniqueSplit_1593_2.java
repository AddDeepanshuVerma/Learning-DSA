package POTD_LEETCODE.BackTracking;

import java.util.HashSet;

class MaxUniqueSplit_1593_2 {
    public static void main(String[] args) {
        MaxUniqueSplit_1593_2 obj = new MaxUniqueSplit_1593_2();
        System.out.println(obj.maxUniqueSplit("acefofckpkjfcdcp"));
//        System.out.println(obj.maxUniqueSplit("aba"));
//        System.out.println(obj.maxUniqueSplit("aa"));
    }

    int maxCount;

    public int maxUniqueSplit(String s) {
        maxCount = 0;
        int index = 0;
        dfs(s.toCharArray(), index, new HashSet<String>());
        return maxCount;
    }

    private void dfs(char[] arr, int index, HashSet<String> set) {
        if (index >= arr.length) {
//            System.out.println("set = " + set);
            maxCount = Math.max(maxCount, set.size());
            return;
        }
//        if (set.size() + (arr.length - index) <= maxCount) return;

        String prefix = "";
        for (int i = index; i < arr.length; i++) {
            if (set.size() + (arr.length - index) <= maxCount) break;
            prefix += arr[i];
            if (!set.contains(prefix)) {
                set.add(prefix);
                dfs(arr, i + 1, set);
                set.remove(prefix);
            }
        }

    }
}