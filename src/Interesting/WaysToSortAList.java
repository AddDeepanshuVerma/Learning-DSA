package Interesting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class WaysToSortAList {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> offlineQueries = new ArrayList<ArrayList<Integer>>();
        for (int i = 4; i >= 0; i--) {
            ArrayList<Integer> temp = new ArrayList<Integer>();
            temp.add(i);
            temp.add(i - 2);
            temp.add(i - 3);
            offlineQueries.add(temp);
        }

        offlineQueries.forEach(System.out::println);
        System.out.println("=======================");

        Collections.sort(offlineQueries, new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> a, ArrayList<Integer> b) {
                return a.get(0).compareTo(b.get(0));
            }
        });
        offlineQueries.sort(Comparator.comparing(a -> a.get(0)));
        offlineQueries.sort(Comparator.comparing(ArrayList::getFirst));
        offlineQueries.sort((a, b) -> a.get(0).compareTo(b.get(0)));
        offlineQueries.sort((a, b) -> a.getFirst() - b.getFirst());

        offlineQueries.forEach(System.out::println);
    }
}
