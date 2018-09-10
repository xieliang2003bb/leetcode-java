package shopping_offers;

import java.util.List;

/**
 * Created by lxie on 9/9/18.
 */
public class ShoppingOffers {

    public class Solution {

        public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
            int res = 0, n = price.size();
            for (int i = 0; i < n; ++i) {
                res += price.get(i) * needs.get(i);
            }
            for (List<Integer> offer : special) {
                boolean isValid = true;
                for (int j = 0; j < n; ++j) {
                    if (needs.get(j) - offer.get(j) < 0) isValid = false;
                    needs.set(j, needs.get(j) - offer.get(j));
                }
                if (isValid) {
                    res = Math.min(res, shoppingOffers(price, special, needs) + offer.get(offer.size()-1));
                }
                for (int j = 0; j < n; ++j) {
                    needs.set(j, needs.get(j) + offer.get(j));  // backtracking
                }
            }
            return res;
        }
    }

    public class UnitTest {

    }

}
