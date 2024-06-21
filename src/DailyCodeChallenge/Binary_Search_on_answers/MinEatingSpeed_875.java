package DailyCodeChallenge.Binary_Search_on_answers;

import java.util.Arrays;

class MinEatingSpeed_875 {

    public int minEatingSpeed(int[] piles, int h) {
        int start = 1;
        int end = Arrays.stream(piles).max().getAsInt();
        int ans = -1;
        while (start <= end) {
            int mid = (start + end) >>> 1;
            if (finished(piles, mid, h)) {
                ans = mid;
                end = mid - 1;
            } else start = mid + 1;
        }
        return ans;
    }

    private boolean finished(int[] piles, int mid, int h) {
        long count = 0;
        for (int i = 0; i < piles.length; i++) {
            count += piles[i] / mid;
            if (piles[i] % mid != 0) {
                count++;
            }
            if(count > h) return false;
        }
        return count <= h;
    }

}