package Random;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class CheckInclusion_567 {
    public static void main(String[] args) {
        System.out.println(checkInclusion("ab", "eidbaooo"));
    }

    public static boolean checkInclusion(String s1, String s2) {
        List<String> list = new ArrayList<>();
        permute(s1, "", list);
        for (String s : list) {
            if (s2.contains(s)) return true;
        }
        return false;
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

    public static boolean checkInclusion2(String s1, String s2) {
        return permute2(s1, s2, "");
    }

    private static boolean permute2(String ip, String s2, String op) {
        if (ip.isEmpty()) {
            if (s2.contains(op)) return true;
        }
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < ip.length(); i++) {
            if (!set.contains(ip.charAt(i))) {
                set.add(ip.charAt(i));
                String newIp = ip.substring(0, i) + ip.substring(i + 1);
                String newOp = op + ip.charAt(i);
                if(permute2(newIp, s2, newOp)) return true;
            }
        }
        return false;
    }
}