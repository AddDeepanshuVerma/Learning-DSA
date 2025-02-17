package POTD_LEETCODE.Array;

class MaxChunksToSorted_768 {
    public int maxChunksToSorted(int[] arr) {
        int max = 0, chunk = 0;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
            if (max == (i + i)) { // we found our first chunk
                chunk++;
                max = 0;
            }
        }
        return chunk;
    }
}