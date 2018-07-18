package compressed_string_iterator;

/**
 * Created by lxie on 7/18/18.
 */
public class CompressedStringIterator {

    private static String s;
    private int n = 0, i = 0, cnt = 0;
    private char c;

    public CompressedStringIterator(String compressedString) {
        s = compressedString;
        n = s.length();
        c = ' ';
    }

    public char next() {
        if (hasNext()) {
            --cnt;
            return c;
        }
        return ' ';
    }

    public boolean hasNext() {
        if (cnt > 0) return true;
        if (i >= n) return false;
        c = s.charAt(i++);
        while (i < n && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
            cnt = cnt * 10 + s.charAt(i++) - '0';
        }
        return true;
    }
}




