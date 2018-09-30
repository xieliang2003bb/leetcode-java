package increasing_triplet_subsequence;

/**
 * Created by lxie on 9/30/18.
 */
public class IncreasingTripletSubsequence {

    public class Solution {

        boolean increasingTriplet(int[] nums) {
            int m1 = Integer.MAX_VALUE, m2 = Integer.MAX_VALUE;
            for (int a : nums) {
                if (m1 >= a) m1 = a;  // m1 leaves INT_MAX ealier than m2
                else if (m2 >= a) m2 = a;
                else return true;
            }
            return false;
        }
    }

    public class UnitTest {


    }

}
