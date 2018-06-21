package bulls_and_cows;

/**
 * Created by lxie on 6/21/18.
 */
public class BullAndCows {

    public class Solution {

        public String getHint(String secret, String guess) {
            int bulls = 0, cows = 0;
            int[] m = new int[256];
            for (int i = 0; i < secret.length(); ++i) {
                if (secret.charAt(i) == guess.charAt(i)) ++bulls;
                else {
                    if (m[secret.charAt(i)]++ < 0) ++cows;
                    if (m[guess.charAt(i)]-- > 0) ++ cows;
                }
            }
            return  Integer.toString(bulls)+ "A" + Integer.toString(cows) + "B";
        }
    }

    public class UnitTest {


    }

}
