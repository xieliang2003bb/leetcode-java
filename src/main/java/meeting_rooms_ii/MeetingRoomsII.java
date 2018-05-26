package meeting_rooms_ii;

import common.Interval;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import static java.lang.Integer.max;

/**
 * Created by lxie on 5/25/18.
 */
public class MeetingRoomsII {

    public static class Solution {

        public int minMeetingRooms(List<Interval> intervals) {
            Map<Integer, Integer> m = new TreeMap<>();
            for (Interval a : intervals) {
                if (m.containsKey(a.start)) {
                    m.put(a.start, m.get(a.start)+1);
                } else {
                    m.put(a.start, 1);
                }

                if (m.containsKey(a.end)) {
                    m.put(a.end, m.get(a.end)-1);
                } else{
                    m.put(a.end, -1);
                }
            }
            int rooms = 0, res = 0;
            for ( Map.Entry<Integer, Integer> i : m.entrySet()) {
                res = max(res, rooms += i.getValue());
            }
            return res;
        }

    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(0, 30));
        intervals.add(new Interval(5, 10));
        intervals.add(new Interval(15, 20));

        int res = sol.minMeetingRooms(intervals);
        System.out.println("result is " + res);
    }


}
