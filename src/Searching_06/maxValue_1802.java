package Searching_06;

import java.security.spec.RSAOtherPrimeInfo;
import java.util.Arrays;

public class maxValue_1802 {
    public static void main(String[] args) {
        int[] arr= {1,1,1,1,1};
//        System.out.println(calculateSum2(4, 0, 1));
//        System.out.println("Sum of array :" + Arrays.stream(arr).sum());

        System.out.println(maxValue(4,0,4));

    }

    public static int maxValue(int n, int index, int maxSum) {
        long start = 0,
                end = maxSum,
                ans  = -1;
        while(start <= end){
            long mid = start + (end-start)/2;
            long sum = calculateSum2(n, index, mid);
            if(sum <= maxSum){
                ans = mid;
                start = mid+1;
            }else{
                end  = mid -1;
            }
        }
        return (int) ans;
    }

    public static long calculateSum2(long n, long index , long maxSum) {
        if(maxSum == 0) return -1;
        long emptyR = (n-1) - index,
                emptyL = index,
                sum = 0;
        long leftSum = 0,
                rightSum = 0,
                el = maxSum - 1;
        if (emptyR <= el) {
            rightSum = nthSum(el) - nthSum(el-emptyR);
        }else{
            rightSum = nthSum(el) + (emptyR - el);
        }
        if (emptyL <= el) {
            leftSum = nthSum(el) - nthSum(el-emptyL);
        }else{
            leftSum = nthSum(el) + (emptyL-el);
        }
        sum = leftSum + rightSum + maxSum;
        return sum;
    }

    private static long nthSum(long n) {
        return n * (n+1) /2;
    }

    public static long calculateSum(long n, long index , long el) {
        if(el < 1) return -1;
        long rightSideSum = 0,
                leftSideSum = 0;
        long rightE = n - index;
        //right side sum :
        if (el >= rightE) {
            rightSideSum = nthSum(el) - nthSum(el - n + index);
        }else{
            rightSideSum = nthSum(el) + (n- index - el);
        }
        //left side sum :
        if (el - 1 >= index) {
            leftSideSum = nthSum(el - 1) - nthSum(el - 1 - index);
        }else{
            leftSideSum = nthSum(el - 1) + (index - el + 1 );
        }
        System.out.println("sum of n: "+ n +", index: " + index +
                ", maxSum: " + el +" = " + (rightSideSum + leftSideSum) );
        return rightSideSum + leftSideSum;

    }

    public int maxValue2(int n, int index, int maxSum) {
        int x = (n-1) - index;
        int totalshifting  = (x * (x + 1)) / 2 + (index * (index +1))/2;
        int value = (maxSum + totalshifting)/n;

        if(index > value){
            return --value;
        }
        return value;
    }
}
