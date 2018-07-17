package sentence_similarity;

import javafx.util.Pair;

import java.util.*;

/**
 * Created by lxie on 7/17/18.
 */
public class SentenceSimilarity {

    public boolean areSentencesSimilar(String[] words1, String[] words2, List<Pair<String, String>> pairs) {
        if (words1.length != words2.length) return false;
        Map<String, Set<String>> m = new HashMap<>();

        for (Pair<String, String> pair : pairs) {
            //m[pair.first].insert(pair.second);
            if (!m.containsKey(pair.getKey())) {
                m.put(pair.getKey(), new HashSet<>(Arrays.asList(pair.getValue())));
            } else {
                m.get(pair.getKey()).add(pair.getValue());
            }
        }
        for (int i = 0; i < words1.length; ++i) {
            if (words1[i] == words2[i]) continue;
            if((m.containsKey(words1[i]) && m.get(words1[i]).contains(words2[i])) ||
            (m.containsKey(words2[i]) && m.get(words2[i]).contains(words1[i]))) continue;
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        SentenceSimilarity ss = new SentenceSimilarity();
        String[] words1 = {"great", "acting", "skills"};
        String[] words2 = {"fine","drama", "talent"};
        List<Pair<String, String>> pairs = new ArrayList<>();
        pairs.add(new Pair<>("great", "fine"));
        pairs.add(new Pair<>("acting", "drama"));
        pairs.add(new Pair<>("skills", "talent"));

        System.out.println(ss.areSentencesSimilar(words1, words2, pairs));

    }
}
