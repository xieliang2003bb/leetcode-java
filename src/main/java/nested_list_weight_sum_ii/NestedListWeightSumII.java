package nested_list_weight_sum_ii;

import common.NestedInteger;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lxie on 1/27/18.
 */
public class NestedListWeightSumII {

    public class Solution {

        public int depthSumInverse(List<NestedInteger> nestedList) {
            int res = 0;
            List<Integer> v = new ArrayList<>();
            for (NestedInteger a : nestedList) {
                helper(a, 0, v);
            }
            for (int i = v.size() - 1; i >= 0; --i) {
                res += v.get(i) * (v.size() - i);
            }
            return res;
        }
        void helper(NestedInteger ni, int depth, List<Integer> v) {
            if (depth >= v.size()) v.add(0);
            if (ni.isInteger()) {
                v.set(depth,  v.get(depth) + ni.getInteger());
            } else {
                for (NestedInteger a : ni.getList()) {
                    helper(a, depth + 1, v);
                }
            }
        }
    }

    public static class UnitTest {

    }

}
