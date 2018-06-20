package find_median_in_stream;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Created by lxie on 6/20/18.
 */
public class MedianInStream {

    // by default min heap in java
    private PriorityQueue small = new PriorityQueue<Integer>(30, Collections.reverseOrder());
    private PriorityQueue large = new PriorityQueue<Integer>(30);


    public void addNum(int num) {
        small.add(num);
        large.add(small.peek());
        small.poll();
        if (small.size() < large.size()) {
            small.add(large.peek());
            large.poll();
        }
    }

    // Returns the median of current data stream
    public double findMedian() {
        return small.size() > large.size() ? (double) small.peek() : 0.5 *((int)small.peek() + (int)large.peek());
    }

}
