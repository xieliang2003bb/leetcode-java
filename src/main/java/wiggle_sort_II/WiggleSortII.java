package wiggle_sort_II;

import java.util.Arrays;

/**
 * Created by lxie on 1/8/18.
 */
public class WiggleSortII {

    public static void wiggleSort(int[] nums) {
        int[] tmp = Arrays.copyOf(nums, nums.length) ;
        int n = nums.length, k = (n + 1) / 2, j = n;
        Arrays.sort(tmp);
        for (int i = 0; i < n; ++i) {
            nums[i] = (i & 1) != 0  ? tmp[--j] : tmp[--k];
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 5, 1, 1, 6, 4};
        wiggleSort(nums);
        for (int i : nums) {
            System.out.print(i + ", ");
        }

    }
}
