package POTD_LEETCODE.BackTracking;

import java.util.ArrayList;
import java.util.List;

class PunishmentNumber_2698 {
    static List<Integer> list;

    static {
        list = new ArrayList<>();
        for (int i = 1; i <= 1000; i++) {
            if (checkPartition(i * i, i)) {
                list.add(i);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(punishmentNumber(37));
    }

    public static int punishmentNumber(int n) {
        int sum = 0;
        for (int val : list) {
            if (n >= val) sum += val * val;
            else break;
        }
        return sum;
    }

    static boolean checkPartition(int num, int target) {
        //
        return dfs(String.valueOf(num), target, 0);
    }

    private static boolean dfs(String s, int target, int curr) {
        if (curr > target) return false;
        if (s.isEmpty()) return curr == target;
        boolean flag = false;

        for (int k = 0; k < s.length(); k++) {
            String left = s.substring(0, k + 1);
            String right = s.substring(k + 1);
            int add = Integer.parseInt(left);

            if (dfs(right, target, curr + add)) {
                flag = true;
                break;
            }
        }
        return flag;
    }
}