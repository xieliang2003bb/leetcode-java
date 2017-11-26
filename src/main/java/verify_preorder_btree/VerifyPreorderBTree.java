package verify_preorder_btree;

/**
 * Created by lxie on 11/26/17.
 */
public class VerifyPreorderBTree {
    public class Solution {
        public boolean isPreorderBTree(String preorder) {
            if (preorder.isEmpty()) return false;
            String[] v = preorder.split(",");
            int d = 0;
            for (int i = 0; i < v.length - 1; ++i) {
                if (v[i] == "#") {
                    if (d == 0) return false;
                    else --d;
                }
                else ++d;
            }
            return d != 0 ? false : v[v.length - 1] == "#";
        }

    }

    public static class UnitTest {

    }

}
