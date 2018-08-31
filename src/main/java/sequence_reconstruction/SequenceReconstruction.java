package sequence_reconstruction;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lxie on 8/31/18.
 */
public class SequenceReconstruction {

    public class Solution {
        public boolean sequenceReconstruction(int[] org, int[][] seqs) {
            Map<Integer, Integer> m = new HashMap<>();
            Map<Integer, Integer> pre = new HashMap<>();
            for (int i = 0; i < org.length; ++i) m.put(org[i], i);
            for (int[] seq : seqs) {
                for (int i = 0; i < seq.length; ++i) {
                    if (!m.containsKey(seq[i])) return false;
                    if (i > 0 && m.get(seq[i - 1]) >= m.get(seq[i])) return false;
                    if (!pre.containsKey(seq[i])) {
                        pre.put(seq[i], (i > 0) ? m.get(seq[i - 1]) : -1);
                    } else {
                        pre.put(seq[i], Math.max(pre.get(seq[i]), (i > 0) ? m.get(seq[i - 1]) : -1));
                    }
                }
            }
            for (int i = 0; i < org.length; ++i) {
                if (pre.get(org[i]) != i - 1) return false;
            }
            return true;
        }
    }

    public class UnitTest {

    }

}
