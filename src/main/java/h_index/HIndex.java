package h_index;

import java.util.Collections;
import java.util.List;

/**
 * Created by lxie on 6/14/18.
 */
public class HIndex {

    public class Solution {

        int hIndex(List<Integer> citations) {
            Collections.sort(citations, Collections.reverseOrder());

            for (int i = 0; i < citations.size(); ++i) {
                if (i >= citations.get(i)) return i;
            }
            return citations.size();
        }
    }

    public class UnitTest {

    }


}
