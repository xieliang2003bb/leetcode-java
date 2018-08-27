package optimal_account_balance;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lxie on 8/26/18.
 */
public class OptimalAccountBalancing {

    public int minTransfers(int[][] transactions) {
        Map<Integer, Integer> m = new HashMap<>();
        for (int[] t : transactions) {
            if(m.containsKey(t[0]))
                m.put(t[0], m.get(t[0]) - t[2]);
            else
                m.put(t[0], -t[2]);

            if(m.containsKey(t[1]))
                m.put(t[1], m.get(t[1]) + t[2]);
            else
                m.put(t[1], t[2]);
        }

        List<Integer> accnt = new ArrayList<>();
        for (Map.Entry<Integer, Integer> a : m.entrySet()) {
            if (a.getValue() != 0) accnt.add(a.getValue());
        }
        return helper(accnt, 0, accnt.size(), 0);
    }

    private int helper(List<Integer> accnt, int start, int n, int num) {
        int res = Integer.MAX_VALUE;
        while (start < n && accnt.get(start) == 0) ++start;
        for (int i = start + 1; i < n; ++i) {
            if ((accnt.get(i) < 0 && accnt.get(start) > 0) || (accnt.get(i) > 0 && accnt.get(start) < 0)) {
                accnt.set(i, accnt.get(i) + accnt.get(start));  // start set to 0 and update i
                res = Math.min(res, helper(accnt, start + 1, n, num + 1));
                accnt.set(i, accnt.get(i) - accnt.get(start));
            }
        }
        return res == Integer.MAX_VALUE ? num : res;
    }

    public static void main(String[] args) {

        OptimalAccountBalancing ob = new OptimalAccountBalancing();
        int[][] transactions = {{0,1,10}, {2,0,5}}; // {{0,1,10}, {1,0,1}, {1,2,5}, {2,0,5}};
        System.out.println(ob.minTransfers(transactions));


    }





}
