package split_array_into_consecutive_subsequences;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lxie on 9/18/18.
 */
public class SplitArray2ConseqSubseq {

    public boolean isPossible(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        Map<Integer, Integer> need = new HashMap<>();
        for (int num : nums) {
            if (freq.containsKey(num)) freq.put(num, freq.get(num) + 1);
            else
                freq.put(num, 1);
        }
        for (int num : nums) {
            if (freq.containsKey(num) && freq.get(num) == 0) continue;
            else if (need.containsKey(num) && need.get(num) > 0) {
                need.put(num, need.get(num) - 1);
                if (need.containsKey(num+1))
                    need.put(num+1, need.get(num+1) + 1);
                else
                    need.put(num+1, 1);
            } else if (freq.containsKey(num+1) && freq.get(num + 1) > 0 &&
                    freq.containsKey(num+2) && freq.get(num + 2) > 0) {
                freq.put(num+1, freq.get(num + 1) - 1);
                freq.put(num+2, freq.get(num + 2) - 1);
                if (need.containsKey(num+3))
                    need.put(num+3, need.get(num+3) + 1);
                else
                    need.put(num+3, 1);
            } else return false;
            freq.put(num, freq.get(num) - 1);
        }
        return true;
    }

    public static void main(String[] args) {
        SplitArray2ConseqSubseq s = new SplitArray2ConseqSubseq();
        int[] input = {1,2,3,3,4,4,5,5};
        boolean res = s.isPossible(input);
        System.out.println(res);
    }




}
