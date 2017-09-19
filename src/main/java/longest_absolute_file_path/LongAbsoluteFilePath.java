package longest_absolute_file_path;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lxie on 9/19/17.
 */
public class LongAbsoluteFilePath {

    class Solution {
        public int lengthLongestPath(String input) {
            int res = 0;
            Map<Integer, Integer> m = new HashMap<>();
            m.put(0, 0);
            for (String s : input.split("\n")) {
                int level = s.lastIndexOf("\t") + 1;
                int len = s.substring(level).length();
                if (s.contains(".")) {
                    res = Math.max(res, m.get(level) + len);
                } else {
                    m.put(level + 1, m.get(level) + len + 1);
                }
            }
            return res;

        }
    }

    public static void main(String[] args) {
        System.out.println("this is for test");
    }
}
