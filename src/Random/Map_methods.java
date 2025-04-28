package Random;

import java.util.*;

public class Map_methods {
    public static void main(String[] args) {
        List<String> list1 = new ArrayList<>();
        list1.add("dp1");
        list1.add("dp2");
        list1.add("dp3");
        List<String> list2 = new ArrayList<>();
        list2.add("v1");
        list2.add("v2");
        list2.add("v3");

        Map<String, List<String>> map = new HashMap<>();
        map.put("dp", list1);
        map.put("v", list2);
        System.out.println(map);

        map.computeIfAbsent("dp", v -> new ArrayList<>()).add("newDp1");
        System.out.println(map);
        map.computeIfAbsent("dp", v -> new ArrayList<>()).add("newDp2");
        System.out.println(map);
        map.computeIfAbsent("dp", v -> new ArrayList<>()).add("newDp3");
        System.out.println(map);
        map.computeIfAbsent("ji", v -> new ArrayList<>());
        System.out.println(map);

    }
}
