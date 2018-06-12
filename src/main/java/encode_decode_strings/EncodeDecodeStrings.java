package encode_decode_strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by lxie on 6/12/18.
 */
public class EncodeDecodeStrings {

    public static class Solution {

        // Encodes a list of strings to a single string.
        public String encode(List<String> strs) {
            String res = "";
            for (String a : strs) {
                res += Integer.toString(a.length()) + "/" + a;
            }
            return res;
        }
        // Decodes a single string to a list of strings.
        public List<String> decode(String s) {
            List<String> res = new ArrayList<>();
            int i = 0;
            while (i < s.length()) {
                int found = s.indexOf("/", i);
                int len = Integer.parseInt(s.substring(i, found));
                res.add(s.substring(found + 1, found + len + 1));
                i = found + len + 1;
            }
            return res;
        }



    }

    public static void main(String[] args) {
        System.out.println("this is for test");
        Solution sol = new Solution();

        String encoded = sol.encode(new ArrayList<>(Arrays.asList("a", "ab", "abc")));
        System.out.println("encode = " + encoded);

        List<String> decoded = sol.decode(encoded);
        System.out.println(decoded.toString());
    }

}
