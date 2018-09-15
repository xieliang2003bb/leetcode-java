package student_attendance_record_ii;

/**
 * Created by lxie on 9/15/18.
 */
public class StudentAttendanceRecordII {

    public class Solution {

        public int checkRecord(int n) {
            int M = 1000000007;
            long[] P = new long[n + 1];
            long[] PorL = new long[n + 1];

            P[0] = 1; PorL[0] = 1; PorL[1] = 2;
            for (int i = 1; i <= n; ++i) {
                P[i] = PorL[i - 1];
                if (i > 1) PorL[i] = (P[i] + P[i - 1] + P[i - 2]) % M;
            }
            long res = PorL[n];
            // now we consider A
            for (int i = 0; i < n; ++i) {
            long t = (PorL[i] * PorL[n - 1 - i]) % M;
                res = (res + t) % M;
            }
            return (int) res;
        }
    }

    public class UnitTest {


    }
}
