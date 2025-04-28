package POTD_LEETCODE.level_4;

import java.util.ArrayList;
import java.util.List;

class MyCalendarTwo {
    public static void main(String[] args) {
        MyCalendarTwo obj = new MyCalendarTwo();
        System.out.println(obj.book(10, 20)); // return True, The event can be booked.
        System.out.println(obj.book(50, 60)); // return True, The event can be booked.
        System.out.println(obj.book(10, 40)); // return True, The event can be double booked.
        System.out.println(obj.book(5, 15));  // return False, The event cannot be booked, because it would
    }

    private final List<Pair<Integer, Integer>> validBookings;
    private final List<Pair<Integer, Integer>> doubleOverlappedBookings;

    private record Pair<K, V>(K first, V end) {
    }

    public MyCalendarTwo() {
        validBookings = new ArrayList<>();
        doubleOverlappedBookings = new ArrayList<>();
    }

    public boolean book(int start, int end) {
        // start and end overlaps any booking from already overlapped booking lists, return false
        for (var item : doubleOverlappedBookings) {
            if (overLapped(item.first, item.end, start, end)) {
                return false;
            }
        }
        // it does not overlap lets include to our validBooking, and it overlaps them, put that overlapped interval
        // in the overlapping bookings
        for (var item : validBookings) {
            if (overLapped(item.first, item.end, start, end)) {
                // get interval of overlapping and put that in overlapped intervals
                doubleOverlappedBookings.add(getOverlappedIntervals(item.first, item.end, start, end));
            }
        }
        validBookings.add(new Pair<>(start, end));
        return true;
    }

    private Pair<Integer, Integer> getOverlappedIntervals(Integer first, Integer second, int start, int end) {
        return new Pair<>(Math.max(first, start), Math.min(second, end));
    }

    private boolean overLapped(Integer first, Integer second, int start, int end) {
        return Math.max(first, start) < Math.min(second, end);
    }
}