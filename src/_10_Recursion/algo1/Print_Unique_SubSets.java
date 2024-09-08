package _10_Recursion.algo1;

import jdk.jfr.Description;

import java.util.ArrayList;
import java.util.List;

public class Print_Unique_SubSets {
    static List<String> list = new ArrayList<>();

    public static void main(String[] args) {
        String str = "abb";
//        printSubsets3(new StringBuilder(""), str, 0);
//        System.out.println(list);
//
//        list.clear();
//        printSubsets2("", str, 0);
//        System.out.println(list);
//
//        list.clear();
        printSubsets("", str);
        System.out.println(list);
    }

    @Description("Using backtracking ")
    private static void printSubsets3(StringBuilder op, String ip, int index) {
        if (index == ip.length()) {
            list.add(op.toString());
            return;
        }
        printSubsets3(op, ip, index + 1);
        op.append(ip.charAt(index));
        printSubsets3(op, ip, index + 1);
        op.deleteCharAt(op.length() - 1);
    }

    @Description("Using recursion, while input value is not changed")
    private static void printSubsets2(String op, String ip, int index) {
        if (index == ip.length()) {
            list.add(op);
            return;
        }

        printSubsets2(op, ip, index + 1);
        printSubsets2(op + ip.charAt(index), ip, index + 1);
    }

    @Description("Using recursion, while input is changed")
    private static void printSubsets(String op, String ip) {
        if (ip.isEmpty()) {
            list.add(op);
            return;
        }
        printSubsets(op, ip.substring(1));
        printSubsets(op + ip.charAt(0), ip.substring(1));
    }
}
