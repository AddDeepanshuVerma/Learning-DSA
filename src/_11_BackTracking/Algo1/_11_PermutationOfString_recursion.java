package _11_BackTracking.Algo1;

import java.util.*;

public class _11_PermutationOfString_recursion {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        String str = "aac";
        permute(str, "", list);
        System.out.println(list);
    }

    private static void permute(String ip, String op, List<String> list) {
        if (ip.isEmpty()) {
            list.add(op);
            return;
        }
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < ip.length(); i++) {
            if (!set.contains(ip.charAt(i))) {
                set.add(ip.charAt(i));
                String newIp = ip.substring(0, i) + ip.substring(i + 1);
                String newOp = op + ip.charAt(i);
                permute(newIp, newOp, list);
            }
        }
    }

    private static void permute2(String ip, String op, List<String> list) {
        if (ip.isEmpty())
            list.add(op);
        else {
            for (int i = 0; i < ip.length(); i++) {
                String newIp = ip.substring(0, i) + ip.substring(i + 1);
                String newOp = op + ip.charAt(i);
                permute2(newIp, newOp, list);
            }
        }
    }
}
