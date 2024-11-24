package POTD_LEETCODE.Level_2;

import java.util.ArrayList;
import java.util.List;

class NearestPalindromic_564 {
    public String nearestPalindromic(String n) {
        int l = n.length();
        int firstHalfLength = (l & 1) == 0 ? l >> 1 : (l >> 1) + 1;
        long firstHalf = Long.parseLong(n.substring(0, firstHalfLength));

        List<Long> list = new ArrayList<>();
        list.add(mirrorNumber(firstHalf, (l & 1) == 0));
        list.add(mirrorNumber(firstHalf + 1, (l & 1) == 0));
        list.add(mirrorNumber(firstHalf - 1, (l & 1) == 0));
        list.add((long) (Math.pow(10, l) + 1));
        list.add((long) (Math.pow(10, l + 1) - 1));

        System.out.println("list = " + list);
        long num = Long.parseLong(n);
        long diff = Long.MAX_VALUE;
        long ans = -1;
        for (Long item : list) {
            if (item == num) continue;
            if (Math.abs(item - num) < diff) {
                ans = item;
            } else if (Math.abs(item - num) == diff) {
                ans = Math.min(ans, item);
            }
        }
        return "" + ans;
    }

    private Long mirrorNumber(long firstHalf, boolean isEven) {
        long temp = isEven ? firstHalf : firstHalf / 10;
        while (temp > 0) {
            firstHalf = firstHalf * 10 + temp % 10;
            temp /= 10;
        }
        return firstHalf;
    }

}