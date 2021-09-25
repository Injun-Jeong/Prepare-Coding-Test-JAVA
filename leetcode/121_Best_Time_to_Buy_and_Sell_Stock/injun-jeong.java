package leetcode;

public class Q121_Best_Time_to_Buy_and_Sell_Stock {
    public int maxProfit(int[] prices) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;

        for (int idx = 0; idx < prices.length; idx++) {
            minprice = prices[idx] < minprice ? prices[idx] : minprice;
            maxprofit = maxprofit < prices[idx] - minprice ? prices[idx] - minprice : maxprofit;
        }

        return maxprofit;
    }
}
