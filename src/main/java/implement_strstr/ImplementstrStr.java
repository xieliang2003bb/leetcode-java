package implement_strstr;

public class ImplementstrStr {

    public class Solution {
        public String strStr(String haystack, String needle) {
            if (haystack == null || needle == null) {
                return null;
            }
            for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
                boolean find = true;
                for (int j = 0; j < needle.length(); j++) {
                    if (haystack.charAt(i + j) != needle.charAt(j)) {
                        find = false;
                        break;
                    }
                }
                if (find) {
                    return haystack.substring(i);
                }
            }
            return null;
        }
    }

    public static class UnitTest {

    }
}
