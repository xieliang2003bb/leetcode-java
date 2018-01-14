package gas_station;

public class GasStation {

    public class Solution {
        public int canCompleteCircuit(int[] gas, int[] cost) {
            int total = 0, sum = 0, start = 0;
            for (int i = 0; i < gas.length; ++i) {
                total += gas[i] - cost[i];
                sum += gas[i] - cost[i];
                if (sum < 0) {
                    start = i + 1;
                    sum = 0;
                }
            }
            if (total < 0) return -1;
            else return start;
        }
    }

    public static class UnitTest {

    }
}
