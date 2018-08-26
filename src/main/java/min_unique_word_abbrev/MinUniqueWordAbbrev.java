package min_unique_word_abbrev;

import javafx.util.Pair;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by lxie on 8/26/18.
 */
public class MinUniqueWordAbbrev {

    public class Solution {
        public String minAbbreviation(String target, String[] dictionary) {
            if (dictionary.length == 0) return Integer.toString((int)target.length());
            //priority_queue<pair<int, string>, vector<pair<int, string>>, greater<pair<int, string>>> q;
            PriorityQueue<Pair<Integer, String>> q;
            q = generate(target);
            while (!q.isEmpty()) {
                Pair<Integer, String> t = q.peek(); q.poll();
                boolean no_conflict = true;
                for (String word : dictionary) {
                    if (valid(word, t.getValue())) {
                        no_conflict = false;
                        break;
                    }
                }
                if (no_conflict) return t.getValue();
            }
            return "";
        }


        private PriorityQueue<Pair<Integer, String>> generate(String target) {
            PriorityQueue<Pair<Integer, String>> res = new PriorityQueue<>(50, new Comparator<Pair<Integer, String>>() {
                @Override
                public int compare(Pair<Integer, String> o1, Pair<Integer, String> o2) {
                    return o1.getKey() - o2.getKey();
                }
            });
            for (int i = 0; i < Math.pow(2, target.length()); ++i) {
                String out = "";
                int cnt = 0, size = 0;
                for (int j = 0; j < target.length(); ++j) {
                    if (((i >> j) & 1) != 0) ++cnt;
                    else {
                        if (cnt != 0) {
                            out += Integer.toString(cnt);
                            cnt = 0;
                            ++size;
                        }
                        out += target.charAt(j);
                        ++size;
                    }
                }
                if (cnt > 0) {
                    out += Integer.toString(cnt);
                    ++size;
                }
                res.add(new Pair<Integer, String>(size, out));
            }
            return res;
        }

        private boolean valid(String word, String abbr) {
            int m = word.length(), n = abbr.length(), p = 0, cnt = 0;
            for (int i = 0; i < abbr.length(); ++i) {
                if (abbr.charAt(i) >= '0' && abbr.charAt(i) <= '9') {
                    if (cnt == 0 && abbr.charAt(i) == '0') return false;
                    cnt = 10 * cnt + abbr.charAt(i) - '0';
                } else {
                    p += cnt;
                    if (p >= m || word.charAt(p++) != abbr.charAt(i)) return false;
                    cnt = 0;
                }
            }
            return p + cnt == m;
        }
    }

    public class UnitTest {


    }
}
