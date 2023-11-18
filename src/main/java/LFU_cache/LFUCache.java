package LFU_cache;

import common.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lxie on 8/29/18.
 */
public class LFUCache {

    private int cap, minFreq;
    private Map<Integer, Map.Entry<Integer, Integer>> m = new HashMap<>();  // key - value, freq
    private Map<Integer, List<Integer>> freq = new HashMap<>(); // freq - keys
    private Map<Integer, Integer> iter = new HashMap<>(); // key - key_pos in freq

    public LFUCache(int capacity) {
        cap = capacity;
    }

    public int get(int key) {
        if (!m.containsKey(key)) return -1;
        freq.get(m.get(key).getValue()).remove((int)iter.get(key));
        m.put(key, Pair.of(m.get(key).getKey(), m.get(key).getValue()+1));
        if (!freq.containsKey(m.get(key).getValue()))
            freq.put(m.get(key).getValue(), new ArrayList<>());
        freq.get(m.get(key).getValue()).add(key);
        iter.put(key, freq.get(m.get(key).getValue()).size()-1);
        if (freq.get(minFreq).size() == 0) ++minFreq;
        return m.get(key).getKey();
    }

    public void put(int key, int value) {
        if (cap <= 0) return;
        if (get(key) != -1) {
            m.put(key, Pair.of(value, 1));
            return;
        }
        if (m.size() >= cap) {
            m.remove(freq.get(minFreq).get(0));
            iter.remove(freq.get(minFreq).get(0));
            freq.get(minFreq).remove(0);
        }
        m.put(key, Pair.of(value, 1));
        if (!freq.containsKey(1)) freq.put(1, new ArrayList<>());
        freq.get(1).add(key);
        iter.put(key, freq.get(1).size() - 1);
        minFreq = 1;
    }

    public static void main(String[] args) {
        LFUCache cache = new LFUCache( 2 /* capacity */ );
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));       // returns 1
        cache.put(3, 3);    // evicts key 2
        System.out.println(cache.get(2));       // returns -1 (not found)
        System.out.println(cache.get(3));       // returns 3.
        cache.put(4, 4);    // evicts key 1.
        System.out.println(cache.get(1));       // returns -1 (not found)
        System.out.println(cache.get(3));       // returns 3
        System.out.println(cache.get(4));       // returns 4
    }

}
