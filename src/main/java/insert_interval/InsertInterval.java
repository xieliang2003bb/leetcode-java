package insert_interval;

import java.util.ArrayList;

import common.Interval;

public class InsertInterval {

    /**
     * "Output Limit Exceeded". Is there a perfect Java solution to pass the
     * tests?
     */
    public class Solution {

        public ArrayList<Interval> insert(ArrayList<Interval> intervals,
                Interval newInterval) {
            for (int i = 0; i < intervals.size(); i++) {
                Interval interval = intervals.get(i);
                if (newInterval.end > interval.start) {
                    intervals.add(i, newInterval);
                    return intervals;
                }
                if (newInterval.start >= interval.end) {
                    newInterval.start = Math.min(newInterval.start,
                            interval.start);
                    newInterval.end = Math.max(newInterval.end, interval.end);
                    intervals.remove(i);
                }
            }
            intervals.add(newInterval);
            return intervals;
        }
    }

    public static class UnitTest {

    }
}
