package DailyCodeChallenge.level_4;

import java.util.ArrayList;
import java.util.List;


class MyCalendar_2 {
    List<Pair<Integer, Integer>> list;

    public MyCalendar_2() {
        list = new ArrayList<>();
    }

    public boolean book(int start, int end) {
        end--;
        for (int i = 0; i < list.size(); i++) {
            if ((start >= list.get(i).first && start <= list.get(i).end) || (end >= list.get(i).first && end <= list.get(i).end) ||
                    (start <= list.get(i).first && end >= list.get(i).end))
            {
                return false;
            }
        }
        list.add(new Pair<>(start, end));
        return true;
    }

    public void printList() {
        for (Pair<Integer, Integer> it : list) {
            System.out.println("it = " + it);
        }
    }


    record Pair<K, V>(K first, V end) {
    }
}