package isomorphic_strings;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {

    public class Solution {
        public boolean isIsomorphic(String str1, String str2) {
            if (str1 == null || str2 == null) {
                return false;
            }
            else if (str1.length() != str2.length()) {
                return false;
            }
            else if (str1.length() < 2) {
                // lengths are equal; empty string & 1 character strings are isomorphic
                return true;
            }
            else {
                char[] str1Chars = str1.toCharArray();
                char[] str2Chars = str2.toCharArray();

                Map<Character, Character> isoMap = new HashMap<Character, Character>();
                Map<Character, Character> isoMapRev = new HashMap<Character, Character>();


                int length = str1Chars.length;
                for (int index = 0; index < length; index++) {

                    Character aCharacterFromFirstWord = str1Chars[index];
                    Character aCharacterFromSecondWord = str2Chars[index];

                    if (isoMap.containsKey(aCharacterFromFirstWord)) {
                        if (!isoMap.get(aCharacterFromFirstWord).equals(aCharacterFromSecondWord)) {
                            return false;
                        }
                    }
                    else if (isoMapRev.containsKey(aCharacterFromSecondWord)) {
                        return false;
                    } else {
                        isoMap.put(aCharacterFromFirstWord, aCharacterFromSecondWord);
                        isoMapRev.put(aCharacterFromSecondWord, aCharacterFromFirstWord);
                    }
                }
                return true;
            }

        }
    }
}

