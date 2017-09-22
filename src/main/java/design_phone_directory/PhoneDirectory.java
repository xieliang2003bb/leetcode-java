package design_phone_directory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lxie on 9/22/17.
 */
public class PhoneDirectory {

    private int max_num, next, idx;
    private List<Integer> recycle = new ArrayList<>();
    private List<Boolean> flag = new ArrayList<>();

    /** Initialize your data structure here
     @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
    public PhoneDirectory(int maxNumbers) {
        max_num = maxNumbers;
        next = idx = 0;
        for (int i=0; i<maxNumbers; i++){
            flag.add(true);
        }
    }

    /** Provide a number which is not assigned to anyone.
     @return - Return an available number. Return -1 if none is available. */
    public int get() {
        if (next == max_num && idx <= 0) return -1;
        if (idx > 0) {
            int t = recycle.get(--idx);
            flag.set(t, false);
            return t;
        }
        flag.set(next, false);
        return next++;
    }

    /** Check if a number is available or not. */
    public boolean check(int number) {
        return number >= 0 && number < max_num && flag.get(number);
    }

    /** Recycle or release a number. */
    public void release(int number) {
        if (number >= 0 && number < max_num && !flag.get(number)) {
            recycle.add(number);
            idx++;
            flag.set(number, true);
        }
    }



    public static void main(String[] args) {
        System.out.println("this is for test");
        PhoneDirectory phones = new PhoneDirectory(3);
        System.out.println("directory.get() ->" + phones.get());
        System.out.println("directory.get() ->" + phones.get());
        System.out.println("directory.check(2) ->" + phones.check(2));
        System.out.println("directory.get() ->" + phones.get());
        System.out.println("directory.check(2) ->" + phones.check(2));
        System.out.println("directory.release(2) ->");
        phones.release(2);
        System.out.println("directory.check(2) ->" + phones.check(2));
    }

}
