package com.nt.arrayString;

import java.util.*;

class Buy {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int max_profit=0;
        int buy_price = prices[0];
        int curr_profit = 0;
        for (int i = 1; i<n ; i++){
            if (prices[i]<buy_price){
                buy_price=prices[i];
            }
            else{
                curr_profit = prices[i]-buy_price;
                 max_profit = curr_profit + max_profit;
            }
            buy_price = prices[i];
        }
        return max_profit ;
    }
}    
   

public class BestTimetoBuyandSellStockII {
	public static void main(String[] args) {
        Buy obj = new Buy();

        // Example test
        int[] prices = {7,1,5,3,6,4};
        int result = obj.maxProfit(prices);

        System.out.println("Maximum Profit: " + result);
    }

}
