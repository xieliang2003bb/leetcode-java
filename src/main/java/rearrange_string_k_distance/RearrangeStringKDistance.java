package rearrange_string_k_distance;

import javafx.util.Pair;

import java.util.*;

/**
 * Created by lxie on 12/9/17.
 */
public class RearrangeStringKDistance {
    public static class Solution {
        public String RearrangeString(String str, int k) {
            if (k == 0) return str;
            String res = "";
            int len = str.length();
            Map<Character, Integer> m = new HashMap<>();
            PriorityQueue<Pair<Integer, Character>> q = new PriorityQueue<>();
            for (char a : str.toCharArray()) {
                if (!m.containsKey(a)) m.put(a, 1);
                else
                    m.put(a, m.get(a)+1);
            };
            for (Map.Entry<Character,Integer> entry : m.entrySet()) {
                q.add(new Pair<Integer, Character>(entry.getValue(), entry.getKey()));
            }
            while (!q.isEmpty()) {
                List<Pair<Integer, Character>> v = new ArrayList<>(); // for temp store
                int cnt = Integer.min(k, len);
                for (int i = 0; i < cnt; ++i) {
                    if (q.isEmpty()) return "";
                    Pair<Integer, Character> t = q.peek(); q.poll(); // highest count first
                    res += t.getValue();
                    int count = t.getKey();
                    if (--count > 0) v.add(t);
                    --len;
                }
                for (Pair<Integer, Character> a : v) q.add(a);
            }
            return res;

        }
    }

    public static class UnitTest {

    }







}
