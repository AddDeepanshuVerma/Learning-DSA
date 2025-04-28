package _10_Recursion.algo1;

import jdk.jfr.Description;

import java.util.ArrayList;
import java.util.List;

public class Print_subSets {
    static List<String> list = new ArrayList<>();

    public static void main(String[] args) {
        String str = "abc";
        printSubsets5(new StringBuilder(""), str, 0);
        System.out.println(list);

        list.clear();
        printSubsets4("", str,0);
        System.out.println(list);

        list.clear();
        printSubsets("", str);
        System.out.println(list);
    }

    @Description("Using backtracking here")
    private static void printSubsets5(StringBuilder op, String ip, int index) {
        if (index == ip.length()) {
            list.add(op.toString());
            return;
        }

        printSubsets5(op, ip, index + 1);
        op.append(ip.charAt(index));
        printSubsets5(op, ip, index + 1);
        op.deleteCharAt(op.length() - 1);
    }

    @Description("Using recursion here while ip is not changed")
    private static void printSubsets4(String op, String ip, int index) {
        if (index == ip.length()) {
            list.add(op);
            return;
        }

        printSubsets4(op, ip, index + 1);
        printSubsets4(op + ip.charAt(index), ip, index + 1);
    }

    @Description("Using recursion here while ip is changed")
    private static void printSubsets(String op, String ip) {
        if (ip.isEmpty()) {
            list.add(op);
            return;
        }
        printSubsets(op, ip.substring(1));
        printSubsets(op + ip.charAt(0), ip.substring(1));
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
            System.out.printf(op + " ");
            return;
        }
        String op2 = op + ip.charAt(0);
        String ip2 = ip.substring(1);
        printSubsets2(op, ip2);
        printSubsets2(op2, ip2);
    }
}
