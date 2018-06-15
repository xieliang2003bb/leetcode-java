package zigzag_iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lxie on 6/15/18.
 */
public class ZigzagIterator {

    private List<Integer> v = new ArrayList<>();
    public int i = 0;

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        int n1 = v1.size(), n2 = v2.size(), n = Math.max(n1, n2);
        for (int i = 0; i < n; ++i) {
            if (i < n1) v.add(v1.get(i));
            if (i < n2) v.add(v2.get(i));
        }
    }

    public int next() {
        return v.get(i++);
    }

    public boolean hasNext() {
        return i < v.size();
    }

}
