package sort_chars_by_frequency;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lxie on 7/25/18.
 */

/* time limit exceeds */
public class SortCharsByFrequency {

    public String frequencySort(String s) {
        String res = "";
        String[] v = new String[s.length()+1];
        for (int i=0; i<v.length; ++i) v[i] = "";
        Map<Character, Integer> m = new HashMap<>();
        for (char c : s.toCharArray()) {
            if (!m.containsKey(c)) {
                m.put(c, 1);
            } else {
                m.put(c, m.get(c)+1);
            }
        }
        for (Map.Entry<Character, Integer> a : m.entrySet()) {
            for(int i=0; i<a.getValue(); ++i) {
                v[a.getValue()] += a.getKey();
            }
        }
        for (int i = s.length(); i > 0; --i) {
            if (!v[i].isEmpty()) {
                res += v[i];
            }
        }
        return res;
    }

    public static void main(String[] args) {

        SortCharsByFrequency scbf = new SortCharsByFrequency();
        System.out.println(scbf.frequencySort("Aabb"));
    }



}
