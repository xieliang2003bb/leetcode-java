package product_array_except_self;

/**
 * Created by lxie on 12/11/17.
 */
public class ProductArrayExceptSelf {

    public class Solution {
        public int[] productExceptSelf(int[] nums) {
           int[] res = new int[nums.length];
           for (int i = 0; i < nums.length; ++i) res[i] = 1;
           for (int i = 1; i < nums.length; ++i) {
               res[i] = res[i-1] * nums[i-1];
           }
           int right = 1;
           for (int i = nums.length - 1; i >= 0; --i) {
               res[i] *= right;
               right *= nums[i];
           }
           return res;

        }
    }

    public static class UnitTest {

    }

}
