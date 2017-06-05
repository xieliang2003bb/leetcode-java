package palindrome_permutation;

import java.util.HashMap;
import java.util.Map;


public class PalindromePermutation {

  public class Solution {
    public boolean palindromePermutation(String s) {
      Map<Character, Integer> m  = new HashMap<>();
      int cnt = 0;
      for (char a : s.toCharArray()) {
        if(m.containsKey(a)) {
          m.put(a, m.get(a)+1);
        } else {
          m.put(a, 1);
        }
      }
      for (Map.Entry<Character, Integer> entry : m.entrySet()) {
        if (entry.getValue() % 2 != 0) ++cnt;
      }
      return cnt == 0 || (s.length() % 2 == 1 && cnt == 1);
    }
  }

  public static class UnitTest {

  }

}
