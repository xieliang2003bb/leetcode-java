package word_search_ii;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lxie on 2/7/18.
 */
public class WordSearchII {

    public class Solution {

        public class TrieNode {
            public TrieNode[] child = new TrieNode[26];
            public String str;

            public TrieNode() {
                for (TrieNode a : child) a = null;
                str = "";
            }
        }

        public class Trie {
            public TrieNode root;

            public Trie() {
                root = new TrieNode();
            }

            public void insert(String s) {
                TrieNode p = root;
                for (char a : s.toCharArray()) {
                    int i = a - 'a';
                    if (p.child[i] == null) p.child[i] = new TrieNode();
                    p = p.child[i];
                }
                p.str = s;
            }
        }

        public List<String> findWords(char[][] board, String[] words) {
            List<String> res = new ArrayList<>();
            if (words.length == 0 || board.length == 0 || board[0].length == 0) return res;
            boolean[][] visit = new boolean[board.length][board[0].length];

            Trie T = new Trie();
            for (String a : words) T.insert(a);
            for (int i = 0; i < board.length; ++i) {
                for (int j = 0; j < board[i].length; ++j) {
                    if (T.root.child[board[i][j] - 'a'] != null) {
                        search(board, T.root.child[board[i][j] - 'a'], i, j, visit, res);
                    }
                }
            }
            return res;
        }

        private void search(char[][] board, TrieNode p, int i, int j, boolean[][] visit, List<String> res) {
            if (!p.str.isEmpty()) {
                res.add(p.str);
                p.str = "";
            }
            int[][] d = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
            visit[i][j] = true;
            for (int[] a : d) {
                int nx = a[0] + i, ny = a[1] + j;
                if (nx >= 0 && nx < board.length && ny >= 0 && ny < board[0].length
                        && !visit[nx][ny] && p.child[board[nx][ny] - 'a'] != null) {
                    search(board, p.child[board[nx][ny] - 'a'], nx, ny, visit, res);
                }
            }
            visit[i][j] = false;
        }
    }

    public class UnitTest {

    }

}
