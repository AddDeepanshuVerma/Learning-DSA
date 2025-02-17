package POTD_LEETCODE.PriorityQueue;

import java.util.HashMap;
import java.util.PriorityQueue;

class RepeatLimitedString_2182 {
    public static void main(String[] args) {

        String s = "aaaabbbbccccdddd";
        System.out.println(repeatLimitedString2(s, 2));
    }

    public static String repeatLimitedString(String s, int repeatLimit) {
        char[] arr = s.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        for (char ch : arr) {
            map.merge(ch, 1, Integer::sum);
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> b.getKey() - a.getKey());
        for (var item : map.entrySet()) {
            pq.offer(new Pair(item.getKey(), item.getValue()));
        }

        StringBuilder sb = new StringBuilder();
        char pChar = 0;
        int pCount = 0;

        while (!pq.isEmpty()) {
            if (pCount <= 0) {
                Pair poll = pq.poll();
                char ch = poll.getKey();
                int count = poll.getValue();
                int repeat = repeatLimit;
                while (repeat-- > 0 && count-- > 0) {
                    sb.append(ch);
                }
                if (count > 0) {
                    pChar = ch;
                    pCount = count;
                }
            } else {
                Pair poll = pq.poll();
                char ch = poll.getKey();
                int count = poll.getValue();

                sb.append(ch);
                count--;
                if (count > 0) {
                    pq.offer(new Pair(ch, count));
                }
                int repeat = repeatLimit;
                while (repeat-- > 0 && pCount-- > 0) {
                    sb.append(pChar);
                }
            }
        }
        System.out.println(sb);

        return sb.toString();
    }

    record Pair(char getKey, int getValue) {
    }

    //======================= clean code =======================
    public static String repeatLimitedString2(String s, int repeatLimit) {
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        StringBuilder sb = new StringBuilder();

        int i = 25;
        while (i >= 0) {
            if (count[i] == 0) {
                i--;
                continue;
            }
            int freq = Math.min(repeatLimit, count[i]);
            count[i] -= freq;
//            while (freq-- > 0) {
//                sb.append((char) ('a' + i));
//            }
            sb.append(String.valueOf((char) ('a' + i)).repeat(freq));
            if (count[i] > 0) {
                int j = i - 1;
                while (j >= 0 && count[j] == 0) {
                    j--;
                }
                if (j < 0) break;
                sb.append((char) ('a' + j));
                count[j]--;
            }
        }

        return sb.toString();
    }

}