package Interesting;

class NumOfSubarrays_ {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5};
        NumOfSubarrays_ obj = new NumOfSubarrays_();
        System.out.println(obj.numOfSubarrays(arr));
    }

    public int numOfSubarrays(int[] arr) {
        long oddCount = 0, evenCount = 1;
        long prefix = 0, count = 0;
        for (int num : arr) {
            prefix += num;
            if ((prefix & 1) == 1) {// if prefix is ODD
                count += evenCount;
                oddCount++;
            } else {                // if prefix is even
                count += oddCount;
                evenCount++;
            }
        }
        return (int) (count % 1_000_000_007);
    }
}