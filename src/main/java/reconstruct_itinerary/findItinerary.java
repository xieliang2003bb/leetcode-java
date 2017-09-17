package reconstruct_itinerary;

import com.google.common.collect.TreeMultiset;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * Created by lxie on 9/16/17.
 */
public class findItinerary {

    public static class Solution {
        public List<String> findItinerary(String[][] tickets) {
            List<String> res = new ArrayList<>();
            HashMap<String, TreeMultiset<String>> m = new HashMap<>();
            for (String[] a : tickets) {
                if(m.get(a[0]) == null) {
                    m.put(a[0], TreeMultiset.create());
                }
                m.get(a[0]).add(a[1]);
            }
            dfs(m, "JFK", res);
            Collections.reverse(res);
            return res;
        }

        private void dfs(HashMap<String, TreeMultiset<String>> m, String s, List<String> res) {
            while (m.get(s) != null && m.get(s).size() != 0) {
                String t = m.get(s).firstEntry().toString();
                m.get(s).remove(t);
                dfs(m, t, res);
            }
            res.add(s);
        }
    }

    public static void main(String[] args) {
        System.out.println("this is for test");
        Solution sol = new Solution();
        String[][] tickets = {{"JFK", "KUL"}, {"JFK", "NRT"}, {"NRT", "JFK"}};
        List<String> res = sol.findItinerary(tickets);
        System.out.println(res.toString());
    }

}
