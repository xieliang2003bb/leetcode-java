package remove_duplicate_letters;

/**
 * Created by lxie on 11/17/17.
 */
public class RemoveDuplicateLetters {

    public class Solution {
        public String removeDuplicateLetters(String s) {
            int[] m = new int[256];
            int[] visited = new int[256];
            String res = "0";
            for (char a : s.toCharArray()) {
                ++m[a];
            }
            for (char a : s.toCharArray()) {
                --m[a];
                if (visited[a] != 0) continue;
                while (a < res.charAt(res.length()-1) && m[res.charAt(res.length()-1)] != 0) {
                    visited[res.charAt(res.length()-1)] = 0;
                    res = res.substring(0, res.length()-1);
                }
                res += a;
                visited[a] = 1;
            }
            return res.substring(1);
        }

    }

    public static class UnitTest {

    }
}
