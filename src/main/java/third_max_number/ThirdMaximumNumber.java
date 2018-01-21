package third_max_number;

/**
 * Created by lxie on 1/20/18.
 */
public class ThirdMaximumNumber {

    public class Solution {

        public int thirdMax(int[] nums) {
            long first = Long.MIN_VALUE, second = Long.MIN_VALUE, third = Long.MIN_VALUE;
            for (int num : nums) {
                if (num > first) {
                    third = second;
                    second = first;
                    first = num;
                } else if (num > second && num < first) {
                    third = second;
                    second = num;
                } else if (num > third && num < second) {
                    third = num;
                }
            }
            return (third == Long.MIN_VALUE || third == second) ? (int)first : (int)third;
        }
    }

    public static class UnitTest {

    }
}
