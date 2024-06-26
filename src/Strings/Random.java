package Strings;

import java.security.KeyPair;
import java.sql.SQLOutput;
import java.util.*;

public class Random {
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        List<Integer> q2 = new LinkedList<>();
        Vector<Integer> stk = new Stack<>();
        Queue<Integer> pq = new PriorityQueue<>();
//        System.out.println(Comparable instanceof Object);
        List<Integer> list = new ArrayList<>();
        Collections.sort(list);


        /*System.out.println(str.contentEquals(new StringBuilder("testString")));
        StringBuilder sb = new StringBuilder("testString");
        System.out.println(str.equals(sb));*/

        /*char ch = '@';
        System.out.println(Character.isLetterOrDigit(ch));
        System.out.println(Character.isDigit(ch));*/


        /*Character[] array = {'U', 'U', 'Z'};
        System.out.println(List.of(array));
        int U = Collections.frequency(List.of(array), 'U');
        System.out.println(U);*/

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
