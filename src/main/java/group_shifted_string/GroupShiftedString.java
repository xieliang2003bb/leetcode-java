package group_shifted_string;

import java.util.*;

/**
 * Created by lxie on 3/19/18.
 */
public class GroupShiftedString {

    public static class Solution {

        List<List<String>> groupStrings(List<String> strings) {
            List<List<String>> res = new ArrayList<>();
            Map<String, TreeSet<String>> m = new HashMap<>();
            for (String a : strings) {
                String t = "";
                for (char c : a.toCharArray()) {
                    t += Integer.toString((c + 26 - a.toCharArray()[0]) % 26) + ",";
                }
                if (!m.containsKey(t)) {
                    TreeSet<String> tset = new TreeSet<>();
                    tset.add(a);
                    m.put(t, tset);
                } else {
                    m.get(t).add(a);
                }
            }
            for (Map.Entry<String, TreeSet<String>> entry : m.entrySet()) {
                res.add(new ArrayList<>(entry.getValue()));
            }
            return res;
        }
    }

    public static void main(String[] args) {
        System.out.println("this is for test");
        Solution s = new Solution();
        List<String> strings = new ArrayList<String>(Arrays.asList(
                "abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"));
        System.out.println(s.groupStrings(strings));
    }

}
