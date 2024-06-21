package DailyCodeChallenge.Binary_Search_on_answers;

class MinDays_1482_2 {
    public static void main(String[] args) {
        int[] arr = {1,10,3,10,2};
        System.out.println(minDays(arr, 3, 2));
    }

    public static int minDays(int[] bloomDay, int m, int k) {
        long inRange = (long) m * k;
        if(bloomDay.length < inRange) return -1;
        // answer lies in the range of [min_day, max_day], hence we will apply bs here
        // the condition that will check will be a separate function

        int min_day = 0;
        int max_day = 0;
        for (int i = 0; i < bloomDay.length; i++) {
            min_day = Math.min(min_day, bloomDay[i]);
            max_day = Math.max(max_day, bloomDay[i]);
        }
        int ans = -1;
        while (min_day <= max_day) {
            int mid = (min_day + max_day) >> 1;
            if (bouq_created(bloomDay, m, k, mid)) {
                ans = mid;
                max_day = mid - 1;
            } else {
                min_day = mid + 1;
            }
        }
        return ans;
    }

    private static boolean bouq_created(int[] bloomDay, int m, int k, int days_spent) {
        int bouq_created = 0;
        int curr_count = 0;
        for (int i = 0; i < bloomDay.length; i++) {
            if (bloomDay[i] <= days_spent) {
                curr_count++;
            } else curr_count = 0;
            if (curr_count == k) {
                bouq_created++;
                curr_count = 0;
            }
            if (bouq_created == m) {
                return true;
            }
        }
        return false;
    }
}
















