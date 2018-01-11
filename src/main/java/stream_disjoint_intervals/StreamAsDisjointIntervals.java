package stream_disjoint_intervals;

import common.Interval;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lxie on 1/11/18.
 */
public class StreamAsDisjointIntervals {

    /**
     * Definition for an interval.
     * public class Interval {
     *     int start;
     *     int end;
     *     Interval() { start = 0; end = 0; }
     *     Interval(int s, int e) { start = s; end = e; }
     * }
     */
    class SummaryRanges {

        private List<Interval> v = new ArrayList<>();

        /** Initialize your data structure here. */
        public SummaryRanges() {

        }

        public void addNum(int val) {
            Interval cur = new Interval(val, val);
            List<Interval> res = new ArrayList<>();
            int pos = 0;
            for (Interval a : v) {
                if (cur.end + 1 < a.start) {
                    res.add(a);
                } else if (cur.start > a.end + 1) {
                    res.add(a);
                    ++pos;
                } else {
                    cur.start = Integer.min(cur.start, a.start);
                    cur.end = Integer.max(cur.end, a.end);
                }
            }
            res.add(pos, cur);
            v = res;
        }

        public List<Interval> getIntervals() {
            return v;
        }
    }


    public static class UnitTest {

    }


}
