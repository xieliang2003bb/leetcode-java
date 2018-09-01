package design_search_autocomplete_system;

import javafx.util.Pair;

import java.util.*;

/**
 * Created by lxie on 9/1/18.
 */
public class SearchAutoComplete {

    public Map<String, Integer> freq = new HashMap<>();
    public String data = null;

    public void SearchAutoComplete(String[] sentences, int[] times) {
        for (int i = 0; i < sentences.length; ++i) {
            if (freq.containsKey(sentences[i]))
               freq.put(sentences[i], freq.get(sentences[i])+times[i]);
            else
               freq.put(sentences[i], times[i]);
        }
        data = "";
    }

    public List<String> input(char c) {
        if (c == '#') {
            if (freq.containsKey(data))
                freq.put(data, freq.get(data)+1);
            else
                freq.put(data, 1);
            data = "";
            return null;
        }
        data += c;
        PriorityQueue<Pair<String, Integer>> q = new PriorityQueue<>(50, new Comparator<Pair<String, Integer>>() {
            @Override
            public int compare(Pair<String, Integer> o1, Pair<String, Integer> o2) {
                if (o1.getValue() != o2.getValue())
                    return o1.getValue() - o1.getValue();
                else
                    return o1.getKey().compareTo(o2.getKey());
            }});

        for (Map.Entry<String, Integer> f : freq.entrySet()) {
            boolean matched = true;
            for (int i = 0; i < data.length(); ++i) {
                if (data.toCharArray()[i] != f.getKey().toCharArray()[i]) {
                    matched = false;
                    break;
                }
            }
            if (matched) {
                q.add(new Pair<String, Integer>(f.getKey(), f.getValue()));
                if (q.size() > 3) q.poll();
            }
        }
        List<String> res = new ArrayList<>();
        for (int i = q.size() - 1; i >= 0; --i) {
            res.add(q.peek().getKey()); q.poll();
        }
        return res;
    }

}
