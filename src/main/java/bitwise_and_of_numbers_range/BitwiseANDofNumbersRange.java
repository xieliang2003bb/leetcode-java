package bitwise_and_of_numbers_range;

public class BitwiseANDofNumbersRange {

    public class Solution {
        public int rangeBitwiseAnd(int m, int n) {
            int d = Integer.MAX_VALUE;
            while ((m & d) != (n & d)) {
                d <<= 1;
            }
            return m & d;

        }
    }
}

