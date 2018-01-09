package best_time_to_buy_and_sell_stock_cool_down;

public class BestTimetoBuyandSellStockCoolDown {

    public class Solution {
        public int maxProfit(int[] prices)  {
            int buy = Integer.MIN_VALUE, pre_buy = 0, sell = 0, pre_sell = 0;
            for (int price : prices) {
                pre_buy = buy;
                buy = Integer.max(pre_sell - price, pre_buy);
                pre_sell = sell;
                sell = Integer.max(pre_buy + price, pre_sell);
            }
            return sell;
        }
    }
}

