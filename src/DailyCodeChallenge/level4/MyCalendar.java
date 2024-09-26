package DailyCodeChallenge.level4;

import java.util.HashSet;
import java.util.Set;

class MyCalendar {

    Set<Integer> set;

    public MyCalendar() {
        set = new HashSet<>();
    }

    public boolean book(int start, int end) {
        Set<Integer> temp = new HashSet<>();
        for (int i = start; i < end; i++) {
            if (set.contains(i)) {
                return false;
            } else {
                temp.add(i);
            }
        }
        set.addAll(temp);
        return true;
    }
}