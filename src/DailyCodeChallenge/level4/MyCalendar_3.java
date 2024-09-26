package DailyCodeChallenge.level4;

import java.util.ArrayList;
import java.util.List;


class MyCalendar_3 {
    List<int[]> list;

    public MyCalendar_3() {
        list = new ArrayList<>();
    }

    public boolean book(int start, int end) {
        end--;
        for (int[] cal : list) {
            if ((start >= cal[0] && start <= cal[1]) || (end >= cal[0] && end <= cal[1]) || (start <= cal[0] && end >= cal[1])) {
                return false;
            }
        }
        list.add(new int[]{start, end});
        return true;
    }

    public boolean book2(int start, int end) {
        for (int[] cal : list) {
            if (cal[0] < end && start < cal[1]) {
                return false;
            }
        }
        list.add(new int[]{start, end});
        return true;
    }
}