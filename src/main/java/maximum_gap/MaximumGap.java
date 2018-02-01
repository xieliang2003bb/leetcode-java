package maximum_gap;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MaximumGap {

    public class Solution {
        public int maximumGap(int[] numss) {
            if (numss.length == 0) return 0;
            int mx = Integer.MIN_VALUE, mn = Integer.MAX_VALUE, n = numss.length;
            for (int d : numss) {
                mx = Integer.max(mx, d);
                mn = Integer.min(mn, d);
            }
            int size = (mx - mn) / n + 1;
            int bucket_nums = (mx - mn) / size + 1;

            int[] bucket_min = new int[bucket_nums];
            int[] bucket_max = new int[bucket_nums];
            Arrays.fill(bucket_min, Integer.MAX_VALUE);
            Arrays.fill(bucket_max, Integer.MIN_VALUE);

            Set<Integer> s = new HashSet<>();

            for (int d : numss) {
                int idx = (d - mn) / size;
                bucket_min[idx] = Integer.min(bucket_min[idx], d);
                bucket_max[idx] = Integer.max(bucket_max[idx], d);
                s.add(idx);
            }
            int pre = 0, res = 0;
            for (int i = 1; i < n; ++i) {
                if (!s.contains(i)) continue;
                res = Integer.max(res, bucket_min[i] - bucket_max[pre]);
                pre = i;
            }
            return res;
        }

    }

    public static class UnitTest {

    }
}

