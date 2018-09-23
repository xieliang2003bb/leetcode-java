package max_avg_subarray_ii;

import com.google.common.primitives.Doubles;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by lxie on 9/22/18.
 */
public class MaxAvgSubarrayII {

        public double findMaxAverage(int[] nums, int k) {
            List<Double> numsd = Doubles.asList(Arrays.stream(nums).asDoubleStream().toArray());
            double left = Collections.min(numsd);
            double right = Collections.max(numsd);
            while (right - left > 1e-5) {
                double minSum = 0, sum = 0, preSum = 0, mid = left + (right - left) / 2;
                boolean check = false;
                for (int i = 0; i < nums.length; ++i) {
                    sum += nums[i] - mid;
                    if (i >= k) {
                        preSum += nums[i - k] - mid;
                        minSum = Math.min(minSum, preSum);
                    }
                    if (i >= k - 1 && sum > minSum) {check = true; break;}
                }
                if (check) left = mid;
                else right = mid;
            }
            return left;
        }

    public static void main(String[] args) {
        MaxAvgSubarrayII m = new MaxAvgSubarrayII();
        int[] input = {1,12,-5,-6,50,3};
        System.out.println(m.findMaxAverage(input, 4));
    }

}
