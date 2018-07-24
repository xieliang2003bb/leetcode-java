package design_hit_counter;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by lxie on 7/24/18.
 */
public class HitCounter {

    private Queue<Integer> q = new LinkedList<>();

    public HitCounter() {};

    /** Record a hit.
     @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        q.add(timestamp);
    }

    /** Return the number of hits in the past 5 minutes.
     @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        while (q.isEmpty() && timestamp - q.peek() >= 300) {
            q.poll();
        }
        return q.size();
    }
    
}
