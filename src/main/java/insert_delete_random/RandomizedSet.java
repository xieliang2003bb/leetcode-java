package insert_delete_random;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lxie on 9/22/17.
 */
public class RandomizedSet {

    private List<Integer> nums = new ArrayList<>();
    private Map<Integer, Integer> m = new HashMap<>();

    /** Initialize your data structure here. */
    public RandomizedSet() {}

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (m.containsKey(val)) return false;
        nums.add(val);
        m.put(val, nums.size() - 1);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!m.containsKey(val)) return false;
        int last = nums.get(nums.size()-1);
        m.put(last, m.get(val));
        nums.set(m.get(val), last);
        nums.remove(nums.size() - 1);
        m.remove(val);
        return true;
    }

    /** Get a random element from the set. */
    int getRandom() {
        return nums.get((int)Math.random() % nums.size());
    }



    public static void main(String[] args) {
        System.out.println("this is for test");
        RandomizedSet randomSet = new RandomizedSet();

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
        System.out.println("randomSet.getRandom() -> " + randomSet.getRandom());

    }


}
