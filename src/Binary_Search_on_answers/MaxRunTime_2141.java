package Binary_Search_on_answers;

class MaxRunTime_2141 {
    public long maxRunTime2(int n, int[] batteries) {
        long start = Integer.MAX_VALUE, sum = 0, end = 0, ans = -1;
        long total_min_spent = 0;
        for (int num : batteries) {
            sum += num;
            start = Math.min(num, start);
        }
        end = sum / n;
        System.out.println("start = " + start);
        System.out.println("sum = " + sum);
        System.out.println("n = " + n);
        System.out.println("end = " + end);


        while (start <= end) {
            long mid = (start + end) >>> 1;
            if (isValid2(batteries, sum, mid, n)) {
                ans = mid;
                start = mid + 1;
            } else end = mid - 1;
        }
        return ans;
    }

    private boolean isValid3(int[] arr, long sum, long mid, long n) {
        // for n batteries & mid-minutes, total min
        long total_min_spent = 0;
        for (int i = 0; i < arr.length; i++) {
            total_min_spent += Math.min(arr[i], mid);
        }
//        now calculate average time spent = total_min_spent per computer / total computer
        return total_min_spent / n >= mid;
    }

    private boolean isValid2(int[] arr, long sum, long mid, long n) {
        // for n batteries & mid-minutes, total min
        long total_min_spent = mid * n;
        return sum >= total_min_spent;
    }


    public long maxRunTime(int n, int[] batteries) {
        long start = 1;
        long end = (long) 1E14;
        long ans = -1;
        while (start <= end) {
            long mid = (start + end) >>> 1;
            if (isValid(batteries, mid, n)) {
                ans = mid;
                start = mid + 1;
            } else end = mid - 1;
        }
        return ans;
    }

    private boolean isValid(int[] arr, long mid, long k) {
        long count = 0;
        for (long num : arr) {
            count += mid < num ? mid : num;
        }
        return count >= k * mid;
    }
}