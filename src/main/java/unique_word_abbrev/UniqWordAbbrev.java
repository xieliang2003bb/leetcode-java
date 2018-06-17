package unique_word_abbrev;


import java.util.*;

/**
 * Created by lxie on 6/17/18.
 */
public class UniqWordAbbrev {

    Map<String, Set<String>> m = new HashMap<>();

    public void ValidWordAbbr(List<String> dictionary) {
        for (String a : dictionary) {
            String k = a.charAt(0) + Integer.toString(a.length() - 2) + a.charAt(a.length()-1);
            if (m.containsKey(k)) {
                m.get(k).add(a);
            } else {
                m.put(k, new HashSet<String>(Arrays.asList(a)));
            }
        }
    }

    public boolean isUnique(String word) {
        String k = word.charAt(0) + Integer.toString(word.length() - 2) + word.charAt(word.length()-1);
        if (m.containsKey(k)) {
            return (m.get(k).contains(word) ? 1 : 0) == m.get(k).size();
        } else {
            return true;
        }
    }

    public static void main(String[] args) {
        System.out.println("this is for test");
        List<String> dict = new ArrayList<>(Arrays.asList("deer", "door", "cake", "card"));
        UniqWordAbbrev u = new UniqWordAbbrev();
        u.ValidWordAbbr(dict);

        System.out.println(u.isUnique("dear"));
        System.out.println(u.isUnique("cart"));
        System.out.println(u.isUnique("cane"));
        System.out.println(u.isUnique("make"));

    }


}
