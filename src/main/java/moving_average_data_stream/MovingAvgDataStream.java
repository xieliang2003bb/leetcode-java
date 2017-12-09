package moving_average_data_stream;

import java.util.LinkedList;

/**
 * Created by lxie on 12/9/17.
 */
public class MovingAvgDataStream {
    private LinkedList<Integer> queue = new LinkedList<>();
    private int size;
    private double sum;

    public MovingAvgDataStream(int size) {
        this.size = size;
    }

    public double next(int val) {
        if (queue.size() >= size) {
            sum -= queue.getFirst();
            queue.remove(0);
        }
        queue.add(val);
        sum += val;
        return sum/queue.size();
    }

    public static class UnitTest {

    }
}
