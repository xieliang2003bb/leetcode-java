package replace_words;

import java.util.List;

/**
 * Created by lxie on 8/18/18.
 */
public class RepaceWords {

    class Solution {

        private class TreeNode{
            private boolean isWord;
            private TreeNode[] children;

            public TreeNode() {
                isWord = false;
                children = new TreeNode[26];
            }

        }

        public String replaceWords(List<String> dict, String sentence) {
            TreeNode root = buildTrie(dict);
            StringBuilder sb = new StringBuilder();
            int start = 0, end = 0;
            while (start < sentence.length()) {
                if (sentence.charAt(start) == ' ') {
                    sb.append(' ');
                    start++;
                } else {
                    end = start;
                    while (end < sentence.length() && sentence.charAt(end) != ' ') {
                        end++;
                    }
                    String word = sentence.substring(start, end);
                    String prefix = findPrefix(root, word);
                    sb.append(prefix.isEmpty() ? word : prefix);
                    start = end;
                }
            }
            return sb.toString();
        }

        private TreeNode buildTrie(List<String> dict) {
            TreeNode root = new TreeNode();
            for (String word: dict) {
                TreeNode node = root;
                for (char ch: word.toCharArray()) {
                    if (node.children[ch - 'a'] == null)
                        node.children[ch - 'a'] = new TreeNode();
                    node = node.children[ch - 'a'];
                }
                node.isWord = true;

            }
            return root;
        }

        private String findPrefix(TreeNode root, String word) {
            TreeNode node = root;
            StringBuilder sb = new StringBuilder();
            for (char ch : word.toCharArray()) {
                if (node.isWord || node.children[ch - 'a'] == null)
                    break;

                sb.append(ch);
                node = node.children[ch - 'a'];
            }

            return node.isWord ? sb.toString() : "";
        }
    }


}
