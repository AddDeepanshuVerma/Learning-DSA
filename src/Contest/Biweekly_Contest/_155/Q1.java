package Contest.Biweekly_Contest._155;

import java.util.*;

public class Q1 {

    public String findCommonResponse(List<List<String>> responses) {
        HashSet<String> set;
        HashMap<String, Integer> map = new HashMap<>();
        for (List<String> response : responses) {
            set = new HashSet<>(response);
            for (String s : set) {
                map.merge(s, 1, Integer::sum);
            }
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.count == b.count ? a.str.compareTo(b.str) : b.count - a.count);
        for (Map.Entry<String, Integer> item : map.entrySet()) {
            String key = item.getKey();
            int value = item.getValue();
            pq.offer(new Pair(key, value));
        }

        return pq.peek().str;
    }

    record Pair(String str, Integer count) {
    }

    public static void main(String[] args) {
        Q1 obj = new Q1();
        List<List<String>> responses = new ArrayList<>();
        List<String> s1 = new ArrayList<>(List.of("good", "ok", "good", "ok"));
        List<String> s2 = new ArrayList<>(List.of("ok","bad","good","ok","ok"));
        List<String> s3 = new ArrayList<>(List.of("good"));
        List<String> s4 = new ArrayList<>(List.of("bad"));
        responses.add(s1);
        responses.add(s2);
        responses.add(s3);
        responses.add(s4);

        String ans = obj.findCommonResponse(responses);
        System.out.println("ans = " + ans);
    }
}
