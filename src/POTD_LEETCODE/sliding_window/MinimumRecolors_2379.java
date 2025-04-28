package POTD_LEETCODE.sliding_window;

class MinimumRecolors_2379 {
    public int minimumRecolors(String blocks, int k) {
        // Black balls need to occur k times, minimum changes W to B = ?
        char[] arr = blocks.toCharArray();

        int i = 0, bCount = 0, wCount = 0;
        int maxBlackCount = Integer.MIN_VALUE;
        for (int j = 0; j < arr.length; j++) {
            if (arr[j] == 'W') wCount++;
            else bCount++;

            if (j - i + 1 == k) {
                maxBlackCount = Math.max(maxBlackCount, bCount);
                if (arr[i] == 'W') wCount--;
                else bCount--;
                i++;
            }
        }

        return k - maxBlackCount;
    }

    public int minimumRecolors2(String blocks, int k) {
        // Black balls need to occur k times, minimum changes W to B = ?
        char[] arr = blocks.toCharArray();

        int i = 0, black = 0;
        int maxBlackCount = Integer.MIN_VALUE;
        for (int j = 0; j < arr.length; j++) {
            if (arr[j] == 'B') black++;
            if (j - i + 1 == k) {
                maxBlackCount = Math.max(maxBlackCount, black);
                if (arr[i] == 'B') black--;
                i++;
            }
        }
//        return maxBlackCount == Integer.MIN_VALUE ? -1 : k - maxBlackCount;
        return k - maxBlackCount;
    }

    public int minimumRecolors3(String blocks, int k) {
        char[] arr = blocks.toCharArray();

        int i = 0, white = 0;
        int minWhiteCount = Integer.MAX_VALUE;
        for (int j = 0; j < arr.length; j++) {
            if (arr[j] == 'W') white++;
            if (j - i + 1 == k) {
                minWhiteCount = Math.min(minWhiteCount, white);
                if (arr[i] == 'W') white--;
                i++;
            }
        }
        return minWhiteCount;
    }
}