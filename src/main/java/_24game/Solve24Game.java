package _24game;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lxie on 8/27/18.
 */
public class Solve24Game {

    public class Solution {

        public boolean judgePoint24(int[] nums) {
            double eps = 0.001;
            char[] ops = {'+', '-', '*', '/'};
            double[] arr = new double[nums.length];
            for(int i=0; i<nums.length; ++i) arr[i] = (double) nums[i];
            //System.arraycopy(nums, 0, arr, 0, nums.length);
            return helper(arr, ops, eps);
        }

        private boolean helper(double[] nums, char[] ops, double eps) {
            if (nums.length == 1) return Math.abs(nums[0] - 24) < eps;
            for (int i = 0; i < nums.length; ++i) {
                for (int j = 0; j < nums.length; ++j) {
                    if (i == j) continue;
                    List<Double> t = new ArrayList<>();
                    for (int k = 0; k < nums.length; ++k) {
                        if (k != i && k != j) t.add((double) nums[k]);
                    }
                    for (char op : ops) {
                        if ((op == '+' || op == '*') && i > j) continue;
                        if (op == '/' && nums[j] < eps) continue;
                        switch(op) {
                            case '+': t.add((double) nums[i] + nums[j]); break;
                            case '-': t.add((double) nums[i] - nums[j]); break;
                            case '*': t.add((double) nums[i] * nums[j]); break;
                            case '/': t.add((double) nums[i] / nums[j]); break;
                        }
                        double[] t1 = t.stream().mapToDouble(d -> d).toArray();
                        if (helper(t1, ops, eps)) return true;
                        t.remove(t.size()-1);
                    }
                }
            }
            return false;
        }
    }

    public class UnitTest {


    }

}
