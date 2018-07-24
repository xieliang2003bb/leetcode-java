package range_addition;

/**
 * Created by lxie on 7/23/18.
 */
public class RangeAddition {

    public class Solution {

        public int[] getModifiedArray(int length, int[][] updates) {
            // Write your code here
            int add[] = new int[length + 1];
            int res[] = new int[length];
            for(int i = 0; i < updates.length; i++){
                int first = updates[i][0];
                int second = updates[i][1];
                int third = updates[i][2];

                add[first] += third;
                add[second + 1] -= third;
            }
            res[0] = add[0];
            for(int i = 1; i < res.length; i++){
                res[i] = add[i] + res[i - 1];
            }

            return res;
        }

    }

    public class UnitTest {

    }

}
