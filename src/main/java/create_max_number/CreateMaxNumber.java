package create_max_number;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by lxie on 9/5/18.
 */
public class CreateMaxNumber {

    public static class Solution {

        public int[] maxNumber(int[] nums1, int[] nums2, int k) {
            int m = nums1.length, n = nums2.length;
            int[] res = {};
            for (int i = Math.max(0, k - n); i <= Math.min(k, m); ++i) {
                // constraint: k-i <= n, i <=m, i = [0, k]
                int[] merged = mergeVector(maxVector(nums1, i), maxVector(nums2, k - i));
                res = maxArray(res, merged) == 0 ? res : merged;
            }
            return res;
        }

        private int[] maxVector(int[] nums, int k) {
            int drop = nums.length - k;
            List<Integer> res = new ArrayList<>();
            for (int num : nums) {
                while (drop != 0 && res.size() != 0 && res.get(res.size()-1) < num) {
                    res.remove(res.size()-1);
                    --drop;
                }
                res.add(num);
            }
            res = res.subList(0, k);
            return res.stream().mapToInt(i->i).toArray();
        }

        private int[] mergeVector(int[] nums1, int[] nums2) {  // just a merge sort
            List<Integer> res = new ArrayList<>();
            int i = 0, j = 0;
            while (i < nums1.length && j < nums2.length) {
                if (maxArray(Arrays.copyOfRange(nums1, i, nums1.length),
                        Arrays.copyOfRange(nums2, j, nums2.length)) == 0) {
                    res.add(nums1[i++]);
                } else {
                    res.add(nums2[j++]);
                }
            }

            if (i < nums1.length) {
                for (int k = i; k < nums1.length; ++k) res.add(nums1[k]);
            } else {
                for (int k = j; k < nums2.length; ++k) res.add(nums2[k]);
            }

            return res.stream().mapToInt(m->m).toArray();
        }

        private int maxArray(int[] a, int[] b) {
            int i = 0, j = 0;
            while (i < a.length && j < b.length) {
                if (a[i] > b[j]) return 0;
                else if(a[i] < b[j]) return 1;
                i++; j++;
            }
            if(i == a.length) return 1;
            else return 0;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] a = {6,7};
        int[] b = {6,0,4};
        int[] res = sol.maxNumber(a, b, 5);
        System.out.println(res);
    }

}
