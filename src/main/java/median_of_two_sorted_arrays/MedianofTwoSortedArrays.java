package median_of_two_sorted_arrays;

public class MedianofTwoSortedArrays {

    public class Solution {
        private double findMedianSortedArrays(int A[], int left, int right,
                int B[]) {
            if (left > right) {
                return findMedianSortedArrays(B,
                        Math.max(0, (A.length + B.length) / 2 - A.length),
                        Math.min(B.length - 1, (A.length + B.length) / 2), A);
            }
            int i = (left + right) / 2;
            int j = (A.length + B.length) / 2 - i - 1;

            if (j >= 0 && A[i] < B[j]) {
                return findMedianSortedArrays(A, i + 1, right, B);
            }
            if (j < B.length - 1 && A[i] > B[j + 1]) {
                return findMedianSortedArrays(A, left, i - 1, B);
            }

            if ((A.length + B.length) % 2 == 0) {
                if (i > 0) {
                    int pre = j < 0 ? A[i - 1] : Math.max(A[i - 1], B[j]);
                    return (A[i] + pre) / 2.0;
                } else {
                    return (A[i] + B[j]) / 2.0;
                }
            } else {
                return A[i];
            }
        }

        public double findMedianSortedArrays(int A[], int B[]) {
            return findMedianSortedArrays(A,
                    Math.max(0, (A.length + B.length) / 2 - B.length),
                    Math.min(A.length - 1, (A.length + B.length) / 2), B);
        }
    }

    public static class UnitTest {

    }
}
