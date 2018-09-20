package find_k_closest_elements;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lxie on 9/20/18.
 */
public class FindKClosestElements {

    public class Solution {

        public List<Integer> findClosestElements(int[] arr, int k, int x) {
            int left = 0, right = arr.length - k;
            List<Integer> res = new ArrayList<>();
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (x - arr[mid] > arr[mid + k] - x) left = mid + 1;
                else right = mid;
            }
            for(int i = left; i<= left+k; ++i) res.add(arr[i]);
            return res;
        }
    }

    public class UnitTest {


    }


}
