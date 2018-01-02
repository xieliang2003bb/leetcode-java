package skyline_problem;

import com.google.common.collect.TreeMultiset;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by lxie on 1/2/18.
 */
public class SkylineProblem {

    public static class Solution {
        public List<int[]> getSkyline(int[][] buildings) {
            List<int[]> h = new ArrayList<>();
            List<int[]> res = new ArrayList<>();
            TreeMultiset<Integer> m = TreeMultiset.create(); // sort elements
            int pre = 0, cur = 0;
            for (int[] a : buildings) {
                int[] aa = {a[0], -a[2]};
                h.add(aa);
                int[] bb = {a[1], a[2]};
                h.add(bb);
            }

            Collections.sort(h, new Comparator<int[]>() {
                public int compare(int[] arr1, int[] arr2) {
                    if (arr1[0] == arr2[0])
                        return arr1[1] - arr2[1];
                    else
                        return arr1[0] - arr2[0];
                }
            });

            m.add(0);
            for (int[] a : h) {
                if (a[1] < 0) m.add(-a[1]);
                else m.remove(a[1]);
                cur = m.lastEntry().getElement();
                if (cur != pre) {
                    int[] aa = {a[0], cur};
                    res.add(aa);
                    pre = cur;
                }
            }
            return res;
        }

    }


    public static void main(String[] args) {
        System.out.println("this is for test");
        Solution sol = new Solution();
        int[][] buildings = {{2, 9, 10}, {3, 7, 15}, {5, 12, 12}, {15, 20, 10}, {19, 24, 8}};
        List<int[]> result = sol.getSkyline(buildings);
        for (int[] a : result) {
            System.out.println("[" + a[0] + ", " + a[1] + "], ");
        }

    }
}