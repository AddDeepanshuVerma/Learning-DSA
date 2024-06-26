package Strings.medium;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

class AreSentencesSimilar_1813 {

    public boolean areSentencesSimilar(String s1, String s2) {
        if (s1.length() == s2.length()) {
            return s1.equals(s2);
        }
        ArrayDeque<String> dq1 = new ArrayDeque<>(Arrays.asList(s1.split(" ")));
        ArrayDeque<String> dq2 = new ArrayDeque<>(Arrays.asList(s2.split(" ")));
        while (!dq1.isEmpty() && !dq2.isEmpty() && dq1.peekFirst().equals(dq2.peekFirst())) {
            dq1.poll();
            dq2.poll();
        }
        while (!dq1.isEmpty() && !dq2.isEmpty() && dq1.peekLast().equals(dq2.peekLast())) {
            dq1.pollLast();
            dq2.pollLast();
        }
        return dq1.isEmpty() || dq2.isEmpty();
    }

    public boolean areSentencesSimilar2(String sentence1, String sentence2) {
        if (sentence1.length() == sentence2.length()) {
            return sentence1.equals(sentence2);
        }
        String[] str1 = sentence1.split(" ");
        String[] str2 = sentence2.split(" ");
        if (str1.length < str2.length) {
            return similarity(str1, str2);
        } else
            return similarity(str2, str1);
    }

    private boolean similarity(String[] str1, String[] str2) {
        int l = str1.length;
        int h = str2.length;
        int diff = h - l;
        int i = 0;
        while (i < l && str1[i].equals(str2[i])) {
            i++;
        }
        while (i < l && str1[i].equals(str2[i + diff])) {
            i++;
        }
        return i == l;
    }

    //using collection framework
    public boolean areSentencesSimilar3(String s1, String s2) {
        Deque<String> dq1 = new ArrayDeque<>(Arrays.asList(s1.split(" ")));
        Deque<String> dq2 = new ArrayDeque<>(Arrays.asList(s2.split(" ")));
        while (!dq1.isEmpty() && !dq2.isEmpty() && dq1.peek().equals(dq2.peek())) {
            dq1.poll();
            dq2.poll();
        }
        while (!dq1.isEmpty() && !dq2.isEmpty() && dq1.peekLast().equals(dq2.peekLast())) {
            dq1.pollLast();
            dq2.pollLast();
        }
        return dq1.isEmpty() || dq2.isEmpty();
    }

}