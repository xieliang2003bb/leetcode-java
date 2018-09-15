package implement_magic_dictionary;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by lxie on 9/15/18.
 */
public class MagicDictionary {

    private Set<String> s = new HashSet<>();

    /** Build a dictionary through a list of words */
    public void buildDict(String[] dict) {
        for (String word : dict) s.add(word);
    }

    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    boolean search(String word) {
        char[] word1 = word.toCharArray();
        for (int i = 0; i < word1.length; ++i) {
            char t = word1[i];
            for (char c = 'a'; c <= 'z'; ++c) {
                if (c == t) continue;
                word1[i] = c;
                if (s.contains(new String(word1))) return true;
            }
            word1[i] = t;
        }
        return false;
    }

    public static void main(String[] args) {
        MagicDictionary m = new MagicDictionary();
        String[] dict = {"hello", "leetcode"};
        m.buildDict(dict);
        System.out.println(m.search("hello"));
        System.out.println(m.search("hhllo"));
        System.out.println(m.search("hell"));
        System.out.println(m.search("leetcoded"));
    }

}
