package Strings;

import java.security.KeyPair;

public class Random {
    public static void main(String[] args) {
        String s1 = "HI";
        System.out.println(s1.toLowerCase());


        /*
        StringBuilder st = new StringBuilder("hi");
        StringBuilder st2 = new StringBuilder("hi");
        System.out.println(st);
        st.append("hello");
        System.out.println("st: " + st);
        System.out.println("st2: " + st2);
        System.out.println(st2.append("hello").compareTo(st) == 0);
        */

    }


    public String toLowerCase(String s) {
        return s.chars().mapToObj(c -> ('A' <= c && c <= 'Z')
                ? (char) (c + 'a' - 'A')
                : (char) c)
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append).toString();
    }

    public String toLowerCase2(String str) {
        char[] a = str.toCharArray();
        for (int i = 0; i < a.length; i++)
            if ('A' <= a[i] && a[i] <= 'Z')
                a[i] = (char) (a[i] - 'A' + 'a');
        return new String(a);
    }


}
