package employee_importance;

import java.util.*;

/**
 * Created by lxie on 8/18/18.
 */


// Employee info
class Employee {
    // It's the unique id of each node;
    // unique id of this employee
    public int id;
    // the importance value of this employee
    public int importance;
    // the id of direct subordinates
    public List<Integer> subordinates;
};


public class EmployeeImportance {

    public class Solution {
        public int getImportance(List<Employee> employees, int id) {
            Set<Integer> s = new HashSet<>();
            Map<Integer, Employee> m = new HashMap<>();
            for (Employee e : employees)
                m.put(e.id, e);   // fast find
            return helper(id, m, s);
        }

        private int helper(int id, Map<Integer, Employee> m, Set<Integer> s) {
            if (s.contains(id)) return 0;
            s.add(id);
            int res = m.get(id).importance;
            for (int num : m.get(id).subordinates) {
                res += helper(num, m, s);
            }
            return res;
        }
    }

    public class UnitTest {


    }

}
