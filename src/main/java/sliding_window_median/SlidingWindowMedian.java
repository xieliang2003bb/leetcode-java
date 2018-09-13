package sliding_window_median;

import com.google.common.primitives.Doubles;

import java.util.*;

/**
 * Created by lxie on 9/10/18.
 */
public class SlidingWindowMedian {

    public double[] medianSlidingWindow(int[] nums, int k) {
        List<Double> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return Doubles.toArray(res);
        }
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
            public int compare(Integer x, Integer y) {
                return y - x;
            }
        });

        double curMedian;
        if (k > 1) {
            maxHeap.add(nums[0]);
            for (int i = 1; i < k - 1; i++) {
                int x = maxHeap.peek();
                if (nums[i] <= x) {
                    maxHeap.add(nums[i]);
                } else {
                    minHeap.add(nums[i]);
                }
            }
            curMedian = maxHeap.peek();
        } else {
            curMedian = 0;
        }

        for (int i = k - 1; i < nums.length; i++) {
            if (nums[i] <= curMedian) {
                maxHeap.add(nums[i]);
            } else {
                minHeap.add(nums[i]);
            }
            while (maxHeap.size() > minHeap.size()+1) {
                minHeap.add(maxHeap.poll());
            }
            while (maxHeap.size() < minHeap.size()) {
                maxHeap.add(minHeap.poll());
            }
            curMedian = maxHeap.peek();
            res.add(curMedian);
            if (nums[i - k + 1] <= curMedian) {
                maxHeap.remove(nums[i - k + 1]);
            } else {
                minHeap.remove(nums[i - k + 1]);
            }
        }

        return Doubles.toArray(res);
    }

    public static void main(String[] args) {
        SlidingWindowMedian s = new SlidingWindowMedian();
        int[] a = {1,3,-1,-3,5,3,6,7};
        double[] res = s.medianSlidingWindow(a, 3);
        System.out.println("result is " + Arrays.toString(res));

    }

}
