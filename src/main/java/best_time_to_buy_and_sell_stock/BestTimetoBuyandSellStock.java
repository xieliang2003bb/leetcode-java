package best_time_to_buy_and_sell_stock;

public class BestTimetoBuyandSellStock {

    public class Solution {
        public int maxProfit(int[] prices) {
            int res = 0, buy = Integer.MAX_VALUE;
            for (int price : prices) {
                buy = Math.min(buy, price);
                res = Math.max(res, price - buy);
            }
            return res;
        }
    }

    public static class UnitTest {

    }
}
