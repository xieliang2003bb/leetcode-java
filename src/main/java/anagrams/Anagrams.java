package anagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Anagrams {

    public class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            Map<String, List<String>> dict = new HashMap<String, List<String>>();
            for (String str : strs) {
                char[] cs = str.toCharArray();
                Arrays.sort(cs);
                String anagram = new String(cs);
                List<String> l = dict.get(anagram);
                if (l == null) {
                    l = new ArrayList<String>();
                    dict.put(anagram, l);
                }
                l.add(str);
            }
            List<List<String>> ans = new ArrayList<>();
            for (Entry<String, List<String>> e : dict.entrySet()) {
                    ans.add(e.getValue());
            }
            return ans;
        }
    }

    public static class UnitTest {

    }
}
