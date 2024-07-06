package Top_Interview_150;

class MaxProfit_121 {
    public static void main(String[] args) {
        int[] arr = {7,1,5,3,6,4};
        System.out.println(MaxProfit_121.maxProfit(arr));
    }
    public static int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int profit = 0;
        for (int price : prices) {
            if (price < min) min = price;
            profit = Math.max(profit, price - min);
        }
        return profit;
    }
}