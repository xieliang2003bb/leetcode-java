package nested_list_weight_sum;

import common.NestedInteger;

import java.util.List;

/**
 * Created by lxie on 1/27/18.
 */
public class NestedListWeightSum {

    public class Solution {

        public int depthSum(List<NestedInteger> nestedList) {
            return helper(nestedList, 1);
        }
        int helper(List<NestedInteger> nl, int depth) {
            int res = 0;
            for (NestedInteger a : nl) {
                res += a.isInteger() ? a.getInteger() * depth : helper(a.getList(), depth + 1);
            }
            return res;
        }
    }

    public static class UnitTest {

    }

}
