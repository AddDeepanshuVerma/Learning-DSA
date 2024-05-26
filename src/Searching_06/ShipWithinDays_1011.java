package Searching_06;

public class ShipWithinDays_1011 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        int[] arr2 = {1,2,3,1,1};
        System.out.println(shipWithinDays(arr2, 4));
//        System.out.println(getDays(arr2, 3));
    }
    public static int shipWithinDays(int[] weights, int days) {
        //sum of array: so that we could have a range
        int start = 0, end = 0, mid = 0,ans = 0;
        for (int n : weights) {
            end += n;
            start = Math.max(start, n);
        }
        while (start <= end) {
            mid = (start+end)>>1;
            int noOfDays = getDays(weights, mid);
            if(noOfDays <= days){
                ans = mid;
                end = mid - 1;
            }else if((noOfDays > days)){
                start = mid+1;
            }
        }
        return ans;
    }

    public static int getDays(int[] arr, int weight) {
        int countDays = 1;
        int tempWeight = weight;
        for (int i = 0; i < arr.length; i++) {
            if(weight - arr[i] >= 0){
                weight -= arr[i];
            }else{
                i--;
                weight = tempWeight;
                countDays++;
            }
        }
        return countDays;
    }

}
