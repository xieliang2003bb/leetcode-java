package sort_colors;

public class SortColors {

    public class Solution {
        public void sortColors(int[] A) {
            int red = 0, blue = A.length - 1;
            for (int i = 0; i <= blue; ++i) {
                if (A[i] == 0) {
                    int tmp = A[red];
                    A[red] = A[i];
                    A[i] = tmp;
                    red++;
                    //swap(A[i], A[red++]);
                } else if (A[i] == 2) {
                    int tmp = A[i];
                    A[i] = A[blue];
                    A[blue] = tmp;
                    i--; blue--;
                    //swap(A[i--], A[blue--]);
                }
            }

        }
    }

    public static class UnitTest {

    }
}
