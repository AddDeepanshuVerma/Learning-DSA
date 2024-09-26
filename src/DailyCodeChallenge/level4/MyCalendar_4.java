package DailyCodeChallenge.level4;

import java.util.Map;
import java.util.TreeMap;


class MyCalendar_4 {
    // using TreeMap : end -> start

    TreeMap<Integer, Integer> map = new TreeMap<>();

    public MyCalendar_4() {
        map.put(Integer.MAX_VALUE, Integer.MAX_VALUE);
    }

    public boolean book(int start, int end) {
        Integer prev = map.floorKey(start);
        Integer next = map.ceilingKey(start);

        /**
         * Returns the entry for the least key greater than the specified key; if
         * no such entry exists (i.e., the greatest key in the Tree is less than
         * or equal to the specified key), returns {@code null}.
         */
        Map.Entry<Integer, Integer> e = map.higherEntry(start);
        if (end <= e.getValue()) {
            map.put(end, start);
            return true;
        }
        return false;
    }
}