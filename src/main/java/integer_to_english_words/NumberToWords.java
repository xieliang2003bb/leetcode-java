package integer_to_english_words;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by lxie on 6/13/18.
 */
public class NumberToWords {

    public static class Solution {

        String numberToWords(int num) {
            String res = convertHundred(num % 1000);
            List<String> v = new ArrayList<>(Arrays.asList("Thousand", "Million", "Billion"));
            for (int i = 0; i < 3; ++i) {
                num /= 1000;
                res = num % 1000 != 0 ? convertHundred(num % 1000) + " " + v.get(i) + " " + res : res;
            }
            while (res.charAt(res.length()-1) == ' ') res.substring(0, res.length()-1);
            return res.isEmpty() ? "Zero" : res;
        }
        String convertHundred(int num) {
            List<String> v1 = new ArrayList<>(Arrays.asList("", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"));
            List<String> v2 = new ArrayList<>(Arrays.asList("", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"));
            String res;
            int a = num / 100, b = num % 100, c = num % 10;
            res = b < 20 ? v1.get(b) : v2.get(b / 10) + (c != 0 ? " " + v1.get(c) : "");
            if (a > 0) res = v1.get(a) + " Hundred" + (b != 0 ? " " + res : "");
            return res;
        }
    }

    public static void main(String[] args) {
        System.out.println("this is for test");
        Solution sol = new Solution();

        System.out.println(sol.numberToWords(1234567));

    }

}
