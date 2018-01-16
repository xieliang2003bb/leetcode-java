package implement_trie;

public class ImplementTrie {

    class TrieNode {
        public TrieNode[] child = new TrieNode[26];
        public boolean isWord;

        public void TrieNode() {
            for (TrieNode a : child) a = null;
        }

    }

    public class Trie {
        private TrieNode root = null;

        public Trie() {
            root = new TrieNode();
        }

        // Inserts a word into the trie.
        public void insert(String s) {
            TrieNode p = root;
            for (char a : s.toCharArray()) {
                int i = a - 'a';
                if (p.child[i] == null)
                    p.child[i] = new TrieNode();
                p = p.child[i];
            }
            p.isWord = true;
        }

        // Returns if the word is in the trie.
        public boolean search(String key) {
            TrieNode p = root;
            for (char a : key.toCharArray()) {
                int i = a - 'a';
                if (p.child[i] == null) return false;
                p = p.child[i];
            }
            return p.isWord;
        }

        // Returns if there is any word in the trie
        // that starts with the given prefix.
        public boolean startsWith(String prefix) {
            TrieNode p = root;
            for (char a : prefix.toCharArray()) {
                int i = a - 'a';
                if (p.child[i] == null) return false;
                p = p.child[i];
            }
            return true;
        }

    }

}

