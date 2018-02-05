package repeated_dna_sequences;

import java.util.*;

public class RepeatedDNASequences {

    public class Solution {
        public List<String> findRepeatedDnaSequences1(String s) {
            if (s.length() < 10) return new ArrayList<>();
            char[] si = s.toCharArray();
            Set<String> res = new HashSet<>();
            Set<Integer> st= new HashSet<>();
            Map<Character, Integer> m = new HashMap<> ();
            m.put('A', 0); m.put('C', 1); m.put('G', 2); m.put('T', 3);
            int cur = 0, i = 0;
            while (i < 9) cur = cur << 2 | m.get(si[i++]);
            while (i < s.length()) {
                cur = ((cur & 0x3ffff) << 2) | (m.get(si[i++])); // 20 bits for 10-letter-long
                if (st.contains(cur)) res.add(s.substring(i - 10, i));
                else st.add(cur);
            }
            return new ArrayList<>(res);

        }

    }

    public static class UnitTest {

    }
}

