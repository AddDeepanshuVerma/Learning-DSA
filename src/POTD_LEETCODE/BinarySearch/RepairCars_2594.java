package POTD_LEETCODE.BinarySearch;

class RepairCars_2594 {
    public long repairCars(int[] ranks, int cars) {
        long start = 0;
//        long end = Long.MAX_VALUE;

//        int minimumRank = 0;
//        for (int rank : ranks) minimumRank = Math.min(minimumRank, rank);
//        long end = (long) minimumRank * cars * cars;

        long end = (long) 1e18;

        long ans = -1;
        while (start <= end) {
            long mid = (start + end) >> 1;
            if (possible(mid, cars, ranks)) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ans;
    }

    private boolean possible(long minutes, int minCar, int[] ranks) {
        long countCar = 0;
        for (int rank : ranks) {
            countCar += (long) Math.sqrt((double) minutes / rank);
            if (countCar >= minCar) {
                return true;
            }
        }
        return false;
    }
}