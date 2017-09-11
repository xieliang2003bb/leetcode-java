package russian_doll_envelopes;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by lxie on 9/10/17.
 */
public class RussianDollEnvelopes {

    public class Solution {
        public int maxEnvelopes(int[][] envelopes) {
            int res = 0, n = envelopes.length;
            int[] dp = new int[n];
            Arrays.fill(dp, 1);
            Arrays.sort(envelopes, new Comparator<int[]>(){
                public int compare(int[] arr1, int[] arr2){
                    if(arr1[0] == arr2[0])
                        return arr1[1] - arr2[1];
                    else
                        return arr1[0] - arr2[0];
                }
            });
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < i; ++j) {
                    if (envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1]) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }
                res = Math.max(res, dp[i]);
            }
            return res;

        }
    }


    public static void main(String[] args) {

    }


}
