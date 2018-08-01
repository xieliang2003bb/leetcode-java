package palindrome_partitioning;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

    public static class Solution {

        public List<List<String>> partition(String s) {
            List<List<String>> res = new ArrayList<>();
            List<String> out = new ArrayList<>();
            partitionDFS(s, 0, out, res);
            return res;
        }

        public void partitionDFS(String s, int start, List<String> out, List<List<String>> res) {
            if (start == s.length()) {
                res.add(new ArrayList<>(out));
                return;
            }
            for (int i = start; i < s.length(); ++i) {
                if (isPalindrome(s, start, i)) {
                    out.add(s.substring(start, i+1));
                    partitionDFS(s, i + 1, out, res);
                    out.remove(out.size()-1);
                }
            }
        }

        private boolean isPalindrome(String s, int start, int end) {
            while (start < end) {
                if (s.charAt(start) != s.charAt(end)) return false;
                ++start;
                --end;
            }
            return true;
        }

    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.partition("aab"));
    }
}
