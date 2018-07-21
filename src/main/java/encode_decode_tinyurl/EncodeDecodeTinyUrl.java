package encode_decode_tinyurl;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by lxie on 7/21/18.
 */
public class EncodeDecodeTinyUrl {

    private Map<String, String> short2long = new HashMap<>();
    private Map<String, String> long2short = new HashMap<>();
    private String dict = "";

    public EncodeDecodeTinyUrl(String longUrl) {
        dict = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    }

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        if (long2short.containsKey(longUrl)) {
            return "http://tinyurl.com/" + long2short.get(longUrl);
        }
        int idx = 0;
        String randStr = "";
        for (int i = 0; i < 6; ++i) {
            Random rand = new Random();
            randStr += dict.charAt(rand.nextInt() % 62);
        }
        while (short2long.containsKey(randStr)) {
            Random rand = new Random();
            randStr.toCharArray()[idx] = dict.charAt(rand.nextInt() % 62);
            idx = (idx + 1) % 5;
        }
        short2long.put(randStr, longUrl);
        long2short.put(longUrl, randStr);
        return "http://tinyurl.com/" + randStr;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        String randStr = shortUrl.substring(shortUrl.lastIndexOf("/") + 1);
        return short2long.containsKey(randStr) ? short2long.get(randStr) : shortUrl;
    }

}
