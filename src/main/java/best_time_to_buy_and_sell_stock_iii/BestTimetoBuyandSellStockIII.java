package best_time_to_buy_and_sell_stock_iii;

public class BestTimetoBuyandSellStockIII {

    public class Solution {
        public int maxProfit(int[] prices) {
            int len = prices.length;
            if (len==0) return 0;

            int[] historyProfit = new int[len];
            int[] futureProfit = new int[len];

            int valley = prices[0];
            int peak = prices[len-1];
            int maxProfit = 0;

            // forward, calculate max profit until this time
            for (int i = 0; i<len; ++i)
            {
                valley = Integer.min(valley,prices[i]);
                if(i>0)
                {
                    historyProfit[i] = Integer.max(historyProfit[i-1],prices[i]-valley);
                }
            }

            // backward, calculate max profit from now, and then sum with history
            for (int i = len-1; i>=0; --i)
            {
                peak = Integer.max(peak, prices[i]);
                if (i<len-1)
                {
                    futureProfit[i] = Integer.max(futureProfit[i+1],peak-prices[i]);
                }
                maxProfit = Integer.max(maxProfit,historyProfit[i]+futureProfit[i]);
            }
            return maxProfit;

        }
    }

    public static class UnitTest {

    }
}
