package k_empty_slots;

/**
 * Created by lxie on 8/18/18.
 */
public class KEmptySlots {

    public class Solution {

        public int kEmptySlots(int[] flowers, int k) {
            int res = Integer.MAX_VALUE, left = 0, right = k + 1, n = flowers.length;
            int[] days = new int[n];
            for (int i = 0; i < n; ++i) days[flowers[i] - 1] = i + 1;
            for (int i = 0; right < n; ++i) {
                if (days[i] < days[left] || days[i] <= days[right]) {
                    if (i == right) res = Math.min(res, Math.max(days[left], days[right]));
                    left = i;
                    right = k + 1 + i;
                }
            }
            return (res == Integer.MAX_VALUE) ? -1 : res;
        }
    }

    public class UnitTest {


    }
}
