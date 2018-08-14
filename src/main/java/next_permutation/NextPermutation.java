package next_permutation;

public class NextPermutation {

    public class Solution {

        public void nextPermutation(int[] num) {
            int i, j, n = num.length;
            for (i = n - 2; i >= 0; --i) {
                if (num[i + 1] > num[i]) {
                    for (j = n - 1; j >= i; --j) {
                        if (num[j] > num[i]) break;
                    }
                    int tmp = num[i];
                    num[i] = num[j];
                    num[j] = tmp;
                    reverse(num, i + 1, num.length-1);
                    return;
                }
            }
            reverse(num, 0, num.length-1);

        }

        private void reverse(int[] a, int start, int end) {
            if (a.length == 0 || a.length == 1) return;
            while (start < end) {
                int tmp = a[start];
                a[start] = a[end];
                a[end] = tmp;
                start++; end--;
            }

        }
    }

    public static class UnitTest {

    }
}
