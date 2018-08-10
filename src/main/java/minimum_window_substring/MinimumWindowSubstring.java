package minimum_window_substring;

public class MinimumWindowSubstring {

    public class Solution {
        public String minWindow(String S, String T) {
            int[] need = new int[256];
            for(int i = 0; i < T.length(); i++)
                need[T.charAt(i)]++;
            int[] found = new int[256];

            int count = 0;
            int minLen = S.length()+1;
            int minBegin = 0;
            for(int begin = 0, end = 0; end < S.length(); ++end){
                char ch = S.charAt(end);
                if(need[ch] == 0) continue;
                if(++found[ch] <= need[ch]) count++;
                if(count == T.length()){
                    while(need[S.charAt(begin)] == 0 ||
                            found[S.charAt(begin)] > need[S.charAt(begin)]){
                        if(found[S.charAt(begin)] > need[S.charAt(begin)])
                            found[S.charAt(begin)]--;
                        begin++;
                    }
                    int leng = end - begin + 1;
                    if(leng < minLen){
                        minLen = leng;
                        minBegin = begin;
                    }
                }
            }
            return minLen > S.length()?"":S.substring(minBegin,minBegin+minLen);
        }

    }

    public static class UnitTest {

    }
}
