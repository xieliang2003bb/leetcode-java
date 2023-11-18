package sort_chars_by_frequency;

import common.Pair;

import java.util.*;

/**
 * Created by lxie on 7/25/18.
 */

/* time limit exceeds */
public class SortCharsByFrequency {

    public String frequencySort(String s) {
        String res = "";
        PriorityQueue<Map.Entry<Integer, Character>> q = new PriorityQueue<>(100,
                new Comparator<Map.Entry<Integer, Character>>() {
            @Override
            public int compare(Map.Entry<Integer, Character> o1, Map.Entry<Integer, Character> o2) {
                return o2.getKey() - o1.getKey();
            }
        });

        Map<Character, Integer> m = new HashMap<>();
        for (char c : s.toCharArray()) {
            if (m.containsKey(c))
                m.put(c, m.get(c) + 1);
            else
                m.put(c, 1);
        }
        for (Map.Entry<Character, Integer> a : m.entrySet())
            q.add(Pair.of(a.getValue(), a.getKey()));
        while (!q.isEmpty()) {
            Map.Entry<Integer, Character> t = q.peek(); q.poll();
            for (int i=0; i<t.getKey(); ++i) res += t.getValue();
        }
        return res;
    }


    public static void main(String[] args) {

        SortCharsByFrequency scbf = new SortCharsByFrequency();
        String res = scbf.frequencySort("Aabb");
        System.out.println(res);
    }



}
