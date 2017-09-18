package queue_reconstruct_by_height;

import java.util.*;

/**
 * Created by lxie on 9/17/17.
 */
public class QueueReconsByHeight {

    public static class Solution {
        public int[][] reconstructQueue(int[][] people) {
            List<int[]> peopleL = new LinkedList<int[]>(Arrays.asList(people));
            Collections.sort(peopleL, new Comparator<int[]>(){
                public int compare(int[] arr1, int[] arr2){
                    if(arr1[0] == arr2[0])
                        return arr1[1] - arr2[1];
                    else
                        return arr2[0] - arr1[0];
                }
            });

            for (int i = 0; i < peopleL.size(); i++) {
                int[] p = peopleL.get(i);
                if (p[1] != i) {
                    peopleL.remove(i);
                    peopleL.add(p[1], p);
                }
            }

            return peopleL.toArray(new int[peopleL.size()][2]);
        }

    }

    public static void main(String[] args) {
        System.out.println("this is for test");
        Solution sol = new Solution();
        int[][] people = {{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}};
        int[][] res = sol.reconstructQueue(people);
        System.out.println(res.toString());
    }

}
