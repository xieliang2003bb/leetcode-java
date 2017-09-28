package insert_delete_random_II;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lxie on 9/23/17.
 */
public class RandomizedCollection {
    private Map<Integer, List<Integer>> map;
    private List<int[]> nums;

    /** Initialize your data structure here. */
    public RandomizedCollection() {
        map = new HashMap<>();
        nums = new ArrayList<>();
    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        boolean res = !map.containsKey(val);
        if(res) map.put(val, new ArrayList<>());
        map.get(val).add(nums.size());
        nums.add(new int[]{val, map.get(val).size() - 1});
        return res;
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        boolean res = map.containsKey(val);
        if(res) {
            List<Integer> valList = map.get(val);
            int valLastIndex = valList.get(valList.size() - 1); // always take the last one

            int[] swapNum = nums.get(nums.size() - 1);
            int swapVal = swapNum[0], swapIndex = swapNum[1];

            map.get(swapVal).set(swapIndex, valLastIndex);  // set it to same pos
            nums.set(valLastIndex, swapNum);

            if(valList.size() == 1) map.remove(val);
            else valList.remove(valList.size() - 1);

            nums.remove(nums.size() - 1);
        }
        return res;
    }

    /** Get a random element from the collection. */
    int getRandom() {
        return nums.get((int)Math.random() % nums.size())[0];
    }

    public static void main(String[] args) {
        System.out.println("this is for test");
        /* RandomizedCollection randomSet = new RandomizedCollection();

        // Inserts 1 to the set. Returns true as 1 was inserted successfully.
        System.out.println("randomSet.insert(1) -> " + randomSet.insert(1));

        // Returns false as 2 does not exist in the set.
        System.out.println("randomSet.remove(2) -> " + randomSet.remove(2));

        // Inserts 2 to the set, returns true. Set now contains [1,2].
        System.out.println("randomSet.insert(2) -> " + randomSet.insert(2));

        // getRandom should return either 1 or 2 randomly.
        System.out.println("randomSet.getRandom() -> " + randomSet.getRandom());

        // Removes 1 from the set, returns true. Set now contains [2].
        System.out.println("randomSet.remove(1) -> " + randomSet.remove(1));

        // 2 was already in the set, so return false.
        System.out.println("randomSet.insert(2) -> " + randomSet.insert(2));

        // Since 2 is the only number in the set, getRandom always return 2.
        System.out.println("randomSet.getRandom() -> " + randomSet.getRandom()); */

    }

}
