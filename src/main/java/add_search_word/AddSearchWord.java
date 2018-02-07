package add_search_word;

/**
 * Created by lxie on 2/7/18.
 */
public class AddSearchWord {

    public class WordDictionary {

        class TrieNode {
            public TrieNode[] child = new TrieNode[26];
            public boolean isWord;

            public void TrieNode() {
                for (TrieNode a : child) a = null;
            }

        }

        public TrieNode root;

        public void WordDictionary(){
            root = new TrieNode();
        }

        public void addWord(String word) {
            TrieNode p = root;
            for (char a : word.toCharArray()) {
                int i = a - 'a';
                if (p.child[i] == null) p.child[i] = new TrieNode();
                p = p.child[i];
            }
            p.isWord = true;
        }

        public boolean search(String word) {
            return searchWord(word, root, 0);
        }

        // use recursion for search to deal with wildcards
        private boolean searchWord(String word, TrieNode p, int i) {
            if (i == word.length()) return p.isWord;
            if (word.toCharArray()[i] == '.') {
                for (TrieNode a : p.child) {
                    if (a != null && searchWord(word, a, i + 1)) return true;
                }
                return false;
            } else {
                return p.child[word.toCharArray()[i] - 'a'] != null &&
                        searchWord(word, p.child[word.toCharArray()[i] - 'a'], i + 1);
            }
        }

    }

    public static class UnitTest {


    }
    
}
