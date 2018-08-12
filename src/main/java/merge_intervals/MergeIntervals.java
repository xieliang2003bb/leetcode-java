package merge_intervals;

import common.Interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MergeIntervals {

    public class Solution {
        public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
            ArrayList<Interval> ans = new ArrayList<Interval>();
            if (intervals.isEmpty()) return ans;
            Collections.sort(intervals, new Comparator<Interval>() {

                @Override
                public int compare(Interval i1, Interval i2) {
                    if (i1.start == i2.start) {
                        return i1.end - i2.end;
                    }
                    return i1.start - i2.start;
                }

            });

            ans.add(intervals.get(0));
            for (int i = 1; i < intervals.size(); ++i) {
                if (ans.get(ans.size()-1).end >= intervals.get(i).start) {
                    ans.get(ans.size()-1).end = Math.max(ans.get(ans.size()-1).end,
                            intervals.get(i).end);
                } else {
                    ans.add(new Interval(intervals.get(i).start, intervals.get(i).end));
                }
            }
            return ans;

        }
    }

    public static class UnitTest {

    }
}
