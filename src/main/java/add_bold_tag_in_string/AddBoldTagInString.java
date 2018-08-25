package add_bold_tag_in_string;

/**
 * Created by lxie on 8/25/18.
 */
public class AddBoldTagInString {

    public String addBoldTag(String s, String[] dict) {
        String res = "";
        int n = s.length(), end = 0;
        boolean[] bold = new boolean[n];
        for (int i = 0; i < n; ++i) {
            for (String word : dict) {
                int len = word.length();
                if (i + len <= n && s.substring(i, i+len).equals(word)) {
                    end = Math.max(end, i + len);
                }
            }
            bold[i] = end > i;
        }
        for (int i = 0; i < n; ++i) {
            if (!bold[i]) {
                res += (s.charAt(i));
                continue;
            }
            int j = i;
            while (j < n && bold[j]) ++j;
            res += "<b>" + s.substring(i, j) + "</b>";
            i = j-1;
        }
        return res;
    }

    public static void main(String[] args) {

        AddBoldTagInString as = new AddBoldTagInString();
        String[] dict = {"abc","123"};  //{"aaa","aab","bc"};
        System.out.println(as.addBoldTag("abcxyz123", dict));

    }

}
