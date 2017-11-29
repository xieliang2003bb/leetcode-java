package flatten_2d_vector;

import java.util.Iterator;
import java.util.List;

/**
 * Created by lxie on 11/29/17.
 */
public class Flatten2DVector implements Iterator<Integer> {

    private Iterator<List<Integer>> i;
    private Iterator<Integer> j;

    public Flatten2DVector(List<List<Integer>> vec2d) {
        // Initialize your data structure here
        i = vec2d.iterator();
        j = null;
    }

    @Override
    public Integer next() {
        // Write your code here
        hasNext();
        return j.next();
    }

    @Override
    public boolean hasNext() {
        // Write your code here
        while ((j == null || !j.hasNext()) && i.hasNext())
            j = i.next().iterator();
        return j != null && j.hasNext();
    }

    @Override
    public void remove() {}
}
