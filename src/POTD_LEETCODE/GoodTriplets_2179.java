package POTD_LEETCODE;

class GoodTriplets_2179 {
    public long goodTriplets(int[] nums1, int[] nums2) {
        int[] map = new int[nums2.length];
        for (int i = 0; i < nums2.length; i++) {
            map[nums2[i]] = i;
        }

        int count = 0;
        for (int i = 0; i < nums1.length; i++) {
            int x = nums1[i];
            for (int j = i + 1; j < nums1.length; j++) {
                int y = nums1[j];
                if (map[x] > map[y]) continue;
                for (int k = j + 1; k < nums1.length; k++) {
                    int z = nums1[k];
                    if (map[y] > map[z]) continue;
                    count++;
                }
            }
        }

        return count;
    }

    public long goodTriplets2(int[] nums1, int[] nums2) {
        int[] map = new int[nums2.length];
        for (int i = 0; i < nums2.length; i++) {
            map[nums2[i]] = i;
        }

        int count = 0;
        for (int i = 0; i < nums1.length; i++) {
            for (int j = i + 1; j < nums1.length; j++) {
                if (map[nums1[i]] > map[nums1[j]]) continue;
                for (int k = j + 1; k < nums1.length; k++) {
                    if (map[nums1[j]] > map[nums1[k]]) continue;
                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] n1 = {2, 0, 1, 3};
        int[] n2 = {0, 1, 2, 3};
        var obj = new GoodTriplets_2179();
        long count = obj.goodTriplets(n1, n2);
        System.out.println("count = " + count);
    }
}