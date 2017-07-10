package palindrome_permutation_ii;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PalindromePermutationII {

  public class Solution {

    public List<String> generatePalindrome(String s) {
      List<String> res = new ArrayList<>();
      Map<Character, Integer> m = new HashMap<>();
      String t = "", mid = "";
      for (Character a : s.toCharArray()) {
        if (m.containsKey(a)) {
          m.put(a, m.get(a) + 1);
        } else {
          m.put(a, 1);
        }
      }
      for (Map.Entry<Character, Integer> e : m.entrySet()) {
        if (e.getValue() % 2 == 1) mid += e.getKey();
        t += new String(new char[e.getValue() / 2]).replace("\0", e.getKey().toString());
        if (mid.length() > 1) return res;
      }
      permute(t, 0, mid, res);
      return res;
    }

    public void permute(String t, int start, String mid, List<String> res) {
      if (start >= t.length()) {
        res.add(t + mid + new StringBuffer(t).reverse());
      }
      for (int i = start; i < t.length(); ++i){
        if (i != start && t.charAt(i) == t.charAt(start)) continue;
        swap(t, i, start); //t.charAt(i), t.charAt(start));
        permute(t, start+1, mid, res);
        swap(t, i, start); //.charAt(i), t.charAt(start));
      }
    }

    private String swap(String s, int a, int b) {
      char[] chars = s.toCharArray();
      char tmp = chars[a];
      chars[a] = chars[b];
      chars[b] = tmp;
      return new String(chars);
    }

  }

  public static class UnitTest {

  }

}
