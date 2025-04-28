package _21_Graphs.Leetcode._3hard;

import java.util.*;

class FindItinerary_332_2 {
    public List<String> findItinerary(List<List<String>> tickets) {
        HashMap<String, List<String >> map = new HashMap<>();

        for (List<String> ticket : tickets) {
            String u = ticket.getFirst();
            String v = ticket.getLast();
            map.computeIfAbsent(u, list -> new ArrayList<>()).add(v);
        }

        for (List<String> value : map.values()) {
            value.sort(String::compareTo);
        }
        System.out.println("map = " + map);

        List<String> ans = new ArrayList<>();
        ArrayDeque<String> q = new ArrayDeque<>();
        q.offer("JFK");

        while (!q.isEmpty()) {
            String u = q.poll();
            ans.add(u);

            List<String> ngbr = map.getOrDefault(u, Collections.emptyList());
            for (String v : ngbr) {
                q.offer(v);
            }
            ngbr.clear();
        }
        return ans;
    }

    public static void main(String[] args) {
        List<List<String>> tickets = new ArrayList<>();
        tickets.add(List.of("JFK", "KUL"));
        tickets.add(List.of("JFK", "NRT"));
        tickets.add(List.of("NRT", "JFK"));

        var obj = new FindItinerary_332_2();
        List<String> res = obj.findItinerary(tickets);
        System.out.println("res = " + res);
    }

//    public static void main(String[] args) {
//        List<List<String>> tickets = new ArrayList<>();
//        tickets.add(List.of("JFK", "SFO"));
//        tickets.add(List.of("JFK", "ATL"));
//        tickets.add(List.of("SFO", "ATL"));
//        tickets.add(List.of("ATL", "JFK"));
//        tickets.add(List.of("ATL", "SFO"));
//
//        var obj = new FindItinerary_332();
//        List<String> res = obj.findItinerary(tickets);
//        System.out.println("res = " + res);
//    }
}