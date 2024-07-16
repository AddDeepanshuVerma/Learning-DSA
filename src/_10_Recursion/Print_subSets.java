package _10_Recursion;

import java.util.ArrayList;
import java.util.List;

public class Print_subSets {
    static List<String> list = new ArrayList<>();
    public static void main(String[] args) {
        String str = "abc";
        printSubsets("", str);
        System.out.println(list);
    }

    private static void printSubsets(String op, String ip) {
        if (ip.isEmpty()) {
            list.add(op);
            return;
        }
        printSubsets(op,                    ip.substring(1));
        printSubsets(op+ip.charAt(0),	ip.substring(1));
    }

    private static void printSubsets3(String op, String ip) {
        if (ip.isEmpty()) {
            list.add(op);
        } else {
            printSubsets3(op, ip.substring(1));
            printSubsets3(op + ip.charAt(0), ip.substring(1));
        }
    }

    private static void printSubsets2(String op, String ip) {
        if (ip.isEmpty()) {
            System.out.printf(op +" ");
            return;
        }
        String op2 = op + ip.charAt(0);
        String ip2 = ip.substring(1);
        printSubsets2(op, ip2);
        printSubsets2(op2, ip2);
    }
}
