package BackTracking_11;

import java.util.*;

public class _11_PermutationOfString_recursion {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        String str = "abc";
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

    private static void permut(String ip, String op, List<String> list) {
        if (ip.isEmpty())
            list.add(op);
        else {
            for (int i = 0; i < ip.length(); i++) {
                String newIp = ip.substring(0, i) + ip.substring(i + 1);
                String newOp = op + ip.charAt(i);
                permut(newIp, newOp, list);
            }
        }
    }
}
