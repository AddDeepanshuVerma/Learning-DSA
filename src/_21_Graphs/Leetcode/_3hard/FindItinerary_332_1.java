package _21_Graphs.Leetcode._3hard;

import java.util.*;

class FindItinerary_332_1 {
    public List<String> findItinerary(List<List<String>> tickets) {
        HashMap<String, PriorityQueue<String>> map = new HashMap<>();
        for (List<String> ticket : tickets) {
            String u = ticket.getFirst();
            String v = ticket.getLast();
            map.computeIfAbsent(u, pq -> new PriorityQueue<>(String::compareTo)).add(v);
        }

        List<String> ans = new ArrayList<>();
        dfs("JFK", map, ans);
        return ans;
    }

    private void dfs(String u, HashMap<String, PriorityQueue<String>> adj, List<String> ans) {
        ans.add(u);
        PriorityQueue<String> next = adj.getOrDefault(u, new PriorityQueue<>());
        while (!next.isEmpty()) {
            String v = next.poll();
            dfs(v, adj, ans);
        }
    }

    public static void main(String[] args) {
        List<List<String>> tickets = new ArrayList<>();
        tickets.add(List.of("JFK", "KUL"));
        tickets.add(List.of("JFK", "NRT"));
        tickets.add(List.of("NRT", "JFK"));

        var obj = new FindItinerary_332_1();
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