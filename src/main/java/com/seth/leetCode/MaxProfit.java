package com.seth.leetCode;

public class MaxProfit {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int buy = 0;
        boolean sell = false;
        if(prices.length < 2) return maxProfit;
        if(prices[1] > prices[0]) {
            buy = prices[0];
            sell = true;
        }
        for (int i = 1; i < prices.length; i++) {
            if(i == prices.length - 1) {
                if(sell) {
                    maxProfit = maxProfit + prices[i] - buy;
                }
            }
            else if(!sell) {
                if(prices[i + 1] > prices[i]) {
                    buy = prices[i];
                    sell = true;
                }
            }
            else {
                if(prices[i] > prices[i + 1]) {
                    sell = false;
                    maxProfit = maxProfit + prices[i] - buy;
                }
            }
        }
        return maxProfit;
    }
}
