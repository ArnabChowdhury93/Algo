/**
 *
 * 121. Best Time to Buy and Sell Stock
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 *
 */
class StockBuyAndSell{
    public int maxProfit(int[] prices) {
        if(prices.length==0){
            return 0;
        }

        int currentBuy = prices[0];
        int globalProfit = 0;
        for(int i = 1; i < prices.length; i++){
            if(currentBuy > prices[i]){
                currentBuy = prices[i];
                continue;
            }
            else{
                globalProfit = Math.max(globalProfit, prices[i] - currentBuy);
            }
        }
        return globalProfit;

    }
}