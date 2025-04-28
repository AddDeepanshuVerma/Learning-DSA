package Contest.Weekly_Contest._444;

import java.util.*;

class Router {
    private final LinkedHashSet<Trio> lhs;                  //duplicate detector + works as double ended queue
    private final HashMap<Integer, List<Integer>> dtts;     //destinationToTimeStamps
    int limit;

    public Router(int memoryLimit) {
        limit = memoryLimit;
        lhs = new LinkedHashSet<Trio>();
        dtts = new HashMap<>();
    }

    public boolean addPacket(int source, int destination, int timestamp) {
        Trio toAdd = new Trio(source, destination, timestamp);
        if (lhs.contains(toAdd)) return false;              // duplicate
        if (lhs.size() == limit) forwardPacket();           // was full need to remove first one
        lhs.add(toAdd);                                     // safe to add now
        dtts.computeIfAbsent(toAdd.dst, list -> new ArrayList<>()).add(toAdd.time);
        return true;
    }

    public int[] forwardPacket() {
        if (lhs.isEmpty()) return new int[]{};
        Trio trio = lhs.removeFirst();
        // remove from destinationToTimeStamps:dtts using binarySearch
        List<Integer> times = dtts.get(trio.dst);
        int idx = Collections.binarySearch(times, trio.time);
        if (idx != -1) times.remove(idx);
        return new int[]{trio.src, trio.dst, trio.time};
    }

    public int getCount(int destination, int startTime, int endTime) {
        List<Integer> list = dtts.get(destination);
        if (list.isEmpty()) return 0;
        int first = first(list, startTime);                 // first occurance or default : list.size
        int last = last(list, endTime);                     // last occurance or default : -1
        return last - first + 1;
    }


    private int first(List<Integer> list, int target) {
        int start = 0, end = list.size() - 1;
        int ans = end + 1;
        while (start <= end) {
            int mid = (start + end) >>> 1;
            if (list.get(mid) >= target) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ans;
    }

    private int last(List<Integer> list, int target) {
        int start = 0, end = list.size() - 1;
        int ans = -1;
        while (start <= end) {
            int mid = (start + end) >>> 1;
            if (list.get(mid) <= target) {
                ans = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return ans;
    }

    record Trio(int src, int dst, int time) {
    }
}