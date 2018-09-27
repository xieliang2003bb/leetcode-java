package kth_largest_in_array;

/**
 * Created by lxie on 9/27/18.
 */
public class KthLargestInArray {

    public class Solution {

        public int findKthLargest(int[] nums, int k) {
            int left = 0, right = nums.length - 1;
            while (true) {
                int pos = partition(nums, left, right);
                if (pos == k - 1) return nums[pos];
                else if (pos > k - 1) right = pos - 1;
                else left = pos + 1;
            }
        }

        private int partition(int[] nums, int left, int right) {
            int pivot = nums[left], l = left + 1, r = right;
            while (l <= r) {
                if (nums[l] < pivot && nums[r] > pivot) {
                    swap(nums, l++, r--);
                }
                if (nums[l] >= pivot) ++l;
                if (nums[r] <= pivot) --r;
            }
            swap(nums, left, r);
            return r;
        }

        private void swap(int[] a, int i, int j) {
            int tmp = a[i];
            a[i] = a[j];
            a[j] = tmp;
        }


    }

    public class UnitTest {



    }

}
