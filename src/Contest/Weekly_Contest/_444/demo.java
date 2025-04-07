package Contest.Weekly_Contest._444;

import java.util.Arrays;

public class demo {
    public static void main(String[] args) {
        Router obj = new Router(3);
        System.out.println("null");
        System.out.println(obj.addPacket(1, 4, 90));
        System.out.println(obj.addPacket(2, 5, 90));
        System.out.println(obj.addPacket(1, 4, 90));
        System.out.println(obj.addPacket(3, 5, 95));
        System.out.println(obj.addPacket(4, 5, 105));

        System.out.println(Arrays.toString(obj.forwardPacket()));
        System.out.println(obj.addPacket(5, 2, 110));
        System.out.println(obj.getCount(5, 100, 110));
    }

    public static void main2(String[] args) {
        Router obj = new Router(3);
        System.out.println("null");
        System.out.println(obj.addPacket(1,4,6));
        System.out.println(obj.getCount(4,1,4));
    }
}
