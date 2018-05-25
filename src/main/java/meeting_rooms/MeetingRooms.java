package meeting_rooms;

import common.Interval;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by lxie on 5/25/18.
 */
public class MeetingRooms {

    public class Solution {

        public boolean canAttendMeetings(Interval[] intervals) {
            if(intervals == null || intervals.length == 0) return true;
            Arrays.sort(intervals, new Comparator<Interval>(){
                @Override
                public int compare(Interval i1, Interval i2){
                    return i1.start - i2.start;
                }
            });
            for (int i = 1; i < intervals.length; ++i) {
                if (intervals[i].start < intervals[i - 1].end) {
                    return false;
                }
            }
            return true;
        }
    }

    public class UnitTest {



    }


}
