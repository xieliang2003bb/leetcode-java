package find_permutation;

/**
 * Created by lxie on 8/28/18.
 */
public class FindPermutation {
    public int[] findPermutation(String s) {
        int n = s.length();
        int[] res = new int[n+1];
        for (int i = 0; i < n + 1; ++i) res[i] = i + 1;
        for (int i = 0; i < n; ++i) {
            if (s.charAt(i) == 'D') {
                int j = i;
                while (s.charAt(i) == 'D' && i < n) ++i;
                reverse(res, j, i );
                --i;
            }
        }
        return res;
    }

    private void reverse(int[] a, int i, int j) {
        while (i < j) {
            int t = a[j];
            a[j] = a[i];
            a[i] = t;
            i++; j--;
        }
    }

    public static void main(String[] args) {
        FindPermutation f = new FindPermutation();
        int[] res = f.findPermutation("DDIIDI");
        System.out.println(res);
    }

}
